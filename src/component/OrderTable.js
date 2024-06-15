// React를 임포트
import React from "react";
// React-Bootstrap에서 Table, Badge 컴포넌트를 임포트
import { Table, Badge } from "react-bootstrap";
// 주문 상태에 따른 배지 색상을 정의한 상수를 임포트
import { badgeBg } from "../constants/order.constants";
// 숫자를 통화 형식으로 변환하는 유틸리티 함수를 임포트
import { currencyFormat } from "../utils/number";

// OrderTable 컴포넌트 정의, header, data, openEditForm을 props로 받음
const OrderTable = ({ header, data, openEditForm }) => {
  return (
    // 가로 스크롤을 가능하게 하는 div
    <div className="overflow-x">
      {/* 테이블 정의 */}
      <Table striped bordered hover>
        <thead>
          <tr>
            {/* 테이블 헤더를 반복하여 출력 */}
            {header.map((title, index) => (
              <th key={index}>{title}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {/* 데이터가 있을 경우 */}
          {data.length > 0 ? (
            data.map((item, index) => (
              // 각 주문 항목을 클릭 시 편집 폼을 여는 이벤트 핸들러를 추가
              <tr key={item._id} onClick={() => openEditForm(item)}>
                <th>{index + 1}</th>
                <th>{item.orderNum}</th>
                <th>{item.createdAt.slice(0, 10)}</th>
                <th>{item.userId && item.userId.email ? item.userId.email : "Unknown"}</th>
                <th>
                  {item.items.length > 0 && item.items[0].productId ? (
                    <>
                      {item.items[0].productId.name}
                      {item.items.length > 1 && ` 외 ${item.items.length - 1}개`}
                    </>
                  ) : (
                    "No Product Info"
                  )}
                </th>
                <th>{item.shipTo ? `${item.shipTo.address} ${item.shipTo.city}` : "No address provided"}</th>
                <th>{currencyFormat(item.totalPrice)}</th>
                <th>
                  <Badge bg={badgeBg[item.status]}>{item.status}</Badge>
                </th>
              </tr>
            ))
          ) : (
            // 데이터가 없을 경우
            <tr>
              <td colSpan={header.length} className="text-center">No Data to show</td>
            </tr>
          )}
        </tbody>
      </Table>
    </div>
  );
};

// OrderTable 컴포넌트를 기본 내보내기로 내보냄
export default OrderTable;
