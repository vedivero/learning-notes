const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const Product = require('../models/Product');
const multer = require('multer');

const storage = multer.diskStorage({
   destination: function (req, file, cb) {
      cb(null, 'uploads/');
   },
   filename: function (req, file, cb) {
      cb(null, `${Date.now()}_${file.originalname}`);
   },
});

const upload = multer({ storage: storage }).single('file');

router.post('/image', auth, (req, res, next) => {
   upload(req, res, (err) => {
      if (err) {
         return req.status(500).send(err);
      }
      return res.json({ fileName: res.req.file.filename });
   });
});

router.get('/', async (req, res) => {
   try {
      const products = await Product.find().populate('writer');
      return res.status(200).json({ products });
   } catch (error) {
      next(error);
   }
});

router.post('/', auth, (req, res) => {
   try {
      console.log('req.body : ', req.body);
      const product = new Product(req.body);
      product.save();
      return res.sendStatus(201);
   } catch (error) {
      next(error);
   }
});

module.exports = router;
