function zero_negativity(arr){
    for(let i = 0; i < arr.length; i++){
        if(arr[i] < 0){
            return false;
        }
    }
    return true;
}

arr = [23,43,5,2,43,4]
console.log(zero_negativity(arr))
arr1 = [32,4,5,3,-3,5]
console.log(zero_negativity(arr1))

console.log("Math 2")
function is_even(num){
    if(num%2 == 0){
        return true;
    }
    return false;
}

console.log(is_even(4))
console.log(is_even(45))

console.log("Math 3")
function how_many_even(arr){
    let count = 0
    for(let j = 0; j < arr.length; j++){
        if(is_even(arr[j])){
            count += 1
        }
    }
    return count
}
arr = [23,43,5,2,43,4]
console.log(how_many_even(arr))
arr1 = [32,4,5,3,-3,5, 12]
console.log(how_many_even(arr1))

function create_dummy_array(n){
    arr = []
    for(var i = 0; i < n; i++){
        let x = Math.floor(Math.random() * 10);
        arr.push(x)
    }
    return arr
}
console.log(create_dummy_array(10))

function random_choice(arr){
    let get = Math.floor(Math.random() * arr.length);
    return arr[get]
}
arr = [23,43,5,2,43,4]
console.log(random_choice(arr))
arr1 = [32,4,5,3,-3,5, 12]
console.log(random_choice(arr1))
