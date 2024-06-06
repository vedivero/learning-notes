//스키마 스크립트 호출
const User = require("../Model/User");
//npm 암호화 라이브러리
const bcrypt = require("bcryptjs");

const userController = {};

//회원가입 기능(name, email, password)
userController.createUser = async (req, res) => {
	try {
		//입력 정보 받아오기
		let { email, password, name, level } = req.body;
		//가입여부 DB 체크
		const user = await User.findOne({ email });
		console.log("■ user : ", user)
		//이미 가입된 유저정보가 존재하는 경우
		if (user) {
			throw new Error("이미 존재하는 Email 입니다.");
		}

		//패스워드 암호화
		// bcrypt 라이브러리의 genSaltSync 메서드 사용하여 암호화
		const salt = await bcrypt.genSaltSync(10);
		//비밀번호를 해시화
		password = await bcrypt.hash(password, salt);

		const newUser = new User({ email, password, name, level: level ? level : 'customer' });

		await newUser.save();
		return res.status(200).json({ status: "Success regist user" });

	} catch (error) {
		return res.status(400).json({ status: "Fail - create user", error: error.message })
	}
}


//토큰 값으로 회원정보 조회
userController.getUser = async (req, res) => {

	try {
		//authController.authenticate에서 전달된 userId값 저장
		const { userId } = req;
		const user = await User.findById(userId);
		console.log("■ User.findById : ", user);
		if (user) {
			return res.status(200).json({ status: "회원 정보 조회 성공", user });
		}
		throw new Error("토큰 정보가 올바르지 않습니다.");
	} catch (error) {
		return res.status(400).json({ status: "회원 정보 조회 실패", error: error.message });
	}

};


module.exports = userController;