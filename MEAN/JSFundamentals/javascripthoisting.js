console.log(hello);
var hello = "world";
//prediction: error!
//actual: undefined

var needle = 'haystack';
test();

function test(){
	var needle = 'magnet';
	console.log(needle);
}
//prediction: error!
//actual: 'magent'

var brendan = 'super cool';
function print(){
	brendan = 'only okay';
	console.log(brendan);
}
console.log(brendan);
//prediction: super cool
//actual: super cool

var food = 'chicken';
console.log(food);
eat();
function eat(){
	food = '‘half-chicken’';
	console.log(food);
	var food = '‘gone’';
}

//prediction: chicken, half-chicken, gone
//actual: chicken, half-chicken

//mean();
console.log(food);
var mean = function() {
	food = "chicken";
	console.log(food);
	var food = "fish";
	console.log(food);
}
console.log(food);
//prediction: chicken, fish, fish, fish
//actual: error

console.log(genre);
var genre = "disco";
rewind();
function rewind() {
	genre = "rock";
	console.log(genre);
	var genre = "r&b";
	console.log(genre);
}
console.log(genre);
//prediction: undefined, rock, r&b, disco
//actual: undefined, rock, r&b, disco

dojo = "san jose";
console.log(dojo);
learn();
function learn() {
	dojo = "seattle";
	console.log(dojo);
	var dojo = "burbank";
	console.log(dojo);
}
console.log(dojo);
//prediction: san jose, seattle, burbank, san jose
//actual: san jose, seattle, burbank, san jose



//----------------------------------------------------------
// for(var i =0; i<10; i++){}
// console.log(i)

// for(let j =0; j<10; j++){}
// console.log(j)

//the differences from above is that var i will still print 10 and let j will throw an error