function palindrome(word){
    word = word.toLowerCase();
    console.log("wait what")
    console.log(word)
    word = word.split("");
    console.log(word)
    getword = [];
    for(var i = 0; i < word.length; i++){
        if(word[i] != " "){
            getword.push(word[i])
        }
    }
    //getword = getword.join("")
    console.log(getword)
    midpart = Math.floor(getword.length/2)
    console.log(midpart)
    count = 0;
    num = 1
    while(count < midpart){
        for(var j =0; j < getword.length; j++){
            var k = Math.floor((j + (getword.length/(num)))-1);
            console.log(k)
            m = 1;
            // for(var m = 1; m < getword.length; m++){
            //     console.log(getword[j])
            //     console.log(getword[m])
            //     if(getword[j] == getword[m]){
            //         console.log("matches!")
            //         console.log(k)
            //         console.log(getword[k])
            //         temp = getword[k]
            //         getword[k] = getword[m]
            //         getword[m] = temp
            //         console.log(getword)
            //         bool = true
            //         j++
            //     }
            // }
        }
        console.log(getword)
        num++
        count++
    }
}

palindrome("Taco Atc")