function string_compression(string){
    count = 1
    newstr = ""
    for(var i = 0; i < string.length;i++ ){
        if(string[i] == string[i+1]){
            count++;
        }
        else if(string[i] == string[i-1] && string[i]!= string[i+1]){
            newstr = newstr+string[i]+count
            count = 1
        }
        else if(string[i] != string[i+1]){
            count = 1;
            newstr = newstr+string[i]+count
            count = 1
        }
    }

    if(newstr.length == string.length){
        return string
    }
    else{
        return newstr
    }
}

function compressStr(inStr){
    var newStr = "";
    var newArr = []
    var arr = inStr.split("")
    var arrSize = arr.length;
    var i = 0, count = 1;
    var j = i+1;
    while(j != arrSize){
        if(arr[i] == arr[j]){
            count++;
        }
        else{
            newArr.push(arr[j])
            newArr.push(count)
            count = 1
        }
        i++
        j++
    }
    console.log(newArr)
    newStr = newArr.join('')
    if(inStr.length >= newStr.length){
        return newStr;
    }
    return newStr;
}

console.log(string_compression("aabcccccaaa"))
console.log(compressStr("aabcccccaaa"))