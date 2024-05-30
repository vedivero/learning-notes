const mongoose = require("mongoose");
const User = require("./User");
const Product = require("./Product");
const Schema = mongoose.Schema;
const orderSchema = Schema(
	{
		userId: { type: mongoose.ObjectId, ref: User },
		status: { type: String, default: "preparing" },
		totalPrice: { type: Number, required: true, default: 0 },
		shipTo: { type: Object, required: true },
		contact: { type: Object, required: true },
		orderNum: { type: String },
		items: [
			{
				productId: { type: mongoose.ObjectId, ref: Product },
				price: { type: Number, required: true },
				qty: { type: Number, required: true, default: 1 },
				size: { type: String, required: true },
			},
		],
	},
	{ timestamps: true }
);

//'Order'라는 이름의 모델을 생성하여 MongoDB 컬렉션과 매핑
//orderSchema는 해당 모델의 스키마를 정의
orderSchema.methods.toJSON = function () {
	const obj = this._doc;
	delete obj.__v;
	delete obj.updatedAt;
	return obj;
};

//Order 모델을 모듈의 외부로 내보내어 다른 파일에서 사용할 수 있도록 함
const Order = mongoose.model("Order", orderSchema);
module.exports = Order;