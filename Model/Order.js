const orderSchema = new Schema(
   {
      order_id: { type: String, required: true, unique: true }, // 주문 ID
      userId: { type: mongoose.ObjectId, ref: User, required: true }, // 사용자 ID
      status: { type: String, default: 'preparing' }, // 주문 상태
      total_price: { type: Number, required: true, default: 0 }, // 총 가격
      order_date: { type: Date, default: Date.now }, // 주문 날짜
      items: [
         {
            productId: { type: mongoose.ObjectId, ref: Product, required: true }, // 제품 ID
            quantity: { type: Number, required: true, default: 1 }, // 수량
            price: { type: Number, required: true }, // 제품 가격
            size: { type: String, required: true }, // 사이즈
         },
      ],
      created_at: { type: Date, default: Date.now }, // 생성 날짜
      updated_at: { type: Date, default: Date.now }, // 업데이트 날짜
   },
   { timestamp },
);
orderSchema.methods.toJson = function () {
   const obj = this._doc;
   delete obj.password;
   delete obj.__v;
   return obj;
};

const Order = mongoose.model('Order', orderSchema);
module.exports = Order;
