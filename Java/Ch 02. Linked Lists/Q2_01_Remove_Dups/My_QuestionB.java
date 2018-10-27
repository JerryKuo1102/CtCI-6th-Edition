import java.util.*;
import CtCILibrary.LinkedListNode;

public class My_QuestionB{
    public static void deleteDups( LinkedListNode head ){
        boolean flag = false;
        LinkedListNode runner;
        while( head.next != null ){
            runner = head;
            while( runner.next != null ){
                //check
                if( head.data == runner.next.data ){
                    runner.next = runner.next.next;
                }
                else
                {
                    runner = runner.next;
                }
            }
            if( head.next != null)
                head = head.next;
        }
    }

    public static void main( String[] args ){
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
    }
}