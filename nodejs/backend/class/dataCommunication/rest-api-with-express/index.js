import express from 'express';

const app = express();


app.get('/boards', function (req, res) {
   
   res.send('Hello World!');
});

app.post('/boards',function(req,res){
   res.send("POST/boards")
})


app.listen(3000);
