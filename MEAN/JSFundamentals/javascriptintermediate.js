function star_string(num){
    let x = ""
    for(let i = 0; i < num; i++){
        x += "*"
    }
    return x
}

let stars = star_string(8)
console.log(stars)
console.log("Part II")
function draw_stars(arr){
    let y = ""
    for(let i = 0; i < arr.length; i++){
        if(typeof arr[i] == "string"){
            num = arr[i].length
            add = arr[i][0].toLowerCase()
        }
        else{
            num = arr[i]
            add = "*"
        }

        for(let j = 0; j < num; j++){
                y += add
        }
        y += "\n"
    }
    return y
}
let x = [4, 6, 1, 3, 5, 7, 25]
console.log(draw_stars(x))
console.log("Part III")
let y = [4, "Tom", 1, "Michael", 5, 7, "Jimmy Smith"]
console.log(draw_stars(y))