import java.util.*;

public class myQuestion {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // We needed this code for other files, so check out the code in the library
        myTreeNode root = myTreeNode.createMinimalBST( array, 0, array.length - 1 );
        System.out.println("Root\t\t: " + root.data);
        System.out.println("Created BST\t: " + root.isBST());
        System.out.println("Height\t\t: " + root.height(root, 1));
    }
}