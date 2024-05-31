const express = require("express");
const userController = require("../controller/userController");
const router = express.Router();


//user 생성(회원가입)
router.post("/", userController.createUser);




module.exports = router;