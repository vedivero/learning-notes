const express = require("express");
const router = express.Router();
const authController = require("../controller/authController");
const cartController = require("../controller/cartController");

//장바구니에 아이템 넣기
router.post('/', authController.authenticate, cartController.addItemToCart);

//카트 리스트 보기
router.get("/", authController.authenticate, cartController.getCart);

//카트리스트에서 삭제
router.delete("/:id", authController.authenticate, cartController.deleteCartItem)

//카트 상품 개수 수정
router.put("/:id", authController.authenticate, cartController.editCartItem);

//카트 개수 선택에 따른 총액 계산
router.get("/qty", authController.authenticate, cartController.getCartQty);


module.exports = router;