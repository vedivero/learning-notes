const express = require("express");
const router = express.Router();
const authController = require("../controller/authController");
const cartController = require("../controller/cartController");

router.post('/', authController.authenticate, cartController.addItemToCart);


module.exports = router;