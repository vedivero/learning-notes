// React를 임포트
import React from "react";
// React-Bootstrap에서 Row, Col, Badge 컴포넌트를 임포트
import { Row, Col, Badge } from "react-bootstrap";
// 주문 상태에 따른 배지 색상을 정의한 상수를 임포트
import { badgeBg } from "../constants/order.constants";
// 숫자를 통화 형식으로 변환하는 유틸리티 함수를 임포트
import { currencyFormat } from "../utils/number";

// OrderStatusCard 컴포넌트 정의, orderItem을 props로 받음
const OrderStatusCard = ({ orderItem }) => {
  return (
    <div>
      {/* 주문 상태 카드의 레이아웃을 설정하는 Row */}
      <Row className="status-card">
        {/* 주문 아이템의 첫 번째 상품 이미지를 표시하는 Col */}
        <Col xs={2}>
          <img
            src={orderItem.items[0]?.productId?.image}
            alt={orderItem.items[0]?.productId?.image}
            height={96}
          />
        </Col>

        {/* 주문 정보를 표시하는 Col */}
        <Col xs={8} className="order-info">
          <div>
            <strong>주문번호: {orderItem.orderNum}</strong>
          </div>
          <div className="text-12">{orderItem.createdAt.slice(0, 10)}</div>
          <div>
            {orderItem.items[0].productId.name}
            {orderItem.items.length > 1 && `외 ${orderItem.items.length - 1}개`}
          </div>
          <div>₩ {currencyFormat(orderItem.totalPrice)}</div>
        </Col>

        {/* 주문 상태를 표시하는 Col */}
        <Col md={2} className="vertical-middle">
          <div className="text-align-center text-12">주문상태</div>
          <Badge bg={badgeBg[orderItem.status]}>{orderItem.status}</Badge>
        </Col>
      </Row>
    </div>
  );
};

// OrderStatusCard 컴포넌트를 기본 내보내기로 내보냄
export default OrderStatusCard;
