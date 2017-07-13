function fib() {
  // Some variables here
  var get = 0;
  var sum = 0
  var count = 1;
  function nacci() {
      get = get+count
      count = get
      if(get <= 1){
        get = get;
      }
      else {
        nacci
      }
    // do something to those variables here
    console.log(get)
  }
  return nacci
}
var fibCounter = fib();
fibCounter() // should console.log "1"
fibCounter() // should console.log "1"
fibCounter() // should console.log "2"
fibCounter() // should console.log "3"
fibCounter() // should console.log "5"
fibCounter() // should console.log "8"

