import java.lang.*;

public class PersonTest {
    public static void main(String[] args) {
        Person get = new Person();
        Person get2 = new Person(100);
        Person get3 = new Person(50, "Sushma");
        Ninja get4 = new Ninja();
        get.setEnergy(100);
        System.out.println(get.getEnergy());
        get2.setEnergy(200);
        System.out.println(get2.getEnergy());

        System.out.println(get.getName());
        System.out.println(get2.getName());
        System.out.println(get3.getName());
        get3.sayHello();
        get4.sayHello();
    }
}