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
    dispatch(cartActions.getCartQty());
    navigate(`/payment/success?orderNum=${response.data.orderNum}`);
  } catch (error) {
    dispatch({ type: types.CREATE_ORDER_FAIL, payload: error.error });
    dispatch(commonUiActions.showToastMessage(error.message, "error"));
  }

};

//비동기 함수 'getOrder'를 반환하는 함수. Redux의 'dispatch' 함수를 사용하여 액션을 디스패치
const getOrder = () => async (dispatch) => {
  try {
    // 'GET_ORDER_REQUEST' 타입의 액션을 디스패치하여 주문 요청이 시작되었음을 알림
    dispatch({ type: types.GET_ORDER_REQUEST });
    // API 엔드포인트 '/order/me'에 GET 요청을 보내고, 응답을 'response' 변수에 할당
    const response = await api.get("/order/me");
    // 응답이 성공적이면 'GET_ORDER_SUCCESS' 타입의 액션을 디스패치하고, 응답 데이터를 페이로드로 전달
    dispatch({ type: types.GET_ORDER_SUCCESS, payload: response.data });
  } catch (error) {
    // 에러가 발생하면 'GET_ORDER_FAIL' 타입의 액션을 디스패치하고, 에러 객체를 전달
    dispatch({ type: types.GET_ORDER_FAIL, error: error });
    // 에러 메시지를 'error' 타입으로 보여주기 위해 토스트 메시지를 디스패치
    dispatch(commonUiActions.showToastMessage(error, "error"));
  }
};


//주문 목록을 조회하는 비동기 액션
const getOrderList = (query) => async (dispatch) => {
  try {
    // 주문 목록 조회 요청 시작 액션 디스패치
    dispatch({ type: types.GET_ORDER_LIST_REQUEST });

    // API 엔드포인트 "/order"에 GET 요청을 보내고, 쿼리 파라미터를 전달
    const response = await api.get("/order", {
      params: { ...query },
    });

    // 응답 상태가 200이 아니면 에러 발생
    if (response.status !== 200) throw new Error(response.error);

    // 주문 목록 조회 성공 액션 디스패치, 응답 데이터를 페이로드로 전달
    dispatch({
      type: types.GET_ORDER_LIST_SUCCESS,
      payload: response.data,
    });
  } catch (error) {
    const errorMessage = error.response ? error.response.data.message : error.message;

    // 주문 목록 조회 실패 액션 디스패치, 에러 메시지를 전달
    dispatch({ type: types.GET_ORDER_LIST_FAIL, error: errorMessage });

    // 에러 메시지를 표시하기 위해 토스트 메시지 디스패치
    dispatch(commonUiActions.showToastMessage(errorMessage, "error"));
  }
};

//주문 상태를 업데이트하는 비동기 액션 크리에이터
const updateOrder = (id, status) => async (dispatch) => {
  try {
    // 주문 상태 업데이트 요청 시작 액션 디스패치
    dispatch({ type: types.UPDATE_ORDER_REQUEST });

    // API 엔드포인트 "/order/{id}"에 PUT 요청을 보내고, 상태를 전달
    const response = await api.put(`/order/${id}`, { status });

    // 응답 상태가 200이 아니면 에러 발생
    if (response.status !== 200) throw new Error(response.error);

    // 주문 상태 업데이트 성공 액션 디스패치, 응답 데이터를 페이로드로 전달
    dispatch({
      type: types.UPDATE_ORDER_SUCCESS,
      payload: response.data,
    });

    // 성공 메시지를 표시하기 위해 토스트 메시지 디스패치
    dispatch(commonUiActions.showToastMessage("주문 상태가 변경되었습니다.", "success"));

    // 주문 목록을 다시 조회하기 위해 getOrderList 액션 디스패치
    dispatch(getOrderList());
  } catch (error) {
    // 주문 상태 업데이트 실패 액션 디스패치, 에러 객체를 전달
    dispatch({ type: types.UPDATE_ORDER_FAIL, error: error });

    // 에러 메시지를 표시하기 위해 토스트 메시지 디스패치
    dispatch(commonUiActions.showToastMessage(error, "error"));
  }
};


export const orderActions = {
  createOrder,
  getOrder,
  getOrderList,
  updateOrder,
};
