import React, { useEffect } from "react";
import ProductCard from "../component/ProductCard";
import { Row, Col, Container } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { productActions } from "../action/productAction";
import "../style/ProductCard.css";

const ProductNewArrival = () => {
	const dispatch = useDispatch();
	const { newArrivalProductList, loading, error } = useSelector((state) => state.product);

	useEffect(() => {
		dispatch(productActions.getNewArrivalProductList());
	}, [dispatch]);

	return (
		<Container>
			<Row>
				{loading ? (
					<div>Loading...</div>
				) : error ? (
					<div>{error}</div>
				) : (
					newArrivalProductList && newArrivalProductList.length > 0 ? (
						newArrivalProductList.map((product) => (
							<Col key={product._id} className="card" md={3} sm={12}>
								<ProductCard product={product} isNew={true} /> {/* isNew 속성 전달 */}
							</Col>
						))
					) : (
						<div className="text-align-center empty-bag">
							<h2>등록된 신상품이 없습니다.</h2>
						</div>
					)
				)}
			</Row>
		</Container>
	);
};

export default ProductNewArrival;
