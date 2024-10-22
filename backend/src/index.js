const express = require('express');
const path = require('path');
const app = express();
const cors = require('cors');
const port = 4000;
const dotenv = require('dotenv');
dotenv.config();

const mongoose = require('mongoose');

mongoose
   .connect(process.env.MONGO_URI)
   .then(() => {
      console.log('Mongoose Connection');
   })
   .catch((err) => {
      console.log(err);
   });

app.use(cors());
app.use(express.json());

app.get('/', (req, res) => {
   throw new Error('Error');
});

app.post('/', (req, res) => {
   console.log(req.body);
   res.json(req.body);
});

app.use(express.static(path.join(__dirname, '../uploads')));

app.listen(port, () => {
   console.log(`Server ON, Port Number : ${port}`);
});
