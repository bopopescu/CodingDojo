import java.lang.*;
import java.util.*;
public class Basics {
    public static void main(String[] args) {
        /*
            Print 1-255
            Write a method that prints all the numbers from 1 to 255.
        */
        for(int i =1; i<= 255; i++){
            System.out.println(i);
        }
        /*
            Print odd numbers between 1-255
            Write a method that prints all the odd numbers from 1 to 255.
        */
        for(int i =1; i<= 255; i++){
            if(i%2 != 0){
                System.out.println(i);
            }
        }
        /*
            Print Sum
            Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far. 
        */
        Integer count=0;
        for(int i =0; i<= 255; i++){
            System.out.println("New number: "+i);
            count += i;
            System.out.println("Sum: "+ count);
        }
        /*
            Iterating through an array
            Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen.
        */
        int[] myArray = {1,3,5,7,9,13};
        for(int j =0; j < myArray.length; j++){
            System.out.println(myArray[j]);
        }
        /*
            Find Max
            Write a method (sets of instructions) that takes any array 
            and prints the maximum value in the array. 
            Your method should also work with a given array that has all 
            negative numbers (e.g. [-3, -5, -7]), or even a mix of positive numbers, 
            negative numbers and zero.

        */
        int[] disArray = {1,3,5,7,9,13, 12, -9, 50, 23, 24};
        Integer temp = 0;
        for(int j =0; j < disArray.length; j++){
            if(disArray[j] > temp){
                temp = disArray[j];
            }
        }
        System.out.println(temp);
        /*
            Get Average
            Write a method that takes an array, and prints 
            the AVERAGE of the values in the array. 
            For example for an array [2, 10, 3], 
            your method should print an average of 5. 
        */
        int[] thirdArray = {2,10, 3};
        Integer count2 = 0;
        System.out.println(thirdArray.length);
        for(int j =0; j < thirdArray.length; j++){
            count2 += thirdArray[j];
        }
        System.out.println((count2/thirdArray.length));

        /*
            Array with Odd Numbers
            Write a method that creates an array 'y' that contains all 
            the odd numbers between 1 to 255. When the method is done, 
            'y' should have the value of [1, 3, 5, 7, ... 255].
        */
        ArrayList<Integer> fourthArray = new ArrayList<Integer>();
        for(int i =1; i<= 255; i++){
            if(i%2 != 0){
                fourthArray.add(i);
            }
        }
        System.out.println(fourthArray);

        /*
            Greater Than Y
            Write a method that takes an array and returns the number 
            of values in that array whose value is greater than a given value y. 
            For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3).
        */
        int[] fifthArray = {1, 3, 5, 7};
        Integer y = 3;
        Integer count5 = 0;
        for(int k=0; k < fifthArray.length; k++){
            if(y < fifthArray[k]){
                count5++;
            }
        }
        System.out.println(count5);
        /*
            Square the values
            Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself. 
        */
        int[] sixthArray = {1, 5, 10, -2};
        System.out.println(sixthArray);
        for(int k=0; k < sixthArray.length; k++){
            System.out.println(sixthArray[k]);
            sixthArray[k] = sixthArray[k]*sixthArray[k];
            System.out.println(sixthArray[k]);
        }
        System.out.println(Arrays.toString(sixthArray));
        /*
            Eliminate Negative Numbers
            Given any array x, say [1, 5, 10, -2], write a method that replaces any 
            negative number with the value of 0. 
            When the method is done, 
            x should have no negative values, say [1, 5, 10, 0].
        */
        int[] seventhArray = {1, 5, 10, -2};
        for(int k=0; k < seventhArray.length; k++){
            if(seventhArray[k] < 0){
                seventhArray[k] = 0;
            }
        }
        System.out.println(Arrays.toString(seventhArray));
        /*
            Max, Min, and Average
            Given any array x, say [1, 5, 10, -2], write a method that returns an array 
            with the maximum number in the array, the minimum value in the array, 
            and the average of the values in the array. 
            The returned array should be three elements long and contain: [MAXNUM, MINNUM, AVG]

        */
        ArrayList<Integer> eigthArray = new ArrayList<Integer>();
        int[] ninthArray = {1, 5, 10, -2};
        Integer min = 0;
        Integer max = 0;
        Integer avg = 0;
        double count6 = 0;
        for(int i =0; i< ninthArray.length; i++){
            if(max < ninthArray[i]){
                max = ninthArray[i];
            }
            if(min > ninthArray[i]){
                min = ninthArray[i];
            }
            count6 += ninthArray[i];
        }
        double getsomenumberforavg =  (double) ((count6)/(ninthArray.length));
        System.out.println("MAX " + max);
        System.out.println("MIN " + min);
        System.out.println("AVG " + getsomenumberforavg);
        System.out.println(Arrays.toString(ninthArray));
        /*
            Shifting the Values in the Array
            Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front.
        */
        int[] tenthArray = {1, 5, 10, 7, -2};
        for(int m =0; m < tenthArray.length-1; m++){
            tenthArray[m] = tenthArray[m+1];
        }
        tenthArray[tenthArray.length-1] = 0;
        System.out.println(Arrays.toString(tenthArray));

    }
}