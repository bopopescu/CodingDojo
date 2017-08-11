import java.lang.*;
import java.util.*;
public class elevatorPitchTest{

//	public HelloWorld() {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++){
            //Integer castedValue = (Integer) myList.get(i);
            try{
                Integer castedValue = (Integer) myList.get(i);
                myList.set(i, castedValue);
            }
            catch (ClassCastException e) {
                System.out.println("Uh oh! You're in ClassCastException! "+i);
                System.out.println("Value: "+ myList.get(i));
                 System.out.println("Error Message: " + e.getMessage());
            }
        }


	}

    public Project(){

    }

    public Project(String name){}

    public Project(String name, String description){}

}
