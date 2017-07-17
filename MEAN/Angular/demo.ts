let myNum = 5
var myNumber: number = 5;
let myString = "Hello Universe"
var myString1: string = "Hello Universe";
var myArr: number[] = [1, 2, 3, 4];
const myObj = {
    name: 'Bill'
}

var anythingVariable: any = "Hey"
var anythingVariable: any = 25

var arrayOne: boolean[] = [true, false, true, true]
var arrayTwo: any[] = [1, 'abc', true, 2];

class MyNode {
	val: number;
    _priv: number
	
    constructor(val: number) {
        this.val = 0
		this.val = val;
	}
	doSomethingFun(){
		this._priv = 10;
	}
}
let myNodeInstance = new MyNode(1);
console.log(myNodeInstance)

function myFunction(): void{
	console.log("Hello World");
	return;
}

function sendingErrors(): never {
	throw new Error('Error message');
}




