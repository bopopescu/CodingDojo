
public class Person {
	private int age;
	private String name;
	private static int numberofPpl = 0;
	
    public Person(int ageParam, String nameParam) {
        age = ageParam;
        name = nameParam;
        numberofPpl++;
    }
    
    public static int peopleCount() {
        return numberofPpl;
    }
	
	
}
