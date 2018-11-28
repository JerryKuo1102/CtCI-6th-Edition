import java.util.*;

public class myQuestion2{
    public static void main( String[] args ){
        //build a binary tree
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        myTreeNode root = myTreeNode.createMinimalBST( array, 0, array.length-1 );
        ArrayList<LinkedList<myTreeNode>> list = DFS( root, 0, new ArrayList<LinkedList<myTreeNode>>() );
        for( LinkedList<myTreeNode> ll : list ){
            for( myTreeNode temp : ll ){
                System.out.printf( "%d ", temp.data );
            }
            System.out.printf( "\n" );
        }
    }

    public static ArrayList<LinkedList<myTreeNode>> DFS( myTreeNode root, int depth, ArrayList<LinkedList<myTreeNode>> ret ){
        if( ret.size() < depth+1 ){
            ret.add( new LinkedList<myTreeNode>() );
        }
        // add it to linkedlist
        ret.get( depth ).add( root );
        if( root.left_child != null ){
            DFS( root.left_child, depth+1, ret );
        }
        if( root.right_child != null ){
            DFS( root.right_child, depth+1, ret );
        }
        return ret;
    }
}