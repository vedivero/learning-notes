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

export const logoutUser = createAsyncThunk('user/logoutUser', async (_, thunkAPI) => {
   try {
      const response = await axiosInstance.post(`/users/logout`);
      return response.data;
   } catch (error) {
      console.log('logoutUser error : ', error);
      return thunkAPI.rejectWithValue(error.response.data || error.message);
   }
});

export const addToCart = createAsyncThunk('user/addToCart', async (body, thunkAPI) => {
   try {
      const response = await axiosInstance.post(`/users/cart`, body);
      return response.data;
   } catch (error) {
      console.log('logoutUser error : ', error);
      return thunkAPI.rejectWithValue(error.response.data || error.message);
   }
});

export const getCartItems = createAsyncThunk(
   'user/getCartItems',
   async ({ cartItemIds, userCart }, thunkAPI) => {
      try {
         const response = await axiosInstance.get(`/products/${cartItemIds}?type=array`);
         userCart.forEach((cartItem) => {
            response.data.forEach((productDetail, index) => {
               if (cartItem.id === productDetail._id) {
                  response.data[index].quantity = cartItem.quantity;
               }
            });
         });
         return response.data;
      } catch (error) {
         console.log('logoutUser error : ', error);
         return thunkAPI.rejectWithValue(error.response.data || error.message);
      }
   },
);
export const removeCartItem = createAsyncThunk('user/removeCartItems', async (productId, thunkAPI) => {
   try {
      const response = await axiosInstance.delete(`/users/cart?productId=${productId}`);

      response.data.cart.forEach((cartItem) => {
         response.data.productInfo.forEach((productDetail, index) => {
            if (cartItem.id === productDetail._id) {
               response.data.productInfo[index].quantity = cartItem.quantity;
            }
         });
      });

      return response.data;
   } catch (error) {
      console.log('logoutUser error : ', error);
      return thunkAPI.rejectWithValue(error.response.data || error.message);
   }
});
