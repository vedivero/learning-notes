const express = require("express");
const router = express.Router();
const authController = require("../controller/authController");
const cartController = require("../controller/cartController");

//장바구니에 아이템 넣기
router.post('/', authController.authenticate, cartController.addItemToCart);

//카트 리스트 보기
router.get("/", authController.authenticate, cartController.getCart);

module.exports = router;