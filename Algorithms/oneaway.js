function oneaway(getString, changedString){
    getString = getString.toLowerCase();
    changedString = changedString.toLowerCase();
    if(getString == changedString){
        return true;
    }
    twicelength = getString.length*2;
    if(getString.length+1 == changedString.length || getString.length-1 == changedString.length || getString.length == changedString.length){
        // console.log("newarr");
        if(getString.length == changedString.length || getString.length+1 == changedString.length){
            differentCount = 0;
            sameCount = 0;
            for(var i = 0; i < getString.length; i++){
                if(getString[i] == changedString[i]){
                    sameCount++;
                }
                else{
                    differentCount++;
                }
            }

            if(differentCount > 1){
                return false;
            }else{
                return true;
            }
        }
        else if(getString.length-1 == changedString.length){
            //  console.log(changedString);
            var getString = getString.split("");
            // console.log(getString)
            var changedString = changedString.split("");
            // console.log(changedString)
            for(var i = 0; i < changedString.length; i++){
                if(getString.indexOf(changedString[i]) == -1){
                    return false;
                }
            }
            return true;
        }

    }
    else{
        return false;
    }

}
  
console.log(oneaway("Pale", "Plea"))
console.log(oneaway("Pale", "Pales"))
console.log(oneaway("Pale", "Ple"))
console.log(oneaway("Pale", "bale"))