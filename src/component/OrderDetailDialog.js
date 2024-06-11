// React 및 useState 훅을 임포트
import React, { useState } from "react";
// React-Bootstrap에서 필요한 컴포넌트를 임포트
import { Form, Modal, Button, Col, Table } from "react-bootstrap";
// Redux의 useDispatch, useSelector 훅을 임포트
import { useDispatch, useSelector } from "react-redux";

// 스타일 시트를 임포트
import "../style/adminOrder.style.css";
// 주문 상태 상수를 임포트
import { ORDER_STATUS } from "../constants/order.constants";
// 주문 관련 액션을 임포트
import { orderActions } from "../action/orderAction";
// 숫자를 통화 형식으로 변환하는 유틸리티 함수를 임포트
import { currencyFormat } from "../utils/number";

// OrderDetailDialog 컴포넌트 정의, open, handleClose를 props로 받음
const OrderDetailDialog = ({ open, handleClose }) => {
  // Redux 상태에서 선택된 주문을 가져옴
  const selectedOrder = useSelector((state) => state.order.selectedOrder);
  // 주문 상태를 관리하기 위해 useState 훅 사용
  const [orderStatus, setOrderStatus] = useState(selectedOrder.status);
  // useDispatch 훅을 사용해 dispatch 함수 가져오기
  const dispatch = useDispatch();

  // 주문 상태 변경 핸들러
  const handleStatusChange = (event) => {
    setOrderStatus(event.target.value);
  };

  // 주문 상태를 업데이트하고 모달을 닫는 함수
  const submitStatus = () => {
    dispatch(orderActions.updateOrder(selectedOrder._id, orderStatus));
    handleClose();
  };

  // 선택된 주문이 없을 경우 빈 JSX 반환
  if (!selectedOrder) {
    return <></>;
  }

  // 모달 컴포넌트 렌더링
  return (
    <Modal show={open} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Order Detail</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <p>예약번호: {selectedOrder.orderNum}</p>
        <p>주문날짜: {selectedOrder.createdAt.slice(0, 10)}</p>
        <p>이메일: {selectedOrder.userId.email}</p>
        <p>주소: {selectedOrder.shipTo.address + " " + selectedOrder.shipTo.city}</p>
        <p>연락처: {`${selectedOrder.contact.firstName + selectedOrder.contact.lastName} ${selectedOrder.contact.contact}`}</p>
        <p>주문내역</p>
        <div className="overflow-x">
          <Table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Unit Price</th>
                <th>Qty</th>
                <th>Price</th>
              </tr>
            </thead>
            <tbody>
              {selectedOrder.items.length > 0 && selectedOrder.items.map((item) => (
                <tr key={item._id}>
                  <td>{item._id}</td>
                  <td>{item.productId.name}</td>
                  <td>{currencyFormat(item.price)}</td>
                  <td>{item.qty}</td>
                  <td>{currencyFormat(item.price * item.qty)}</td>
                </tr>
              ))}
              <tr>
                <td colSpan={4}>총계:</td>
                <td>{currencyFormat(selectedOrder.totalPrice)}</td>
              </tr>
            </tbody>
          </Table>
        </div>
        <Form onSubmit={submitStatus}>
          <Form.Group as={Col} controlId="status">
            <Form.Label>Status</Form.Label>
            <Form.Select value={orderStatus} onChange={handleStatusChange}>
              {ORDER_STATUS.map((item, idx) => (
                <option key={idx} value={item.toLowerCase()}>
                  {item}
                </option>
              ))}
            </Form.Select>
          </Form.Group>
          <div className="order-button-area">
            <Button variant="light" onClick={handleClose} className="order-button">
              닫기
            </Button>
            <Button type="submit">저장</Button>
          </div>
        </Form>
      </Modal.Body>
    </Modal>
  );
};

// OrderDetailDialog 컴포넌트를 기본 내보내기로 내보냄
export default OrderDetailDialog;
