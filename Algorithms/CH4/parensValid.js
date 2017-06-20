
function parensValid(str){
	var count = 0, bool = true;
	for(var i =0; i < str.length; i++){
		if(str[i] == "("){
			count++;
		}
		else if(str[i] == ")"){
			count--;
		}
		if(count == -1){
			bool =  false;
			break;
		}
	}
	if(count != 0){
		bool =  false;
	}
	return bool;
}

str = "Good)d((da)y"
str1 = "Y(3(p)p(3)r)s"
str2 = "N(0(p)3"
str3 = "N(0)t )0(k"

console.log(parensValid(str));
console.log(parensValid(str1))
console.log(parensValid(str2))
console.log(parensValid(str3))

function bracesValid(str){
	var countpara = 0, countcurly = 0, countbrac = 0;
	var bool = true;
	for(var i = 0; i < str.length; i++){
		if(str[i] == "(" || str[i] == "{" || str[i] == "["){
			countpara++;
			countcurly++;
			countbrac++;
		}
		else if(str[i] == ")" || str[i] == "}" || str[i] == "]"){
			countpara--;
			countcurly--;
			countbrac--;
		}
		if(countpara == -1 || countcurly == -1 || countbrac==-1){
			bool = false;
			break;
		}
	}
	if(countpara != 0 || countcurly != 0 || countbrac != 0){
		bool = false;
	}
	return bool;
}

function bracesValid(str){
	var arr = [], bool = true;
	for(var i = 0; i < str.length; i++){
		if(str[i] == "(" || str[i] == "{" || str[i] == "["){
			arr.push(str[i])
		}
		if(str[i] == ")" || str[i] == "}" || str[i] == "]"){
			if(arr.length > 0){
				var temp = "";
				switch(str[i]){
					case ")":
						temp = "(";
						break;
					case "}":
						temp = "{"
						break;
					case "]":
						temp = '['
						break;
					default:
						temp = "";
				}
				if(temp == arr.pop()){
					continue;
				}
				else{
					return false;
				}
			}
			else{
				return false
			}
		}
	}
	if(arr.length > 0){
		return false
	}
	return bool;
}
str4 = "W(a{t}s[0(n{ c}o)m]e )h[e{r}e]!"
str5 = "D(i{a}l[ t]o)n{e"
console.log("New")
console.log(bracesValid(str4))
console.log(bracesValid(str5))
console.log(bracesValid("{(})"))
