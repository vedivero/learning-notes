//로그인 하지 않은 유저가, 로그인이 필요한 페이지에 접근했을 경우를 제어
import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

const ProtectedRoutes = ({ isAuth }) => {
   return isAuth ? <Outlet /> : <Navigate to={'/login'} />;
};

export default ProtectedRoutes;
