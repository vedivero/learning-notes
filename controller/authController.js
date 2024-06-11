// 필요한 모듈들을 임포트
const jwt = require("jsonwebtoken");
const User = require("../Model/User");
const bcrypt = require("bcryptjs");
require("dotenv").config();
const JWT_SECRET_KEY = process.env.JWT_SECRET_KEY;
const { OAuth2Client } = require('google-auth-library');
const GOOGLE_CLIENT_ID = process.env.GOOGLE_CLIENT_ID;

// authController 객체를 생성
const authController = {};

// 이메일로 로그인하는 함수 정의
authController.loginWithEmail = async (req, res) => {
	try {
		// 요청 본문에서 이메일과 비밀번호를 추출
		const { email, password } = req.body;
		// 데이터베이스에서 이메일로 사용자 검색
		let user = await User.findOne({ email });
		// 사용자가 존재하면 비밀번호 일치 여부 확인
		if (user) {
			const isMatch = await bcrypt.compare(password, user.password);
			// 비밀번호가 일치하면 토큰 생성 후 응답
			if (isMatch) {
				const token = await user.generateToken();
				return res.status(200).json({ status: "Login success", user, token });
			}
		}
		// 이메일 또는 비밀번호가 일치하지 않으면 에러 발생
		throw new Error("이메일 또는 비밀번호가 일치하지 않습니다.");
	} catch (error) {
		// 에러 발생 시 실패 응답 반환
		return res.status(400).json({ status: "Fail login", error: error.message });
	}
}

// 구글 로그인을 처리하는 함수 정의
authController.loginWithGoogle = async (req, res) => {
	try {
		// 요청 본문에서 토큰을 추출
		const { token } = req.body;
		const googleClient = new OAuth2Client(GOOGLE_CLIENT_ID);
		// 구글 토큰 검증
		const ticket = await googleClient.verifyIdToken({
			idToken: token,
			audience: GOOGLE_CLIENT_ID
		});
		// 검증된 토큰에서 이메일과 이름을 추출
		const { email, name } = ticket.getPayload();
		// 데이터베이스에서 이메일로 사용자 검색
		let user = await User.findOne({ email });
		// 사용자가 없으면 새 사용자 생성
		if (!user) {
			const randomPassword = "" + Math.floor(Math.random() * 10000000);
			const salt = await bcrypt.genSalt(10);
			const newPassword = await bcrypt.hash(randomPassword, salt);
			user = new User({
				name,
				email,
				password: newPassword
			});
			await user.save();
		}
		// 토큰 생성 후 응답
		const sessionToken = await user.generateToken();
		return res.status(200).json({ status: "Success Google Login", user, token: sessionToken });
	} catch (error) {
		// 에러 발생 시 실패 응답 반환
		return res.status(400).json({ status: "Fail Google login", error: error.message });
	}
}

// 인증 미들웨어 정의
authController.authenticate = async (req, res, next) => {
	try {
		// 헤더에서 토큰 값 가져오기
		const tokenString = req.headers.authorization;
		if (!tokenString) throw new Error("Can not find token String");
		const token = tokenString.replace("Bearer ", "");
		// 토큰이 유효하면, 토큰의 payload를 반환
		jwt.verify(token, JWT_SECRET_KEY, (error, payload) => {
			if (error) throw new Error("Can not find token");
			req.userId = payload._id;
		});
		next();
	} catch (error) {
		// 에러 발생 시 실패 응답 반환
		return res.status(400).json({ status: "토큰 조회 실패", error: error.message });
	}
}

// 관리자 권한 확인 미들웨어 정의
authController.checkAdminPermission = async (req, res, next) => {
	try {
		// 요청에서 사용자 ID를 추출
		const { userId } = req;
		// 데이터베이스에서 사용자 검색
		const user = await User.findById(userId);
		// 사용자가 관리자 레벨이 아니면 에러 발생
		if (user.level !== "admin") throw new Error("This is not administrative.");
		next();
	} catch (error) {
		// 에러 발생 시 실패 응답 반환
		return res.status(400).json({ status: "checkAdminPermission FAIL", error: error.message });
	}
}

// authController 객체를 모듈로 내보내기
module.exports = authController;
