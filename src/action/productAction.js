import api from "../utils/api";
import * as types from "../constants/product.constants";
import { toast } from "react-toastify";
import { commonUiActions } from "./commonUiAction";

// 관리자 페이지 - 모든 상품 가져오기
const getAllProductsForAdmin = (query) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_GET_REQUEST });
    const response = await api.get("/product/admin/products", {
      params: { ...query }
    });
    dispatch({ type: types.PRODUCT_GET_SUCCESS, payload: response.data });
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_GET_FAIL, payload: errorMessage });
  }
};


//상품 가져오기
const getProductList = (query) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_GET_REQUEST });
    const response = await api.get("/product", {
      params: { ...query }
    });
    dispatch({ type: types.PRODUCT_GET_SUCCESS, payload: response.data });
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_GET_FAIL, payload: errorMessage });
  }
};


//상품 상세정보
const getProductDetail = (id) => async (dispatch) => {
  try {
    dispatch({ type: types.GET_PRODUCT_DETAIL_REQUEST });
    const response = await api.get(`/product/${id}`);
    dispatch({
      type: types.GET_PRODUCT_DETAIL_SUCCESS,
      payload: response.data.data
    })
  } catch (error) {
    dispatch({ type: types.GET_PRODUCT_DETAIL_FAIL, payload: error.error });
    dispatch(commonUiActions.showToastMessage(error.error, "error"));
  }
};

//상품 생성
const createProduct = (formData) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_CREATE_REQUEST });
    ///product를 호출하고, 생성할 데이터 formData를 전송
    const response = await api.post("/product", formData);
    dispatch({ type: types.PRODUCT_CREATE_SUCCESS });
    dispatch(commonUiActions.showToastMessage("상품이 등록되었습니다.", "success"));
    dispatch(getProductList({ page: 1, name: "" }));
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_CREATE_FAIL, payload: errorMessage });
    dispatch(commonUiActions.showToastMessage(errorMessage, "error"));
  }
};


//상품 삭제
const deleteProduct = (id) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_DELETE_REQUEST });
    const response = await api.delete(`/product/${id}`);
    dispatch({ type: types.PRODUCT_DELETE_SUCCESS });
    dispatch(commonUiActions.showToastMessage("상품이 삭제되었습니다.", "success"));
    dispatch(getProductList({ page: 1, name: "" }));
  } catch (error) {
    dispatch({ type: types.PRODUCT_DELETE_FAIL, payload: error.error });
    dispatch(commonUiActions.showToastMessage(error.error, "error"));
  }
}


//상품 수정
const editProduct = (formData, id) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_EDIT_REQUEST });
    const response = await api.put(`/product/${id}`, formData);
    dispatch({ type: types.PRODUCT_EDIT_SUCCESS, payload: response.data.data });
    dispatch(commonUiActions.showToastMessage("상품 정보가 수정되었습니다.", "success"));
    dispatch(getProductList({ page: 1, name: "" }));
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_EDIT_FAIL, payload: errorMessage });
    dispatch(commonUiActions.showToastMessage(errorMessage, "error"));
  }
};


// 상품 조회수 증가
const incrementViewCount = (id) => async (dispatch) => {
  try {
    await api.put(`/product/${id}/increment-view`);
  } catch (error) {
    console.error("Failed to increment view count:", error);
  }
};


// 조회수 기준으로 내림차순 정렬된 상품 목록 가져오기
const getHottestProductList = () => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_GET_HOTTEST_REQUEST });
    const response = await api.get("/product/hottest");
    dispatch({ type: types.PRODUCT_GET_HOTTEST_SUCCESS, payload: response.data });
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_GET_HOTTEST_FAIL, payload: errorMessage });
  }
};

//새롭게 등록된 상품 모아보기
const getNewArrivalProductList = () => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_GET_NEWARRIVAL_REQUEST });
    const response = await api.get("/product/new");
    dispatch({ type: types.PRODUCT_GET_NEWARRIVAL_SUCCESS, payload: response.data });
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_GET_NEWARRIVAL_FAIL, payload: errorMessage });
  }
};

// 할인율 업데이트
const updateProductDiscount = (id, discount) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_DISCOUNT_UPDATE_REQUEST });
    const response = await api.put(`/product/${id}/discount`, { discount });
    dispatch({ type: types.PRODUCT_DISCOUNT_UPDATE_SUCCESS, payload: response.data });
    dispatch(commonUiActions.showToastMessage("상품 할인이 적용되었습니다.", "success"));
    dispatch(getAllProductsForAdmin({ page: 1, name: "" }));
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_DISCOUNT_UPDATE_FAIL, payload: errorMessage });
    dispatch(commonUiActions.showToastMessage(errorMessage, "error"));
  }
};

// 상품 가격 복구
const restoreProductPrice = (id) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_RESTORE_PRICE_REQUEST });
    const response = await api.put(`/product/${id}/restore-price`);
    dispatch({ type: types.PRODUCT_RESTORE_PRICE_SUCCESS, payload: response.data });

    const message = response.data.message || "상품 가격이 원래대로 복구되었습니다.";
    dispatch(commonUiActions.showToastMessage(message, "success"));

    dispatch(getAllProductsForAdmin({ page: 1, name: "" }));
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_RESTORE_PRICE_FAIL, payload: errorMessage });
    dispatch(commonUiActions.showToastMessage(errorMessage, "error"));
  }
};


// 세일 상품 가져오기
export const getDiscountedProducts = () => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_DISCOUNTED_REQUEST });
    const response = await api.get("/product/discounted");
    dispatch({ type: types.PRODUCT_DISCOUNTED_SUCCESS, payload: response.data });
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;
    dispatch({ type: types.PRODUCT_DISCOUNTED_FAIL, payload: errorMessage });
  }
};


export const productActions = {
  getProductList,
  createProduct,
  deleteProduct,
  editProduct,
  getProductDetail,
  incrementViewCount,
  getHottestProductList,
  getNewArrivalProductList,
  updateProductDiscount,
  restoreProductPrice,
  getDiscountedProducts,
  getAllProductsForAdmin
};
