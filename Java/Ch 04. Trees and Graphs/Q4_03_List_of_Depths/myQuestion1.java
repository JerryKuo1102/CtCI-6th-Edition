import java.util.*;

public class myQuestion1{
    public static void main( String[] args ){
        // build a binary tree
        int[] array = { 1,2,3,4,5,6,7,8,9,10 };
        myTreeNode root = myTreeNode.createMinimalBST( array, 0, array.length - 1 );
        ArrayList<LinkedList<myTreeNode>> list = BFS( root );
        //System.out.print( Arrays.toString(list.get(0).toArray()) );
        for( LinkedList<myTreeNode> temp_ll : list ){
            for( myTreeNode temp : temp_ll ){
                System.out.printf( "%d ", temp.data );
            }
            System.out.printf( "\n" );
        }
    }

    public static ArrayList<LinkedList<myTreeNode>> BFS( myTreeNode root ){
        //build a return list of linkedlist
        ArrayList<LinkedList<myTreeNode>> ret = new ArrayList<>();
        LinkedList<myTreeNode> current = new LinkedList<myTreeNode>();
        current.add( root );
        while( current.size() > 0 ){
            LinkedList<myTreeNode> temp = current;
            ret.add( temp );
            current = new LinkedList<myTreeNode>();
            for( myTreeNode parent : temp ){
                if( parent.left_child != null ){
                    current.add( parent.left_child );
                }
                if( parent.right_child != null ){
                    current.add( parent.right_child );
                }
            }
        }
        //build two linkedlists as queue
        //add root to one of the queue
        //for each element in the queue
            //add its children to another queue
            //when done, store the queue to the return
        return ret;
    }
}