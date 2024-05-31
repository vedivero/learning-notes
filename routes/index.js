const express = require("express")
//express에서 제공하는 router
const router = express.Router()

const userApi = require("./userApi")

router.use("/user", userApi)


module.exports = router;