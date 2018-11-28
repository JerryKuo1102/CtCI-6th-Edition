import java.util.*;
//import MyMultiStack.*;

public class My_QuestionA{
    public static void main( String[] args ){
        MyMultiStack myStack = new MyMultiStack();
        myStack.get_stack_info();
        myStack.push( 1, 10 );
        myStack.push( 1, 20 );
        myStack.push( 1, 30 );
        myStack.push( 1, 40 );
        myStack.get_stack_info();
        myStack.pop( 1 );
        myStack.pop( 1 );
        myStack.pop( 1 );
        myStack.pop( 1 );
        myStack.get_stack_info();
    }
}