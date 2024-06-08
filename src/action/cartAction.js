import api from "../utils/api";
import * as types from "../constants/cart.constants";
import { commonUiActions } from "../action/commonUiAction";

//카트에 상품 추가
const addToCart = ({ id, size }) => async (dispatch) => {
  try {
    dispatch({ type: types.ADD_TO_CART_REQUEST });
    const response = await api.post("/cart", { productId: id, size, qty: 1 });
    console.log("response : ", response);
    dispatch({ type: types.ADD_TO_CART_SUCCESS, payload: response.data.cartItemQty });
    dispatch(commonUiActions.showToastMessage("상품이 카트에 추가되었습니다.", "success"));
  } catch (error) {
    dispatch({ type: types.ADD_TO_CART_FAIL, error: error });
    dispatch(commonUiActions.showToastMessage(error.message, "error"));
  }
};

const getCartList = () => async (dispatch) => { };
const deleteCartItem = (id) => async (dispatch) => { };

const updateQty = (id, value) => async (dispatch) => { };
const getCartQty = () => async (dispatch) => { };
export const cartActions = {
  addToCart,
  getCartList,
  deleteCartItem,
  updateQty,
  getCartQty,
};
