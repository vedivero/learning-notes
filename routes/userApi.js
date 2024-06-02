const express = require("express");
const userController = require("../controller/userController");
const authController = require("../controller/authController");
const router = express.Router();


//user 생성(회원가입)
router.post("/", userController.createUser);

//token값을 header에 넣어 보냄 -> get사용 (fe:api.js 참고)
router.get("/me", authController.authenticate, userController.getUser);//token처리 후, user정보 조회


module.exports = router;
