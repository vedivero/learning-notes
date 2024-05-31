import api from "../utils/api";
import * as types from "../constants/user.constants";
import { commonUiActions } from "./commonUiAction";
import * as commonTypes from "../constants/commonUI.constants";
import { useNavigate } from "react-router";
const loginWithToken = () => async (dispatch) => { };
const loginWithEmail = (payload) => async (dispatch) => { };
const logout = () => async (dispatch) => { };

const loginWithGoogle = (token) => async (dispatch) => { };

const registerUser =
  ({ email, name, password }, navigate) =>
    async (dispatch) => {
      try {
        dispatch({ type: types.REGISTER_USER_REQUEST });
        //api 호출
        const response = await api.post("/user", { email, name, password });
        if (response.status != 200) throw new Error("respons.error");
        dispatch({ type: types.REGISTER_USER_SUCCESS });
        //성공 메세지
        dispatch(
          commonUiActions.showToastMessage("회원 가입이 완료되었습니다.", "success")
        );
        //redirection (함수형 컴포넌트안에서만 사용 가능)
        navigate("/login")
      } catch (error) {
        dispatch({ type: types.REGISTER_USER_FAIL, payload: error.error })
      }
    };


export const userActions = {
  loginWithToken,
  loginWithEmail,
  logout,
  loginWithGoogle,
  registerUser,
};
