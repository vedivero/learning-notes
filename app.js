//nodejs framework
const express = require('express');
//mongoose library
const mongoose = require('mongoose');
//Express 애플리케이션에서 클라이언트의 HTTP 요청 본문을 파싱하여 req.body 객체로 만들어주는 미들웨어 라이브러리
const bodyParser = require('body-parser');
//CORS Error
const cors = require('cors')
//create app using express
const app = express();

//애플리케이션 설정 및 비밀 정보를 관리
require('dotenv').config()
//Node.js 애플리케이션에서 CORS(Cross-Origin Resource Sharing) 미들웨어를 로드하기 위해 사용
app.use(cors());
//HTML 폼 데이터 파싱하여 req.body 객체로 만듦
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
//DB URL
const mongoURI = process.env.LOCAL_DB_ADDRESS;

//Mongoose를 사용하여 MongoDB에 연결
mongoose.connect(mongoURI, { useNewUrlParser: true })
	.then(() => console.log("Mongoose connected"))
	.catch((err) => console.log("FAIL DB connection", err));

app.listen(process.env.PORT || 5000, () => {
	console.log("SERVER ON")
})