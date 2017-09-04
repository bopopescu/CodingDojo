function isUnique(word){
    newarr = []
    for(var i = 0; i < word.length; i++){
        if(newarr.indexOf(word[i]) >0){
            return false;
        }
        newarr.push(word[i])
    }
    return true;
}

console.log(isUnique("ssamesies"))
console.log(isUnique("what"))

function isUniqueWord(word){
    if(word.length > 128){
        return false;
    }

    newarr = [];
    for(var j = 0; j < 128; j++){
        newarr[j] = false;
    }

    for(var i = 0; i < word.length; i++){
        var val = word.indexOf(word[i])
        console.log(val)
        console.log(newarr[i])
        console.log(word[i])
        if(newarr[i]){
            return false;
        }

        newarr[i] = true;
    }
    return true
}

console.log(isUniqueWord("ssamesies"))
console.log(isUniqueWord("what"))
