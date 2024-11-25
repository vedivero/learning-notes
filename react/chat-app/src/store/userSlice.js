import { createSlice } from '@reduxjs/toolkit';

const initialState = {
   currentUser: {
      uid: '',
      photoURL: '',
      displayName: '',
   },
};

export const userSlice = createSlice({
   name: 'user',
   initialState,
   reducers: {
      setUser: (state, action) => {
         state.currentUser.uid = action.payload.uid;
         state.currentUser.photoURL = action.payload.photoURL;
         state.currentUser.displayName = action.payload.displayName;
      },
      clearUser: (state) => {
         state.currentUser = { ...initialState.currentUser }; // 로그아웃 시 초기 상태로 되돌리기
      },
      setPhotoUrl: (state, action) => {
         //change User profile image
         state.currentUser = {
            ...state.currentUser,
            photoURL: action.payload, //Override only photoURL
         };
      },
   },
});

export const { setPhotoUrl, clearUser, setUser } = userSlice.actions;

export default userSlice.reducer;
