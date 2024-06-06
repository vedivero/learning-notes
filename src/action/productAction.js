import api from "../utils/api";
import * as types from "../constants/product.constants";
//import { toast } from "react-toastify";
import { commonUiActions } from "./commonUiAction";

//상품 가져오기
const getProductList = (query) => async (dispatch) => {
  try {
    dispatch({ type: types.PRODUCT_GET_REQUEST });
    const response = await api.get("/product", {
      params: { ...query }
    });
    console.log("getProductList response data : ", response.data.data);
    dispatch({ type: types.PRODUCT_GET_SUCCESS, payload: response.data.data });
  } catch (error) {
    dispatch({ type: types.PRODUCT_GET_FAIL, payload: error });
  }
};



const getProductDetail = (id) => async (dispatch) => { };

const createProduct = (formData) => async (dispatch) => {

  try {
    dispatch({ type: types.PRODUCT_CREATE_REQUEST });
    ///product를 호출하고, 생성할 데이터 formData를 전송
    const response = await api.post("/product", formData);
    console.log("/product response : ", response);
    dispatch({ type: types.PRODUCT_CREATE_SUCCESS });
    dispatch(commonUiActions.showToastMessage("상품이 등록되었습니다.", "success"));
  } catch (error) {
    dispatch({ type: types.PRODUCT_CREATE_FAIL, payload: error.error });
    dispatch(commonUiActions.showToastMessage(error.error, "error"));
  }

};

const deleteProduct = (id) => async (dispatch) => { };

const editProduct = (formData, id) => async (dispatch) => { };

export const productActions = {
  getProductList,
  createProduct,
  deleteProduct,
  editProduct,
  getProductDetail,
};
