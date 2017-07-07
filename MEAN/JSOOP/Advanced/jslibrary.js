var _ = {
   map: function(arr, callback) {
    if(Array.isArray(arr)){
     var newarr = []
     for(var j=0; j<arr.length; j++){
         newarr.push(callback(arr[j]))
     }
    }
    else{
        var newarr = []
        for(var j in arr){
            newarr.push(callback(arr[j]))
        }
    }
     return newarr
   },
   reduce: function(arr, callback) { 
       var get=0
        for(var i =0; i < arr.length; i++){
            get = callback(get, arr[i])
        }
    return get
     
   },
   find: function(arr, callback) {   
     for(var i = 0; i < arr.length; i++){
         if(callback(arr[i])){
            return arr[i]
         }
     }
     return undefined
   },
   filter: function(arr, callback) { 
     var newarr = []
     for(var i = 0; i < arr.length; i++){
         if(callback(arr[i])){
            newarr.push(arr[i])
         }
     }
     return newarr
     
   },
   reject: function(arr, callback) { 
     var newarr = []
     for(var i = 0; i < arr.length; i++){
         if(!callback(arr[i])){
            newarr.push(arr[i])
         }
     }
     return newarr
   }
 }
// you just created a library with 5 methods!

var evens = _.filter([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; });
console.log(evens); // if things are working right, this will return [2,4,6].

var three = _.map([1, 2, 3], function(num){ return num * 3; });
console.log(three); 

var trythree = _.map({one: 1, two: 2, three: 3}, function(num, key){ return num * 3; });
console.log(trythree)

var even = _.find([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; });
console.log(even); 

var odds = _.reject([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; });
console.log(odds); 

var sum = _.reduce([1, 2, 3], function(memo, num){ return memo + num; });
console.log(sum)