//로그인 된 유저가 '회원가입', '로그인' 페이지로 접근하지 못하도록 -> return main page
import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

const NotAuthRoutes = ({ isAuth }) => {
   return isAuth ? <Navigate to={'/'} /> : <Outlet />;
};

export default NotAuthRoutes;
