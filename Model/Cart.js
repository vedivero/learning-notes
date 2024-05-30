const mongoose = require("mongoose");
const User = require("./User");
const Product = require("./Product");
const Schema = mongoose.Schema;

const cartSchema = Schema({
	userId: { type: mongoose.ObjectId, ref: User },//key value ,제품 고유번호
	items: [{
		productId: { type: mongoose.ObjectId, ref: Product }, //선택한 아이템
		size: { type: String, required: true },
		qty: { type: Number, default: 1, required: true }
	}],
	image: { type: String, required: true },//image URL
}, { timestamps: true })

//조회되는 정보 정제(불필요한 정보 제거)
cartSchema.methods.toJSON = function () {
	const obj = tihs._doc
	delete obj.password
	delete obj.__v
	delete obj.updatedAt
	delete obj.createdAt
	return obj
}

//'Cart'라는 이름의 모델을 생성하여 MongoDB 컬렉션과 매핑
//cartSchema는 해당 모델의 스키마를 정의
const Cart = mongoose.model("Cart", cartSchema)

//Cart 모델을 모듈의 외부로 내보내어 다른 파일에서 사용할 수 있도록 함
module.exports = Cart;