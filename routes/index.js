const express = require("express");
const router = express.Router();

const userApi = require("./userApi");
const authApi = require("./authApi");
const productApi = require("./productApi");
const cartApi = require("./cartApi");
const orderApi = require("./orderApi");

router.use("/user", userApi);
router.use("/auth", authApi);
router.use("/product", productApi);
router.use("/cart", cartApi);
router.use("/order", orderApi);

module.exports = router;