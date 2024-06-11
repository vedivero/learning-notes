const express = require("express");
const router = express.Router();
const authController = require("../controller/authController");

//로그인
router.post('/login', authController.loginWithEmail);
//구글 로그인
router.post('/google', authController.loginWithGoogle);


module.exports = router;