import api from "../utils/api";
import * as types from "../constants/order.constants";
import { cartActions } from "./cartAction";
import { commonUiActions } from "./commonUiAction";

//주문 생성
const createOrder = (payload, navigate) => async (dispatch) => {
  try {
    dispatch({ type: types.CREATE_ORDER_REQUEST });
    const response = await api.post("/order", payload);
    dispatch({ type: types.CREATE_ORDER_SUCCESS, payload: response.data.orderNum });
    console.log("response.data.orderNum, : ", response.data.orderNum);
    dispatch(cartActions.getCartQty());
    navigate("/payment/success");
  } catch (error) {
    dispatch({ type: types.CREATE_ORDER_FAIL, payload: error.error });
    dispatch(commonUiActions.showToastMessage(error.error, "error"));
  }

};

const getOrder = () => async (dispatch) => { };
const getOrderList = (query) => async (dispatch) => { };

const updateOrder = (id, status) => async (dispatch) => { };

export const orderActions = {
  createOrder,
  getOrder,
  getOrderList,
  updateOrder,
};
