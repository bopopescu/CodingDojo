import java.lang.*;
import java.util.*;
public class PuzzleJava {
    public static void FirstMethod(){
             int[] myArray = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        for(int j = 0; j < myArray.length; j++){
            sum += myArray[j];
        }
        System.out.println(sum);

         
        System.out.println(GreaterThan10(myArray));

    }
    public static ArrayList<Integer>  GreaterThan10(int[] arr){
             ArrayList<Integer> newArr = new ArrayList<Integer>();
             for(int k=0; k < arr.length; k++){
                 if(arr[k] > 10){
                    newArr.add(arr[k]);
                 }
             }
             return newArr;
    }
    public static void SecondMethod(){
        ArrayList<String> array = new ArrayList<>();
        array.add("Nancy");
        array.add("Jinichi");
        array.add("Fujibayashi");
        array.add("Momochi");
        array.add("Ishikawa");
        System.out.println(array);
        Collections.shuffle(array);
        System.out.println(array.getClass().getName());
        ArrayList<String> newarray = new ArrayList<>();
        for(int p = 0; p < array.size(); p++){
            System.out.println(array.get(p));
            
            if(array.get(p).length() > 5){

                newarray.add(array.get(p));
            }
        }
         System.out.println(newarray);

    }
    public static void shuffle(String[] array) {
        int n = array.length;
        Random random = new Random();
        // Loop over array.
        for (int i = 0; i < array.length; i++) {
            int randomValue = i + random.nextInt(n - i);
            // Swap the random element with the present element.
            String randomElement = array[randomValue];
            array[randomValue] = array[i];
            array[i] = randomElement;
        }
    }
    public static void ThirdMethod(){
        // ArrayList<String> alphaarray = new ArrayList<>();
        String[] getletter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
                            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        // for(int y = 0; y < getletter.length; y++){
        //     alphaarray.add(getletter[y]);
        // }
        shuffle(getletter);
        System.out.println(Arrays.toString(getletter));
        System.out.println("First Letter "+getletter[0]);
        System.out.println("Last Letter "+getletter[getletter.length-1]);
        String[] vowels = {"A", "E", "I", "O", "U"};
        for(int q = 0; q < vowels.length; q++){
            if(getletter[0] == vowels[q]){
                System.out.println("It's vowel");
            }
        }
        // System.out.println("3rddd");
    }
    public static  ArrayList<Integer> FourthMethod(){
        ArrayList<Integer> numarray = new ArrayList<>();
        for(int h = 0; h < 10; h++){
            Random rand = new Random();
            int n = rand.nextInt(45)+55;
            numarray.add(n);
        }
        System.out.println(numarray);
        return numarray;
    }
    public static void FifthMethod(){
	int b[] = new int[10];
	for(int h =0; h < 10; h++){
	       Random rand = new Random();
	       int n = rand.nextInt(45)+55;
	       b[h] = n;
	}
	System.out.println(Arrays.toString(b));
	int temp;
	for(int a=0; a < b.length; a++){
	    for(int j = a+1; j < b.length; j++){
	        if(b[a] > b[j]){
	            temp = b[a];
	            b[a] = b[j];
	           b[j] = temp;
	        }
	    }
	}
	System.out.println(Arrays.toString(b));
	System.out.println("MAX "+b[b.length -1]);
	System.out.println("MIN "+b[0]);
}
public static void SixthMethod(){
	String word[] = new String[5];
	String wor = "";
	String[] getletter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	
	for(int y = 0; y < 5; y++){
		shuffle(getletter);
		wor += getletter[0];
	}
	System.out.println(wor);
}
public static void SeventhMethod(){
	int i = 0;
	String[] getletter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	while(i < 10){
		String wor = "";
		for(int y = 0; y < 5; y++){
			shuffle(getletter);
			wor += getletter[0];
		}
		System.out.println(wor);
		i++;
	}
}

    public static void main(String[] args) {
        FirstMethod();
        SecondMethod();
        ThirdMethod();
        FourthMethod();
        FifthMethod();
        SixthMethod();
        SeventhMethod();
        //ArrayList<String> newArrNames = new ArrayList<String>();
        

    }

    

}