const jwt = require('jsonwebtoken');
const User = require('../models/User');
const dotenv = require('dotenv');
dotenv.config();

let auth = async (req, res, next) => {
   const authHeader = req.headers['authorization'];

   const token = authHeader && authHeader.split(' ')[1];
   if (token === null) return res.sendStatus(401);

   try {
      const decode = jwt.verify(token, process.env.JWT_SECRET);
      const user = await User.findOne({ _id: decode.userId });
      if (!user) return res.status(400).send('존재하지 않는 정보입니다.');

      req.user = user;
      next();
   } catch (error) {
      next(error);
   }
};

module.exports = auth;