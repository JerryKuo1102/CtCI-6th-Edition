import java.util.*;

public class myQuestion{
    public static int BitInsertion( int n, int m, int i, int j ){
        //sanity check
        if( i > j || j > 32 ){
            return 0;
        }
        int mask = ~0;
        //111....1110000...00
        int left = mask << (j+1);
        //000..00011..11
        int right = (1 << i) - 1;
        mask = left|right;
        
        int n_shift = n&mask;
        int m_shift = m<<i;
        return n_shift|m_shift;
    }
    public static void main( String[] args ){
        int res = BitInsertion( 1024/*10000000000b*/, 19/*10011b*/, 2, 6 ); //expect 1100
        System.out.printf( "%d\n", res );
    }
}