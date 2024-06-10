const express = require('express');
const router = express.Router();
const authController = require('../controller/authController');
const orderController = require('../controller/orderController');

router.post("/", authController.authenticate, orderController.createOrder);

module.exports = router;