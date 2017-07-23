

module.exports = function(app){
    app.get('/', function(req, res) {
    console.log("hello!")
    res.send("<h1>Hello Express</h1>");
    });    
  app.get('/products', (req, res, next)=>{
    res.send("<h1>In products</h1>");
    res.json(true)
    
  });
  app.get('/products/:id', (req, res, next)=>{
    res.json(true)
  });
  app.post('/products', (req, res, next)=>{
    res.json(true)
  });
  app.put('/products/:id', (req, res, next)=>{
    res.json(true)
  });
//   app.delete('/products/:id', (req, res, next)=>{
//     res.json(true)
//   });
    app.all("*", (req,res,next) => {
        res.sendfile(path.resolve("./../BlackBelt/dist/index.html"))
    });
  
}