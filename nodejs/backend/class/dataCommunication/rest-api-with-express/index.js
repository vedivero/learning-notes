//const express = require('express')//예전 방식 => commonjs
import express from 'express'; //최근 방식 => module

const app = express();

//get방식의 API를 생성
app.get('/getTest', function (req, res) {
   //Middleware function
   res.send('Hello World');
});

//Port Number
app.listen(3000);
