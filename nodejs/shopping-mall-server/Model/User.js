const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const userSchema = new Schema(
   {
      email: { type: String, required: true, unique: true }, // 이메일
      password: { type: String, required: true }, // 비밀번호
      name: { type: String, required: true }, // 이름
      phoneNumber: { type: String, required: true }, // 전화번호
      address_line1: { type: String, required: true }, // 기본주소
      address_line2: { type: String, required: true }, // 상세주소
      role: { type: String, required: true }, // 사용자권한
      status: { type: String, required: true }, // 계정상태
      last_login_at: { type: Date, default: null }, // 마지막접속
      failed_login_cnt: { type: Number, default: 0 }, // 로그인실패횟수
      newsletter_opt_in: { type: Boolean, default: false }, // 뉴스레터 수신동의
      sms_opt_in: { type: Boolean, default: false }, // SMS 수신동의
      verification_code: { type: String, default: null }, // 이메일 인증 코드
      reset_password_token: { type: String, default: null }, // 비밀번호 초기화 토큰
      updated_at: { type: Date, default: Date.now }, // 회원정보 수정일
      register_at: { type: Date, default: Date.now }, // 회원가입일
   },
   { timestamp },
);

userSchema.methods.toJson = function () {
   const obj = this._doc;
   delete obj.password;
   delete obj.__v;
   return obj;
};

const User = mongoose.model('User', userSchema);
module.exports = User;
