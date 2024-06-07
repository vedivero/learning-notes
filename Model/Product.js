const mongoose = require("mongoose")
const Schema = mongoose.Schema;

const productSchema = Schema({
	sku: { type: String, required: true, unique: true },//key value ,제품 고유번호
	name: { type: String, requieed: true },
	image: { type: String, required: true },//image URL
	category: { type: Array, required: true },//product category
	description: { type: String, required: true },//product description
	price: { type: Number, required: true },
	stock: { type: Object, required: true },
	status: { type: String, defualt: "active" },
	isDeleted: { type: Boolean, default: false }
}, { timestamps: true })

//조회되는 정보 정제(불필요한 정보 제거)
productSchema.methods.toJSON = function () {
	const obj = this._doc
	delete obj.password
	delete obj.__v
	delete obj.updatedAt
	delete obj.createdAt
	return obj;
}

//'Product'라는 이름의 모델을 생성하여 MongoDB 컬렉션과 매핑
//productSchema는 해당 모델의 스키마를 정의
const Product = mongoose.model("Product", productSchema)

//Product 모델을 모듈의 외부로 내보내어 다른 파일에서 사용할 수 있도록 함
module.exports = Product;