const mongoose = require("mongoose");
const User = require("./User");
const Product = require("./Product");
const Cart = require("./Cart");
const Schema = mongoose.Schema;
const orderSchema = Schema(
	{
		userId: { type: mongoose.ObjectId, ref: User },	//ID
		status: { type: String, default: "preparing" },	//주문상태
		totalPrice: { type: Number, required: true, default: 0 },	//총 가격
		shipTo: { type: Object, required: true },	//배송주소
		contact: { type: Object, required: true },	//연락처
		orderNum: { type: String },	//주문번호
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

//주문 완료된 상품 카트에서 제거
orderSchema.post("save", async function () {
	const cart = await Cart.findOne({ userId: this.userId });
	cart.items = [];
	await cart.save();
});

//Order 모델을 모듈의 외부로 내보내어 다른 파일에서 사용할 수 있도록 함
const Order = mongoose.model("Order", orderSchema);
module.exports = Order;