const { default: mongoose } = require('mongoose');
const userSchema = mongoose.Schema({
   name: {
      type: String,
      maxLength: 50,
   },
   email: {
      type: String,
      trim: true, //공백 제거
      unique: true,
   },
   password: {
      type: String,
      minLength: 4,
   },
   role: {
      type: Number,
      default: 0,
   },
   image: String,
});
const User = mongoose.model('User', userSchema);
module.exports = User;
