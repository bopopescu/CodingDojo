import java.lang.*;
import java.util.*;
public class SingleLinkedList{
    public Node head;


    public SingleLinkedList(){
        setHead();
    }

    public void add(int num){
        Node getnode = new Node(num);

        if(head == null){
            this.head = getnode;
        }
        else{
            Node runner = head;
            while(runner.next != null){
                runner = runner.next;
            }
            runner.next = getnode;
        }
    }

    public void remove(){
        if(head == null){
            System.out.println("No node to remove");
        }
        else{
            Node runner = head;
            while(runner.next.next != null){
                runner = runner.next;
            }
            runner.next = null;        
        }
    }

    public void printValues(){
        Node runner = head;
        while(runner != null){
            System.out.println(runner.value);
            runner = runner.next;
            
        }    
    }

    public Node find(int value){
        Node runner = head;
        int count = 0;
        while(runner != null){
            if(runner.value == value){
                System.out.println(runner);
                System.out.println(count);
                System.out.println(runner.value);
                return runner;
            }
            runner = runner.next;    
            count +=1;
        } 
        return null;
    }

    public Node removeAt(int ind){
        Node previous = head;
        int count = 0;

        if(head == null){
            System.out.println("No nodes in SLL");
        }
        else if(ind == 0){
            head = head.next;
        }else{
            while(count < ind -1){
                if(previous.next == null){
                    return null;
                }
                previous = previous.next;
                count +=1;
            }
            Node current = previous.next;
            previous.next = current.next;
            current.next = null;
        }
        return previous;
    }

    //getter for head
    public Node getHead(){
        return head;
    }

    //setter for head
    public void setHead(){
        this.head = null;
    }


}

