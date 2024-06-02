import api from "../utils/api";
import * as types from "../constants/user.constants";
import { commonUiActions } from "./commonUiAction";

const loginWithToken = () => async (dispatch) => {
  try {

  } catch (error) {

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
    else {
      throw new Error(response.error);
    }
  } catch (error) {
    console.log("error.message : ", error.error)
    dispatch({ type: types.LOGIN_FAIL, payload: error.error });
  }
};


const logout = () => async (dispatch) => {

};

const loginWithGoogle = (token) => async (dispatch) => {

};

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
        dispatch({ type: types.REGISTER_USER_FAIL, payload: error.message });
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