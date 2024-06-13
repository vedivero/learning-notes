import api from "../utils/api";
import * as types from "../constants/cart.constants";
import { commonUiActions } from "../action/commonUiAction";

//카트에 상품 추가
const addToCart = ({ id, size }) => async (dispatch) => {
  try {
    dispatch({ type: types.ADD_TO_CART_REQUEST });
    const response = await api.post("/cart", { productId: id, size, qty: 1 });
    dispatch({ type: types.ADD_TO_CART_SUCCESS, payload: response.data.cartItemQty });
    dispatch(commonUiActions.showToastMessage("상품이 카트에 추가되었습니다.", "success"));
  } catch (error) {
    dispatch({ type: types.ADD_TO_CART_FAIL, error: error });
    dispatch(commonUiActions.showToastMessage(error.message, "error"));
  }
};

//카트 아이템 가져오기
const getCartList = () => async (dispatch) => {

  try {
    dispatch({ type: types.GET_CART_LIST_REQUEST });
    const response = await api.get("/cart");
    dispatch({ type: types.GET_CART_LIST_SUCCESS, payload: response.data.data });
  } catch (error) {
    dispatch({ type: types.GET_CART_LIST_FAIL, error: error });
  }

};


//카트 리스트에서 상품 삭제
const deleteCartItem = (id) => async (dispatch) => {
  try {
    dispatch({ type: types.DELETE_CART_ITEM_REQUEST });
    const response = await api.delete(`/cart/${id}`);
    dispatch({ type: types.DELETE_CART_ITEM_SUCCESS, payload: response.data.cartItemQty, });
    dispatch(commonUiActions.showToastMessage("해당 상품이 카트에서 삭제되었습니다.", "success"));
    dispatch(getCartList());
  } catch (error) {
    dispatch({ type: types.DELETE_CART_ITEM_FAIL, payload: error });
    dispatch(commonUiActions.showToastMessage(error, "error"));
  }
};


//카트 아이템 수량 수정
const updateQty = (id, value) => async (dispatch) => {
  try {
    dispatch({ type: types.UPDATE_CART_ITEM_REQUEST });
    const response = await api.put(`/cart/${id}`, { qty: value });
    const payload = response.data.data || [];
    dispatch({ type: types.UPDATE_CART_ITEM_SUCCESS, payload: payload });
    dispatch(getCartList());
  } catch (error) {
    const errorMessage = error.message ? error.message : "An unknown error occurred";
    dispatch({ type: types.UPDATE_CART_ITEM_FAIL, payload: errorMessage });
    dispatch(commonUiActions.showToastMessage(errorMessage, "error"));
  }
};


//카트 아이템 총 수량 가져오기
const getCartQty = () => async (dispatch) => {
  try {
    dispatch({ type: types.GET_CART_QTY_REQUEST });
    const response = await api.get("/cart/qty");
    dispatch({ type: types.GET_CART_QTY_SUCCESS, payload: response.data.qty });
    dispatch(getCartList());
  } catch (error) {
    dispatch({ type: types.GET_CART_QTY_FAIL, payload: error.message });
    dispatch(commonUiActions.showToastMessage(error.message, "error"));
  }
};

export const cartActions = {
  addToCart,
  getCartList,
  deleteCartItem,
  updateQty,
  getCartQty,
};
