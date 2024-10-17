import { createSlice } from '@reduxjs/toolkit';

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
   extraReducers: (builder) => {},
});

export default userSlice.reducer;
