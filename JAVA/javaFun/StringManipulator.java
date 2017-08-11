import java.lang.*;

public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();
        return str1.concat(str2);
    }
    public Integer getIndexOrNull(String str1, char letter) {
        Integer num;
        if(str1.indexOf(letter) == -1){
            return null;
        }
        return str1.indexOf(letter);
    }
    public Integer getIndexOrNull(String str1, String str2) {
        if(str1.indexOf(str2) == -1){
            return null;
        }
        return str1.indexOf(str2);
    }
    public String concatSubstring(String str1, int num1 , int num2, String str2){
        String str3 = "";
            str3 = str1.substring(num1,num2);

        return str3.concat(str2);
    }
}