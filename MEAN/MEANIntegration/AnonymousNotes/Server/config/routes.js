var path = require('path')
var note = require('../controllers/notes.js')
module.exports = function(app){
    app.get('/notes', function(req, res) {
        console.log("hello sdsdsds!")
        // res.send("<h1>Hello Express</h1>");
        note.show(req, res)
    });    
  // app.get('/notes', (req, res, next)=>{
  //   note.show(req, res)
  //   res.json(true)
    
  // });
//   app.get('/products/:id', (req, res, next)=>{
//     res.json(true)
//   });
  app.post('/notes', (req, res, next)=>{
    console.log("dsdsd")
    note.create(req, res)
  });
//   app.put('/products/:id', (req, res, next)=>{
//     res.json(true)
//   });
// //   app.delete('/products/:id', (req, res, next)=>{
// //     res.json(true)
// //   });
    app.all("*", (req,res,next) => {
        res.sendfile(path.resolve("./../NoteApp/dist/index.html"))
    });
  
}

