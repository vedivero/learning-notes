const jwt = require("jsonwebtoken");
const mongoose = require("mongoose");
const Schema = mongoose.Schema;

require("dotenv").config();
const JWT_SECRET_KEY = process.env.JWT_SECRET_KEY;

const userSchema = Schema({
	email: { type: String, required: true, unique: true },
	password: { type: String, required: true },
	name: { type: String, required: true },
	level: { type: String, default: "customer" } //2types:customer, admin
}, { timestamps: true })

//조회되는 정보 정제(불필요한 정보 제거)
userSchema.methods.toJSON = function () {
	const obj = this._doc
	delete obj.password
	delete obj.__v
	delete obj.updatedAt
	delete obj.createdAt
	return obj
}

//토큰 생성
userSchema.methods.generateToken = async function () {
	const token = await jwt.sign({ _id: this._id }, JWT_SECRET_KEY, { expiresIn: "1d" });
	return token;
}


//'User'라는 이름의 모델을 생성하여 MongoDB 컬렉션과 매핑
//userSchema는 해당 모델의 스키마를 정의
const User = mongoose.model("User", userSchema)

//User 모델을 모듈의 외부로 내보내어 다른 파일에서 사용할 수 있도록 함
module.exports = User;