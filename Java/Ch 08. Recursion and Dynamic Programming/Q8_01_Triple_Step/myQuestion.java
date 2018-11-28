public class myQuestion{
    /* Stair definition : we stand at stair 1 in the first place, variable stairs are total stairs */
    public static int dynamic( int stairs ){
        if( stairs <= 0 )
            return 0;
        //this problem involved only 1D table
        //we can use either recursive or dynamic programming

        int[] table = new int[stairs];
        table[ 0 ] = 0;//1->1
        table[ 1 ] = 1;//1->2
        table[ 2 ] = 2;//1->3
        table[ 3 ] = 4;//1->4
        for( int i = 4; i < stairs; i++ ){
            /* 1steps to goal + 2steps to goal + 3steps to goal */
            table[ i ] = table[ i - 1 ] + table[ i - 2 ] + table[ i- 3 ];
        }
        return table[ stairs - 1 ];
    }

    public static int recursive( int stairs ){
        if( stairs <= 1 ){
            return 0;
        }
        else if( stairs == 2 ){
            return 1;
        }
        else if( stairs == 3 ){
            return 2;
        }
        else if( stairs == 4 ){
            return 4;
        }
        else{
            return recursive( stairs - 1 ) + recursive( stairs - 2 ) + recursive( stairs - 3 );
        }
    }


    public static void main( String[] args ){
        System.out.printf( "Dynamic : %d, Recursive : %d\n", dynamic( 21 ), recursive( 21 ) );
        //System.out.printf( "Dynamic : %d, Recursive : %d\n", dynamic( 50 ), recursive( 50 ) );
    }
}