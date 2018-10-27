import java.util.*;
import CtCILibrary.LinkedListNode;

/*
public LinkedListNode next;
public LinkedListNode prev;
public LinkedListNode last;
public int data;
public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
    data = d;
    setNext(n);
    setPrevious(p);
}
*/
public class My_QuestionA{
    public static void deleteDups( LinkedListNode head ){
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.data);
        while( head.next != null ){
            if( !set.add(head.next.data) ){
                head.next = head.next.next;
            }
            else
            {
                head = head.next;
            }
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