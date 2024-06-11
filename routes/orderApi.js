const express = require('express');
const router = express.Router();
const authController = require('../controller/authController');
const orderController = require('../controller/orderController');

// 주문 생성 요청을 처리하는 라우트 정의
router.post("/", authController.authenticate, orderController.createOrder);

// 사용자 자신의 주문을 조회하는 라우트 정의
router.get("/me", authController.authenticate, orderController.getOrder);

// 모든 주문 목록을 조회하는 라우트 정의
router.get("/", authController.authenticate, orderController.getOrderList);

// 특정 주문의 상태를 업데이트하는 라우트 정의
router.put(
	"/:id",
	authController.authenticate,
	authController.checkAdminPermission,
	orderController.updateOrder
);

module.exports = router;