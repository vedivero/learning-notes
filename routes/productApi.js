const express = require('express');
const authController = require('../controller/authController');
const productController = require('../controller/productController');
const router = express.Router();

// 조회수 기준으로 내림차순 정렬된 상품 목록 반환
router.get("/hottest", productController.getHottestProducts);

// 상품 조회수 증가
router.put("/:id/increment-view", productController.incrementViewCount);

// 상품 정보 조회
router.get("/", productController.getProducts);
router.get("/new", productController.getNewArrivalProducts);
router.get("/:id", productController.getProductById);

// 상품 생성
router.post(
	"/",
	authController.authenticate,
	authController.checkAdminPermission,
	productController.createProduct
);

// 상품 정보 수정
router.put(
	"/:id",
	authController.authenticate,
	authController.checkAdminPermission,
	productController.updateProduct
);

// 상품 할인율 업데이트
router.put(
	"/:id/discount",
	authController.authenticate,
	authController.checkAdminPermission,
	productController.updateProductDiscount
);

// 상품 가격 복구
router.put(
	"/:id/restore-price",
	authController.authenticate,
	authController.checkAdminPermission,
	productController.restoreProductPrice
);

// 상품 삭제
router.delete(
	"/:id",
	authController.authenticate,
	authController.checkAdminPermission,
	productController.deleteProduct
);

module.exports = router;
