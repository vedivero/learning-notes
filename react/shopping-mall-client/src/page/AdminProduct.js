import React, { useEffect, useState } from "react";
import { Container, Button } from "react-bootstrap";
import SearchBox from "../component/SearchBox";
import { useDispatch, useSelector } from "react-redux";
import { productActions } from "../action/productAction";
import NewItemDialog from "../component/NewItemDialog";
import * as types from "../constants/product.constants";
import ReactPaginate from "react-paginate";
import { useSearchParams, useNavigate } from "react-router-dom";
import ProductTable from "../component/ProductTable";
import DiscountModal from "../component/DiscountModal";

const AdminProduct = () => {
  const navigate = useNavigate();
  const { productList, totalPageNum } = useSelector(state => state.product);
  const [query, setQuery] = useSearchParams();
  const dispatch = useDispatch();
  const [showDialog, setShowDialog] = useState(false);
  const [showDiscountModal, setShowDiscountModal] = useState(false);
  const [selectedProduct, setSelectedProduct] = useState(null);

  const [searchQuery, setSearchQuery] = useState({
    page: query.get("page") || 1,
    name: query.get("name") || "",
  });

  const [mode, setMode] = useState("new");

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

  useEffect(() => {
    dispatch(productActions.getAllProductsForAdmin({ ...searchQuery }));
  }, [query]);

  useEffect(() => {
    if (searchQuery.name === "") {
      delete searchQuery.name;
    }
    const params = new URLSearchParams(searchQuery);
    const query = params.toString();
    navigate("?" + query);
  }, [searchQuery]);

  const deleteItem = (id) => {
    const isConfirmed = window.confirm("해당 상품을 삭제하시겠습니까?");
    if (isConfirmed) {
      dispatch(productActions.deleteProduct(id));
      dispatch(productActions.getAllProductsForAdmin(searchQuery));
    }
  };

  const openEditForm = (product) => {
    setMode("edit");
    dispatch({ type: types.SET_SELECTED_PRODUCT, payload: product });
    setShowDialog(true);
  };

  const handleClickNewItem = () => {
    setMode("new");
    setShowDialog(true);
  };

  const handlePageClick = ({ selected }) => {
    setSearchQuery({ ...searchQuery, page: selected + 1 });
  };

  const openDiscountModal = (product) => {
    setSelectedProduct(product);
    setShowDiscountModal(true);
  };

  const applyDiscount = (discount) => {
    if (selectedProduct) {
      dispatch(productActions.updateProductDiscount(selectedProduct._id, discount));
    }
  };

  const restorePrice = () => {
    if (selectedProduct) {
      dispatch(productActions.restoreProductPrice(selectedProduct._id));
    }
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
          openDiscountModal={openDiscountModal}
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

        <NewItemDialog
          mode={mode}
          showDialog={showDialog}
          setShowDialog={setShowDialog}
        />

        <DiscountModal
          show={showDiscountModal}
          handleClose={() => setShowDiscountModal(false)}
          applyDiscount={applyDiscount}
          restorePrice={restorePrice}
        />
      </Container>
    </div>
  );
};

export default AdminProduct;
