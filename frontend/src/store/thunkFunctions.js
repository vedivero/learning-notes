import { createAsyncThunk } from '@reduxjs/toolkit';
import axiosInstance from '../utils/axios';

export const registerUser = createAsyncThunk('user/registerUser', async (body, thunkAPI) => {
   try {
      const response = await axiosInstance.post(`/users/register`, body);
      return response.data;
   } catch (error) {
      console.log('registerUser error : ', error);
      return thunkAPI.rejectWithValue(error.response.data || error.message);
   }
});

export const loginUser = createAsyncThunk('user/loginUser', async (userData, thunkAPI) => {
   try {
      const response = await axiosInstance.post(`/users/login`, userData);
      return response.data;
   } catch (error) {
      console.log('loginUser error : ', error);
      return thunkAPI.rejectWithValue(error.response.data || error.message);
   }
});

export const authUser = createAsyncThunk('user/authUser', async (_, thunkAPI) => {
   try {
      const response = await axiosInstance.get(`/users/auth`);
      return response.data;
   } catch (error) {
      console.log('authUser error : ', error);
      return thunkAPI.rejectWithValue(error.response.data || error.message);
   }
});
