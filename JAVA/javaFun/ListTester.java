import java.lang.*;
import java.util.*;
public class ListTester{
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.add(1);
        sll.add(1);
        sll.add(3);
        sll.add(1);
        sll.add(5);
        sll.add(1);
        sll.add(17);
        sll.printValues();
        sll.remove();
        sll.remove();
        sll.printValues();
        sll.find(3);
        sll.removeAt(2);
        sll.printValues();
        

    }
}