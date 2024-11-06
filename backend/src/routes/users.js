const express = require('express');
const router = express.Router();
const jwt = require('jsonwebtoken');
const auth = require('../middleware/auth');
const User = require('../models/User');

router.get('/auth', auth, (req, res) => {
   return res.status(200).json({
      _id: req.user._id,
      email: req.user.email,
      name: req.user.name,
      role: req.user.role,
      image: req.user.image,
      cart: req.user.cart,
      history: req.user.history,
   });
});

router.post('/register', async (req, res, next) => {
   try {
      const user = new User(req.body);
      await user.save();
      return res.sendStatus(200);
   } catch (error) {
      next(error);
   }
});

router.post('/login', async (req, res, next) => {
   try {
      const user = await User.findOne({ email: req.body.email });
      if (!user) return res.status(400).send('Auth failed, email not found');

      const isMatch = await user.comparePassword(req.body.password);
      if (!isMatch) return res.status(400).send('Wrong password');

      const payload = {
         userId: user._id.toHexString(),
      };

      const accessToken = jwt.sign(payload, process.env.JWT_SECRET, { expiresIn: '1h' });

      return res.json({ user, accessToken });
   } catch (error) {
      next(error);
   }
});

router.post('/logout', auth, async (req, res, next) => {
   try {
      return res.sendStatus(200);
   } catch (error) {
      next(error);
   }
});

router.post('/cart', auth, async (req, res, next) => {
   try {
      const userInfo = await User.findOne({ _id: req.user._id });

      let duplicate = false;
      userInfo.cart.forEach((item) => {
         if (item.id === req.body.productId) {
            duplicate = true;
         }
      });

      if (duplicate) {
         const user = await User.findOneAndUpdate(
            { _id: req.user._id, 'cart.id': req.body.productId },
            { $inc: { 'cart.$.quantity': 1 } },
            { new: true },
         );
         return res.status(201).send(user.cart);
      } else {
         const user = await User.findOneAndUpdate(
            { _id: req.user._id },
            {
               $push: {
                  cart: {
                     id: req.body.productId,
                     quantity: 1,
                     date: Date.now(),
                  },
               },
            },
            { new: true },
         );
         return res.status(201);
      }
   } catch (error) {
      next(error);
   }
});

module.exports = router;
