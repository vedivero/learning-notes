import React, { useEffect, useState } from "react";
import { Container, Button } from "react-bootstrap";
import SearchBox from "../component/SearchBox";
import { useDispatch, useSelector } from "react-redux";
import { productActions } from "../action/productAction";
import NewItemDialog from "../component/NewItemDialog";
import * as types from "../constants/product.constants";
import ReactPaginate from "react-paginate";
import { useSearchParams, useNavigate } from "react-router-dom";
import { commonUiActions } from "../action/commonUiAction";
import ProductTable from "../component/ProductTable";

const AdminProduct = () => {
  const navigate = useNavigate();
  const { productList, totalPageNum } = useSelector(state => state.product);
  const [query, setQuery] = useSearchParams();
  const dispatch = useDispatch();
  const [showDialog, setShowDialog] = useState(false);
  const [searchQuery, setSearchQuery] = useState({
    page: query.get("page") || 1,
    name: query.get("name") || "",
  }); //검색 조건들을 저장하는 객체

  const [mode, setMode] = useState("new");

  //상품 목록의 컬럼
  const tableHeader = [
    "#",
    "상품번호",
    "상품이름",
    "가격",
    "재고",
    "이미지",
    "상태",
    "",
  ];

  //상품리스트 가져오기 (url쿼리 맞춰서)
  useEffect(() => {
    dispatch(productActions.getProductList({ ...searchQuery }));
  }, [query])


  //검색 searchbox에서
  useEffect(() => {
    if (searchQuery.name === "") {
      delete searchQuery.name;
    }
    console.log("searchQuery : ", searchQuery);
    //검색어에 해당되는 값이 있을 경우
    const params = new URLSearchParams(searchQuery);
    //convert to String
    const query = params.toString();

    console.log("query : ", query);
    navigate("?" + query);
  }, [searchQuery]);

  const deleteItem = (id) => {
    //아이템 삭제하가ㅣ
  };

  const openEditForm = (product) => {
    //edit모드로 설정하고
    // 아이템 수정다이얼로그 열어주기
  };

  const handleClickNewItem = () => {
    //new 모드로 설정하고
    setMode("new");
    // 다이얼로그 열어주기
    setShowDialog(true);
  };

  //쿼리에 페이지값 바꿔주기
  const handlePageClick = ({ selected }) => {

    setSearchQuery({ ...searchQuery, page: selected + 1 });

    //searchbox에서 검색 실행 시, searchQuery객체 업데이트(ex) {name:jacket})
    //searchQuery객체의 item으로 url생성하여 호출 &name=jacket
    //URL 파라미터를 사용하여 Query실행
  };

  return (
    <div className="locate-center">
      <Container>
        <div className="mt-2">
          <SearchBox
            searchQuery={searchQuery}
            setSearchQuery={setSearchQuery}
            placeholder="제품 이름으로 검색"
            field="name"
          />
        </div>
        <Button className="mt-2 mb-2" onClick={handleClickNewItem}>
          새로운 상품 등록
        </Button>

        <ProductTable
          header={tableHeader}
          data={productList}
          deleteItem={deleteItem}
          openEditForm={openEditForm}
        />

        <ReactPaginate
          nextLabel="next >"
          onPageChange={handlePageClick}
          pageRangeDisplayed={5}
          pageCount={totalPageNum} //전체 페이지
          forcePage={searchQuery.page - 1} // 1페이지 = 2 (페이지 +1)
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

      <NewItemDialog
        mode={mode}
        showDialog={showDialog}
        setShowDialog={setShowDialog}
      />
    </div>
  );
};

export default AdminProduct;
