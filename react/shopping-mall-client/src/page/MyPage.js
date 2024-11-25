// React와 useEffect 훅을 임포트
import React from "react";
import { useEffect } from "react";
// React-Bootstrap의 Container 컴포넌트를 임포트
import { Container } from "react-bootstrap";
// useDispatch와 useSelector 훅을 리덕스에서 임포트
import { useDispatch, useSelector } from "react-redux";
// 주문 관련 액션을 임포트
import { orderActions } from "../action/orderAction";
// OrderStatusCard 컴포넌트를 임포트
import OrderStatusCard from "../component/OrderStatusCard";
// 스타일 시트를 임포트
import "../style/orderStatus.style.css";

// MyPage 컴포넌트 정의
const MyPage = () => {
  // useDispatch 훅을 사용해 디스패치 함수 가져오기
  const dispatch = useDispatch();
  // useSelector 훅을 사용해 상태에서 orderList를 가져오기
  const { orderList } = useSelector((state) => state.order);

  // 컴포넌트가 마운트될 때 주문 목록을 가져오는 액션 디스패치
  useEffect(() => {
    dispatch(orderActions.getOrder());
  }, [dispatch]);

  // 주문 목록이 비어있을 때의 렌더링
  if (orderList?.length === 0) {
    return (
      <Container className="no-order-box">
        <div>진행 중인 주문 정보가 없습니다.</div>
      </Container>
    );
  }

  // 주문 목록이 있을 때의 렌더링
  return (
    <Container className="status-card-container">
      {orderList.map((item) => (
        <OrderStatusCard
          orderItem={item}
          className="status-card-container"
          key={item._id}
        />
      ))}
    </Container>
  );
};

// MyPage 컴포넌트를 기본 내보내기로 내보냄
export default MyPage;
