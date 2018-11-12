import CtCILibrary.*;

public class myQuestion{
    public static int printKthToLast( LinkedListNode head, int K ){
        /*
        if( head == null ) return;
        int cnt = 1;
        LinkedListNode temp = head;
        while( temp.next != null ){
            cnt++;
            temp = temp.next;
        }
        for( int i = 0; i<cnt-K-1; i++ ){
            head = head.next;
        }
        System.out.printf( "%d\n", head.data );
        */
        // boundary
        if( head == null ) return 0;
        //backing track
        int ret = printKthToLast( head.next, K ) + 1;
        if( ret == K ){
            System.out.printf( "%d\n", head.data );
        }
        return ret;
    }

    public static void main( String[] args ){
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            printKthToLast(head, i);
        }
    }
}