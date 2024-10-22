import { createSlice } from '@reduxjs/toolkit';
import { registerUser } from './thunkFunctions';

const initialState = {
   userData: {
      id: '',
      eamil: '',
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
      builder
         .addCase(registerUser.pending, (state) => {
            state.isLoading = true;
         })
         .addCase(registerUser.fulfilled, (state) => {
            state.isLoading = false;
         })
         .addCase(registerUser.rejected, (state, action) => {
            state.error = action.payload;
         });
   },
});

export default userSlice.reducer;
