//BASIC 1
console.log("BASIC 1")
var x = []
console.log(x)
x.push("coding", "dojo", "rocks")
console.log(x)
x.pop()
console.log(x)

//BASIC 2
console.log("BASIC 2")
const y = []
console.log(y)
y.push(88)
console.log(y)

//BASIC 3
console.log("BASIC 3")
let z = [9, 10, 6, 5, -1, 20, 13, 2]
for(let i = 0; i < z.length; i++){
    console.log(z[i])
}
for(let i = 0; i < (z.length-1); i++){
    console.log(z[i])
}

//BASIC 4
console.log("BASIC 4")
var names = ['Kadie', 'Joe', 'Fritz', 'Pierre', 'Alphonso']
for(let i = 0; i < names.length; i++){
    console.log(names[i].length)
}
for(let i = 0; i < names.length; i++){
    if(names[i].length == 5){
        console.log(names[i])
    }
}

//BASIC 5
console.log("BASIC 5")
let yell = function(string){
    return string.toUpperCase();
}

console.log(yell("what"))

