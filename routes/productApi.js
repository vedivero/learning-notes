const express = require('express');
const authController = require('../controller/authController');
const productContoller = require('../controller/productController');
const router = express.Router();


//상품 생성
router.post(
	"/",
	authController.authenticate,
	authController.checkAdminPermission,
	productContoller.createProduct);


module.exports = router;