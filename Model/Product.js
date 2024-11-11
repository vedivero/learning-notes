const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const productSchema = new Schema(
   {
      product_id: { type: String, required: true, unique: true }, // 제품 ID
      sku: { type: String, required: true, unique: true }, // SKU (재고 관리 코드)
      name: { type: String, required: true }, // 제품 이름
      image: { type: Array, required: true }, // 이미지 URL
      price: { type: Number, required: true }, // 가격
      description: { type: String }, // 설명
      stock: { type: Object, required: true }, // 재고
      category: { type: Array, required: true }, // 카테고리
      status: { type: String, required: true, defualt: 'active' }, // 상태 (예: 활성화, 비활성화)
      isDeleted: { type: Boolean, default: false }, // 삭제 여부
      updated_at: { type: Date, default: Date.now }, // 업데이트 날짜
      created_at: { type: Date, default: Date.now }, // 생성 날짜
   },
   { timestamp },
);

productSchema.methods.toJson = function () {
   const obj = this._doc;
   delete obj.__v;
   return obj;
};

const Product = mongoose.model('Product', productSchema);
module.exports = Product;
