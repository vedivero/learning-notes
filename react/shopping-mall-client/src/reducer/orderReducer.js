// 'order.constants'에서 모든 타입을 가져옴
import * as types from "../constants/order.constants";

// 초기 상태를 정의
const initialState = {
  orderList: [],       // 주문 목록을 저장하는 배열
  orderNum: "",        // 생성된 주문 번호를 저장하는 문자열
  selectedOrder: {},   // 선택된 주문의 상세 정보를 저장하는 객체
  error: "",           // 에러 메시지를 저장하는 문자열
  loading: false,      // 로딩 상태를 나타내는 불리언 값
  totalPageNum: 1,     // 총 페이지 수를 저장하는 숫자
};

// orderReducer 함수 정의. 이 함수는 상태와 액션을 인자로 받음
function orderReducer(state = initialState, action) {
  // 액션 객체에서 타입과 페이로드를 추출
  const { type, payload } = action;

  // 액션 타입에 따라 상태를 업데이트
  switch (type) {
    // 주문 생성, 주문 조회 요청 시 로딩 상태로 전환
    case types.CREATE_ORDER_REQUEST:
    case types.GET_ORDER_REQUEST:
    case types.GET_ORDER_LIST_REQUEST:
      return { ...state, loading: true };

    // 주문 생성 성공 시 로딩을 해제하고 주문 번호를 업데이트
    case types.CREATE_ORDER_SUCCESS:
      return { ...state, loading: false, orderNum: payload };

    // 주문 조회, 주문 목록 조회 성공 시 로딩을 해제하고 주문 목록과 총 페이지 수를 업데이트
    case types.GET_ORDER_SUCCESS:
    case types.GET_ORDER_LIST_SUCCESS:
      return {
        ...state,
        loading: false,
        orderList: payload.data,
        totalPageNum: payload.totalPageNum,
      };

    // 주문 생성, 주문 조회, 주문 목록 조회 실패 시 로딩을 해제하고 에러 메시지를 업데이트
    case types.CREATE_ORDER_FAIL:
    case types.GET_ORDER_FAIL:
    case types.GET_ORDER_LIST_FAIL:
      return { ...state, loading: false, error: payload };

    // 선택된 주문을 업데이트
    case types.SET_SELECTED_ORDER:
      return { ...state, selectedOrder: payload };

    // 기본값으로 현재 상태를 반환
    default:
      return state;
  }
}

// orderReducer 함수를 외부에서 사용가능하도록 내보냄
export default orderReducer;
