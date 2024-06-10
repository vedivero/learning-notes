import React from "react";
import { Container } from "react-bootstrap";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import "../style/paymentPage.style.css";

const OrderCompletePage = () => {

  const { orderNum } = useSelector((state) => state.order);

  console.log("orderNum : ", orderNum)
  //주문 번호가 없는 상태로 이 페이지에 왔다면 다시 메인페이지로 돌아가기
  if (orderNum === "") {
    return (
      <Container className="confirmation-page">
        <h2>주문 정보가 없습니다.</h2>
        <div>다시 시도해 주세요.</div>
        <div className="text-align-center">
          <Link to={"/"}>메인 페이지 바로가기</Link>
        </div>
      </Container>
    )
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

export default OrderCompletePage;
