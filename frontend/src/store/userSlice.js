import { createSlice } from '@reduxjs/toolkit';
import { loginUser, registerUser } from './thunkFunctions';
import { toast } from 'react-toastify';

const initialState = {
   userData: {
      id: '',
      email: '',
      name: '',
      role: 0, //0: noraml 1:admin
      image: '',
   },
   isAuth: false,
   isLoading: false,
   error: '',
};

const userSlice = createSlice({
   name: 'user',
   initialState,
   reducers: {},
   extraReducers: (builder) => {
      console.log('builder ', builder);
      builder
         .addCase(registerUser.pending, (state) => {
            state.isLoading = true;
         })
         .addCase(registerUser.fulfilled, (state) => {
            state.isLoading = false;
            toast.info('회원 가입이 완료되었습니다.');
         })
         .addCase(registerUser.rejected, (state, action) => {
            state.error = action.payload;
            toast.error(action.payload);
         })
         .addCase(loginUser.pending, (state) => {
            state.isLoading = true;
         })
         .addCase(loginUser.fulfilled, (state, action) => {
            state.isLoading = false;
            state.userData = action.payload;
            state.isAuth = true;
            localStorage.setItem('accessToken', action.payload.accessToken);
         })
         .addCase(loginUser.rejected, (state, action) => {
            state.error = action.payload;
            toast.error(action.payload);
         });
   },
});

export default userSlice.reducer;
