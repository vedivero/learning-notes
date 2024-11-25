import React, { useState, useRef, useEffect } from "react";
import { loadPaymentWidget, ANONYMOUS } from "@tosspayments/payment-widget-sdk";
import { nanoid } from "nanoid";
import { Container, Row, Col, Form, Button, Modal } from "react-bootstrap";
import OrderReceipt from "../component/OrderReceipt";
import "../style/paymentPage.style.css";
import { useSelector, useDispatch } from "react-redux";
import { useNavigate } from "react-router";
import { cc_expires_format } from "../utils/number";

const TossPaymentPage = () => {
	const dispatch = useDispatch();
	const navigate = useNavigate();
	const [cardValue, setCardValue] = useState({
		cvc: "",
		expiry: "",
		focus: "",
		name: "",
		number: "",
	});
	const [firstLoading, setFirstLoading] = useState(true);
	const [shipInfo, setShipInfo] = useState({
		firstName: "",
		lastName: "",
		contact: "",
		address: "",
		city: "",
		zip: "",
	});
	const { cartList, totalPrice } = useSelector(state => state.cart);

	const [paymentWidget, setPaymentWidget] = useState(null);
	const paymentMethodsWidgetRef = useRef(null);
	const [show, setShow] = useState(false);

	const handleClose = () => setShow(false);
	const handleShow = () => {
		setShow(true);
		initializePaymentWidget();
	};

	const initializePaymentWidget = async () => {
		try {
			const loadedWidget = await loadPaymentWidget(
				"test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm",
				nanoid()
			);
			setPaymentWidget(loadedWidget);

			const paymentMethodsWidget = loadedWidget.renderPaymentMethods(
				"#payment-widget",
				{ value: totalPrice },
				{ variantKey: "DEFAULT" }
			);

			loadedWidget.renderAgreement("#agreement", { variantKey: "AGREEMENT" });

			paymentMethodsWidgetRef.current = paymentMethodsWidget;
		} catch (error) {
			console.error("Error fetching payment widget:", error);
		}
	};

	useEffect(() => {
		if (paymentWidget && paymentMethodsWidgetRef.current) {
			paymentMethodsWidgetRef.current.updateAmount(totalPrice);
		}
	}, [totalPrice]);

	const handleFormChange = (event) => {
		const { name, value } = event.target;
		setShipInfo({ ...shipInfo, [name]: value });
	};

	const handlePaymentInfoChange = (event) => {
		const { name, value } = event.target;
		if (name === "expiry") {
			let newValue = cc_expires_format(value);
			setCardValue({ ...cardValue, [name]: newValue });
			return;
		}
		setCardValue({ ...cardValue, [name]: value });
	};

	const handleInputFocus = (e) => {
		setCardValue({ ...cardValue, focus: e.target.name });
	};

	const handlePaymentRequest = async () => {
		try {
			const queryParams = new URLSearchParams({
				firstName: shipInfo.firstName,
				lastName: shipInfo.lastName,
				contact: shipInfo.contact,
				address: shipInfo.address,
				city: shipInfo.city,
				zip: shipInfo.zip,
				totalPrice: totalPrice.toString(),
				cartList: JSON.stringify(cartList.map(item => ({
					productId: item.productId._id,
					price: item.productId.price,
					qty: item.qty,
					size: item.size
				})))
			});

			await paymentWidget?.requestPayment({
				orderId: nanoid(),
				orderName: "주문명 예시",
				customerName: `${shipInfo.firstName} ${shipInfo.lastName}`,
				customerEmail: "customer@example.com",
				customerMobilePhone: shipInfo.contact,
				successUrl: `${window.location.origin}/tossPayment/success?${queryParams.toString()}`,
				failUrl: `${window.location.origin}/fail`,
			});
		} catch (error) {
			console.error("Error requesting payment:", error);
		}
	};

	if (cartList.length === 0) navigate("/cart");

	return (
		<Container>
			<Row>
				<Col lg={7}>
					<div>
						<h2 className="mb-2">배송 주소</h2>
						<div>
							<Form onSubmit={(e) => { e.preventDefault(); handleShow(); }}>
								<Row className="mb-3">
									<Form.Group as={Col} controlId="lastName">
										<Form.Label>성</Form.Label>
										<Form.Control
											type="text"
											onChange={handleFormChange}
											required
											name="lastName"
										/>
									</Form.Group>

									<Form.Group as={Col} controlId="firstName">
										<Form.Label>이름</Form.Label>
										<Form.Control
											type="text"
											onChange={handleFormChange}
											required
											name="firstName"
										/>
									</Form.Group>
								</Row>

								<Form.Group className="mb-3" controlId="formGridAddress1">
									<Form.Label>연락처</Form.Label>
									<Form.Control
										placeholder="010-xxx-xxxxx"
										onChange={handleFormChange}
										required
										name="contact"
									/>
								</Form.Group>

								<Form.Group className="mb-3" controlId="formGridAddress2">
									<Form.Label>주소</Form.Label>
									<Form.Control
										placeholder="Apartment, studio, or floor"
										onChange={handleFormChange}
										required
										name="address"
									/>
								</Form.Group>

								<Row className="mb-3">
									<Form.Group as={Col} controlId="formGridCity">
										<Form.Label>City</Form.Label>
										<Form.Control
											onChange={handleFormChange}
											required
											name="city"
										/>
									</Form.Group>

									<Form.Group as={Col} controlId="formGridZip">
										<Form.Label>Zip</Form.Label>
										<Form.Control
											onChange={handleFormChange}
											required
											name="zip"
										/>
									</Form.Group>
								</Row>
								<div className="mobile-receipt-area">
									<OrderReceipt cartList={cartList} totalPrice={totalPrice} />
								</div>
								<Button
									variant="dark"
									className="payment-button pay-button"
									type="submit"
									onClick={handleShow}>
									결제하기
								</Button>
							</Form>
						</div>
					</div>
				</Col>
				<Col lg={5} className="receipt-area">
					<OrderReceipt cartList={cartList} totalPrice={totalPrice} />
				</Col>
			</Row>

			<Modal show={show} onHide={handleClose}>
				<Modal.Header closeButton>
					<Modal.Title>결제</Modal.Title>
				</Modal.Header>
				<Modal.Body>
					<div id="payment-widget" />
					<div id="agreement" />
				</Modal.Body>
				<Modal.Footer>
					<Button variant="secondary" onClick={handleClose}>
						닫기
					</Button>
					<Button variant="primary" onClick={handlePaymentRequest}>
						결제하기
					</Button>
				</Modal.Footer>
			</Modal>
		</Container>
	);
};

export default TossPaymentPage;
