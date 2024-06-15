import React from "react";
import { Route, Routes } from "react-router";
import AdminOrderPage from "../page/AdminOrderPage";
import AdminProduct from "../page/AdminProduct";
import CartPage from "../page/CartPage";
import Login from "../page/Login";
import MyPage from "../page/MyPage";
import OrderCompletePage from "../page/OrderCompletePage";
import OrderCompletePageToss from "../page/OrderCompletePageToss";
import PaymentPage from "../page/PaymentPage";
import TossPaymentPage from "../page/TossPaymentPage";
import ProductAll from "../page/ProductAll";
import ProductAllHottest from "../page/ProductAllHottest";
import ProductAllNewArrival from "../page/ProductAllNewArrival";
import ProductDetail from "../page/ProductDetail";
import RegisterPage from "../page/RegisterPage";
import PrivateRoute from "./PrivateRoute";

const AppRouter = () => {

  return (
    <Routes>
      <Route path="/" element={<ProductAll />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<RegisterPage />} />
      <Route path="/product/:id" element={<ProductDetail />} />
      <Route path="/hottest" element={<ProductAllHottest />} />
      <Route path="/product" element={<ProductAll />} />
      <Route path="/new" element={<ProductAllNewArrival />} />
      <Route element={<PrivateRoute permissionLevel="customer" />}>
        <Route path="/cart" element={<CartPage />} />
        <Route path="/payment" element={<PaymentPage />} />
        <Route path="/tossPayment" element={<TossPaymentPage />} />
        <Route path="/payment/success" element={<OrderCompletePage />} />
        <Route path="/tossPayment/success" element={<OrderCompletePageToss />} />
        <Route path="/account/purchase" element={<MyPage />} />
      </Route>
      <Route element={<PrivateRoute permissionLevel="admin" />}>
        <Route path="/admin/product" element={<AdminProduct />} />
        <Route path="/admin/order" element={<AdminOrderPage />} />
      </Route>
    </Routes>
  );
};

export default AppRouter;
