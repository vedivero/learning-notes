import React, { useEffect } from "react";
import { Container } from "react-bootstrap";
import { useDispatch } from "react-redux";
import { Link, useLocation } from "react-router-dom";
import "../style/paymentPage.style.css";
import { orderActions } from "../action/orderAction";

const OrderCompletePageToss = () => {
  const location = useLocation();
  const dispatch = useDispatch();
  const queryParams = new URLSearchParams(location.search);
  const orderNum = queryParams.get("orderNum") || queryParams.get("orderId");

  const firstName = queryParams.get("firstName");
  const lastName = queryParams.get("lastName");
  const contact = queryParams.get("contact");
  const address = queryParams.get("address");
  const city = queryParams.get("city");
  const zip = queryParams.get("zip");
  const totalPrice = parseFloat(queryParams.get("totalPrice"));
  const cartList = JSON.parse(queryParams.get("cartList"));

  useEffect(() => {
    if (!orderNum) {
      console.log("주문 번호가 없습니다.");
      return;
    }

    const data = {
      totalPrice,
      shipTo: { address, city, zip },
      contact: { firstName, lastName, contact },
      orderList: cartList
    };

    // 주문 생성
    dispatch(orderActions.createOrder(data));
  }, [dispatch, orderNum, firstName, lastName, contact, address, city, zip, totalPrice, cartList]);

  // 주문 번호가 없는 상태로 이 페이지에 왔다면 다시 메인페이지로 돌아가기
  if (!orderNum) {
    return (
      <Container className="confirmation-page">
        <h2>주문 정보가 없습니다.</h2>
        <div>다시 시도해 주세요.</div>
        <div className="text-align-center">
          <Link to={"/"}>메인 페이지 바로가기</Link>
        </div>
      </Container>
    );
  }

  return (
    <Container className="confirmation-page">
      <img
        src="/image/greenCheck.png"
        width={100}
        className="check-image"
        alt="greenCheck.png"
      />
      <h2>주문이 완료되었습니다.</h2>
      <div>주문번호 : {orderNum}</div>
      <div>
        주문 내역은 내 주문 페이지에서 확인해 주세요.
        <div className="text-align-center">
          <Link to={"/account/purchase"}>내 주문 바로가기</Link>
        </div>
      </div>
    </Container>
  );
};

export default OrderCompletePageToss;
