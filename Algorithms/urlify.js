function urlify(str, number){
    if(str.length < 1){
        return null;
    }
    var str = str.split("");
    for(var i =0; i < number; i++){
        if(str[i] == " "){
            str[i] = "%20"
        }
    }
    return str.join("")
}

console.log(urlify("Mr John Smith ", 13))