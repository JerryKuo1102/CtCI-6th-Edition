import java.util.*;

public class myStack{
    /*
    private List<Integer> stack;
    int length;
    int min = Integer.MAX_VALUE;

    public void push( int value ){
        stack.add( value );
        if( value < this.min ) this.min = value;
    }
    public int pop(){
        int ret = stack.get( stack.size()-1 );
        stack.remove( stack.size()-1 );
        checkMin();
        return ret;
    }
    public int min(){
        return this.min;
    }
    public void checkMin(){
        min = Integer.MAX_VALUE;
        for( int temp : stack ){
            if( temp<this.min ) this.min = temp;
        }
        if( stack.size()==0 ) min = 0;
    }
    public myStack(){
        stack = new ArrayList<Integer>();
    }
    */

    private LinkedList ll;
    int min = Integer.MAX_VALUE;
    public myStack(){
        ll = new LinkedList<myNode>();
    }
    public void push( int value ){
        //record the current min before node is added
        ll.addLast( new myNode( value, this.min ) );
        this.min = value<this.min ? value:this.min;
    }
    public int pop(){
        myNode temp = (myNode)ll.removeLast();
        //retrive the min before the poped element was pushed
        this.min = temp.min;
        return temp.value;
    }
    public int min(){
        return this.min;
    }

    public static void main(String[] args) {
        myStack stack = new myStack();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop());
            System.out.println("New min is " + stack.min());
        }
	}
}

class myNode{
    int value;
    int min;
    public myNode( int value, int min ){
        this.value = value;
        this.min = min;
    }
}