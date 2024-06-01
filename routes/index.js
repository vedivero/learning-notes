const express = require("express")
//express에서 제공하는 router
const router = express.Router()

const userApi = require("./userApi")
const authApi = require("./authApi")

router.use("/user", userApi);
router.use("/auth", authApi);

module.exports = router;