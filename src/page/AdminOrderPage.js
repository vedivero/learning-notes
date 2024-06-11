// React 및 useEffect, useState 훅을 임포트
import React, { useEffect, useState } from "react";
// React-Bootstrap에서 Container 컴포넌트를 임포트
import { Container } from "react-bootstrap";
// SearchBox 컴포넌트를 임포트
import SearchBox from "../component/SearchBox";
// Redux의 useDispatch, useSelector 훅을 임포트
import { useDispatch, useSelector } from "react-redux";
// 주문 관련 액션을 임포트
import { orderActions } from "../action/orderAction";
// OrderDetailDialog 컴포넌트를 임포트
import OrderDetailDialog from "../component/OrderDetailDialog";
// OrderTable 컴포넌트를 임포트
import OrderTable from "../component/OrderTable";
// 주문 관련 상수를 임포트
import * as types from "../constants/order.constants";
// ReactPaginate 컴포넌트를 임포트
import ReactPaginate from "react-paginate";
// React Router의 useSearchParams, useNavigate 훅을 임포트
import { useSearchParams, useNavigate } from "react-router-dom";
// 공통 UI 액션을 임포트
import { commonUiActions } from "../action/commonUiAction";

// AdminOrderPage 컴포넌트를 정의
const AdminOrderPage = () => {
  // useNavigate 훅을 사용해 navigate 함수 가져오기
  const navigate = useNavigate();
  // useSearchParams 훅을 사용해 query와 setQuery 함수 가져오기
  const [query, setQuery] = useSearchParams();
  // useDispatch 훅을 사용해 dispatch 함수 가져오기
  const dispatch = useDispatch();
  // useSelector 훅을 사용해 상태에서 orderList 가져오기
  const orderList = useSelector((state) => state.order.orderList);
  // searchQuery 상태를 관리하기 위해 useState 훅 사용
  const [searchQuery, setSearchQuery] = useState({
    page: query.get("page") || 1,
    ordernum: query.get("ordernum") || "",
  });
  // useSelector 훅을 사용해 상태에서 error 가져오기
  const error = useSelector((state) => state.order.error);
  // 대화상자 열기 상태를 관리하기 위해 useState 훅 사용
  const [open, setOpen] = useState(false);
  // useSelector 훅을 사용해 상태에서 totalPageNum 가져오기
  const totalPageNum = useSelector((state) => state.order.totalPageNum);
  // 테이블 헤더 정의
  const tableHeader = [
    "#",
    "주문번호#",
    "주문날짜",
    "주문자",
    "주문상품",
    "배송지",
    "결제 금액",
    "상태",
  ];

  // 컴포넌트가 마운트될 때 주문 목록을 가져오는 액션 디스패치
  useEffect(() => {
    dispatch(orderActions.getOrderList({ ...searchQuery }));
  }, [query]);

  // searchQuery 상태가 변경될 때 URL을 업데이트
  useEffect(() => {
    if (searchQuery.ordernum === "") {
      delete searchQuery.ordernum;
    }
    const params = new URLSearchParams(searchQuery);
    const queryString = params.toString();

    navigate("?" + queryString);
  }, [searchQuery]);

  // 주문 편집 폼 열기
  const openEditForm = (order) => {
    setOpen(true);
    dispatch({ type: types.SET_SELECTED_ORDER, payload: order });
  };

  // 페이지 클릭 핸들러
  const handlePageClick = ({ selected }) => {
    setSearchQuery({ ...searchQuery, page: selected + 1 });
  };

  // 대화상자 닫기 핸들러
  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div className="locate-center">
      <Container>
        <div className="mt-2 display-center mb-2">
          <SearchBox
            searchQuery={searchQuery}
            setSearchQuery={setSearchQuery}
            placeholder="주문번호"
            field="ordernum"
          />
        </div>

        <OrderTable
          header={tableHeader}
          data={orderList}
          openEditForm={openEditForm}
        />
        <ReactPaginate
          nextLabel="next >"
          onPageChange={handlePageClick}
          pageRangeDisplayed={5}
          pageCount={totalPageNum}
          forcePage={searchQuery.page - 1}
          previousLabel="< previous"
          renderOnZeroPageCount={null}
          pageClassName="page-item"
          pageLinkClassName="page-link"
          previousClassName="page-item"
          previousLinkClassName="page-link"
          nextClassName="page-item"
          nextLinkClassName="page-link"
          breakLabel="..."
          breakClassName="page-item"
          breakLinkClassName="page-link"
          containerClassName="pagination"
          activeClassName="active"
          className="display-center list-style-none"
        />
      </Container>

      {open && <OrderDetailDialog open={open} handleClose={handleClose} />}
    </div>
  );
};

// AdminOrderPage 컴포넌트를 기본 내보내기로 내보냄
export default AdminOrderPage;
