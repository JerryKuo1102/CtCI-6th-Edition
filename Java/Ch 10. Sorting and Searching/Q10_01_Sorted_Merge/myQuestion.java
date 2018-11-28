import java.util.*;

public class myQuestion{
    public static List<Integer> merge( List<Integer> a, List<Integer> b ){
        List<Integer> temp = new ArrayList<>();
        /* Do merge sort */
        int i = 0, j = 0;
        while( i != a.size() || j != b.size() ){
            if( i == a.size() ){ // a list end
                temp.add( b.get( j ) );
                j++;
            }
            else if( j == b.size() ){ // b list end
                temp.add( a.get( i ) );
                i++;
            }
            else{
                if( a.get( i ) > b.get( j ) ){ // find the min
                    temp.add( b.get( j ) );
                    j++;
                }
                else{
                    temp.add( a.get( i ) );
                    i++;
                }
            }
        }
        return temp;
    }

    public static void main( String[] args ){
        List<Integer> input_a = new ArrayList<Integer>();
        List<Integer> input_b = new ArrayList<Integer>();
        for( int i = 0; i < 50; i++ ){
            if( i%2 == 0 ) input_b.add(i);
            else input_a.add(i);
        }
        for( Integer a : merge( input_a, input_b ) ){
            System.out.printf( "%d ", a );
        }
    }
}