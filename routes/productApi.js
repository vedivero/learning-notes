const express = require('express');
const authController = require('../controller/authController');
const productContoller = require('../controller/productController');
const router = express.Router();


//상품 생성
router.post(
	"/",
	authController.authenticate,
	authController.checkAdminPermission,
	productContoller.createProduct
);

//상품 정보 조회
router.get("/", productContoller.getProducts);

//상품 정보 수정
router.put(
	"/:id",
	authController.authenticate,
	authController.checkAdminPermission,
	productContoller.updateProduct
)

router.delete(
	"/:id",
	authController.authenticate,
	authController.checkAdminPermission,
	productContoller.deleteProduct
);

module.exports = router;