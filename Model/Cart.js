const { default: mongoose } = require('mongoose');
const User = require('./User');
const Product = require('./Product');

const cartSchema = new Schema(
   {
      cart_id: { type: String, required: true, unique: true }, // 장바구니 ID
      user_id: { type: mongoose.ObjectId, ref: User }, // 사용자 ID
      items: [
         {
            product_id: { type: mongoose.ObjectId, ref: Product }, // 제품 ID
            size: { type: String, required: true }, // 수량
            quantity: { type: Number, default: 1 }, // 수량
         },
      ],
      created_at: { type: Date, default: Date.now }, // 생성 날짜
      updated_at: { type: Date, default: Date.now }, // 업데이트 날짜
   },
   { timestamp },
);

cartSchema.methods.toJson = function () {
   const obj = this._doc;
   delete obj.__v;
   return obj;
};

const Cart = mongoose.model('Cart', cartSchema);
module.exports = Cart;
