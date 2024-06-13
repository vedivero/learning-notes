import api from "../utils/api";
import * as types from "../constants/user.constants";
import { commonUiActions } from "./commonUiAction";

const loginWithToken = () => async (dispatch) => {
  try {
    dispatch({ type: types.LOGIN_WITH_TOKEN_REQUEST });
    //call api
    const response = await api.get("/user/me");
    if (response.status === 200) {
      dispatch({ type: types.LOGIN_WITH_TOKEN_SUCCESS, payload: response.data });
    }
  } catch (error) {
    //토큰이 만료되거나, 잘못됐거나
    dispatch({ type: types.LOGIN_WITH_TOKEN_FAIL, payload: error });
    //로그인 상태가 아니기 때문에, 토큰 삭제
    dispatch(logout());
  }
};

const loginWithEmail = ({ email, password }) => async (dispatch) => {
  try {
    dispatch({ type: types.LOGIN_REQUEST });
    const response = await api.post("/auth/login", { email, password });

    if (response.status === 200) {
      sessionStorage.setItem("token", response.data.token);
      dispatch({ type: types.LOGIN_SUCCESS, payload: response.data });
    }
  } catch (error) {
    dispatch({ type: types.LOGIN_FAIL, payload: error.error });
  }
};

//로그 아웃
const logout = () => async (dispatch) => {
  //user 정보 지우기
  dispatch({ type: types.LOGOUT });
  //세션 스토리지의 토근 지우기
  sessionStorage.removeItem("token");
};

//구글 로그인
const loginWithGoogle = (token) => async (dispatch) => {
  try {
    dispatch({ type: types.GOOGLE_LOGIN_REQUEST });
    const response = await api.post("/auth/google", { token });
    dispatch({ type: types.GOOGLE_LOGIN_SUCCESS, payload: response.data });
    sessionStorage.setItem("token", response.data.token);
  } catch (error) {
    dispatch({ type: types.GOOGLE_LOGIN_FAIL, payload: error.error });
    dispatch(commonUiActions.showToastMessage(error.error, "error"));
  }
};

//회원 등록
const registerUser =
  ({ email, name, password }, navigate) =>
    async (dispatch) => {
      try {
        dispatch({ type: types.REGISTER_USER_REQUEST });
        const response = await api.post("/user", { email, name, password });

        if (response.status === 200) {
          dispatch({ type: types.REGISTER_USER_SUCCESS });
          dispatch(commonUiActions.showToastMessage("회원 가입이 완료됐습니다.", "success"));
          navigate("/login");
        }
        else {
          throw new Error(response.error);
        }

      } catch (error) {
        dispatch({ type: types.REGISTER_USER_FAIL, payload: error.error });
      }
    };

// error message 초기화
const clearError = () => async (dispatch) => {
  dispatch({ type: types.CLEAR_ERROR_MESSAGE });
};

export const userActions = {
  loginWithToken,
  loginWithEmail,
  logout,
  loginWithGoogle,
  registerUser,
  clearError,
};