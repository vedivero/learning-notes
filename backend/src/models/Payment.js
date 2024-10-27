const mongoose = require('mongoose');

const paymentSchema = mongoose.Schema(
   {
      user: {
         type: ObjectId,
      },
      data: {
         type: Array,
         default: [],
      },
      product: {
         type: Array,
         default: [],
      },
   },
   { timestamps: true },
);

const Payment = mongoose.model('Product', paymentSchema);

module.exports = Payment;
