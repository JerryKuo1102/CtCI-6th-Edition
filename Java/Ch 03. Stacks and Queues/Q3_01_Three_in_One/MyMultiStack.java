import java.util.*;
/* Fix length version */
public class MyMultiStack{
    private int num_of_stacks;
    private int array_size;
    private int[] my_array;
    private int stack1_max;
    private int stack2_max;
    private int stack3_max;
    private int stack1_ptr;
    private int stack2_ptr;
    private int stack3_ptr;

    //constructor of (number of stack, size)
    public MyMultiStack(){
        this( 3, 12 );
    }
    public MyMultiStack( int num_stacks, int size ){
        if( size%num_stacks != 0 ){
            //throw new myFullStackException();
        }
        num_of_stacks = num_stacks;
        array_size = size;
        stack1_max = ( size / 3 ) - 1;
        stack2_max = 2 * ( size / 3 ) - 1;
        stack3_max = size - 1;
        stack1_ptr = 0;
        stack2_ptr = 0;
        stack3_ptr = 0;
        my_array = new int[ array_size ];
    }
    public void get_stack_info(){
        System.out.printf( "stack max : %d %d %d\n", stack1_max, stack2_max, stack3_max );
        System.out.printf( "stack ptr : %d %d %d\n", stack1_ptr, stack2_ptr, stack3_ptr );
    }
    
    public void push( int stack_num, int input ){
        //sanity check
        if( stack_num > num_of_stacks || stack_num <= 0 ){
            //throw new myFullStackException();
            System.out.println( "Failed sanity\n" );
        }
        System.out.printf( "Push %d->#%d\n", input, stack_num );
        //check if full
        switch( stack_num ){
            case 1:
                if( stack1_ptr == stack1_max ){
                    System.out.println( "Stack is FULL\n" );
                    break;
                }
                my_array[ stack1_ptr++ ] = input;
                break;
            case 2:
                if( stack2_ptr == stack2_max ){
                    System.out.println( "Stack is FULL\n" );
                    break;
                }
                my_array[ stack2_ptr++ ] = input;
                break;
            case 3:
                if( stack3_ptr == stack3_max ){
                    System.out.println( "Stack is FULL\n" );
                    break;
                }
                my_array[ stack3_ptr++ ] = input;
                break;
        }
    }

    public int pop( int stack_num ){
        //sanity check
        if( stack_num > num_of_stacks || stack_num <= 0 ){
            System.out.println( "Failed sanity\n" );
            return 0;
        }
        switch( stack_num ){
            case 1:
                if( stack1_ptr == 0 ){
                    System.out.println( "Stack is EMPTY\n" );
                    break;
                }
                System.out.printf( "Pop #%d->%d\n", stack_num, my_array[stack1_ptr-1] );
                return my_array[ stack1_ptr-- ];
            case 2:
                if( stack2_ptr == stack1_max + 1 ){
                    System.out.println( "Stack is EMPTY\n" );
                    break;
                }
                System.out.printf( "Pop #%d->%d\n", stack_num, my_array[stack2_ptr-1] );
                return my_array[ stack2_ptr-- ];
            case 3:
                if( stack3_ptr == stack2_max + 1 ){
                    System.out.println( "Stack is EMPTY\n" );
                    break;
                }
                System.out.printf( "Pop #%d->%d\n", stack_num, my_array[stack3_ptr-1] );
                return my_array[ stack3_ptr-- ];
        }
        return 0; /* Shouldnt get here */
    }
    /*
    public int peek( int stack_num ){
    }
    */
}