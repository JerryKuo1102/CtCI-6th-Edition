import java.util.*;

public class myTreeNode{
    myTreeNode left_child;
    myTreeNode right_child;
    int data;
    int max_height = 0;

    //constructor
    public myTreeNode( myTreeNode left_child, myTreeNode right_child, int data ){
        this.left_child = left_child;
        this.right_child = right_child;
        this.data = data;
    }

    public myTreeNode(){
        this( null, null, Integer.MAX_VALUE );
    }

    //isBST
    public boolean isBST(){
        boolean ret = true;
        if( left_child != null ){
            //System.out.printf( "data %d left %d\n", data, left_child.data );
            ret &= left_child.data < data;
            ret &= left_child.isBST();
        }
        if( right_child != null ){
            //System.out.printf( "data %d right %d\n", data, right_child.data );
            ret &= right_child.data > data;
            ret &= right_child.isBST();
        }

        return ret;
    }
    //height
    public int height( myTreeNode root, int tmp_height ){
        // we can go transversal and record the max height
        max_height = tmp_height>max_height ? tmp_height:max_height;
        if( root.left_child != null ){
            tmp_height++;
            height( root.left_child, tmp_height );
            tmp_height--;
        }
        if( root.right_child != null ){
            tmp_height++;
            height( root.right_child, tmp_height );
            tmp_height--;
        }

        return max_height;
    }
    public static myTreeNode createMinimalBST( int[] array, int start, int end ){
        int idx;
        myTreeNode left, right;
        if( end == start ){
            return new myTreeNode( null, null, array[start] );
        }
        // System.out.printf( "%d %d\n", start, end );
        // if the subtree is not complete, choose the left child
        if( end-start == 1 ){
            idx = end;
            left = createMinimalBST( array, start, start );
            right = null;
        }
        else{
            idx = (end+start)/2;
            left = createMinimalBST( array, start, idx-1 );
            right = createMinimalBST( array, idx+1, end );
        }
        myTreeNode ret = new myTreeNode( left, right, array[ idx ] );
        return ret;
    }
}