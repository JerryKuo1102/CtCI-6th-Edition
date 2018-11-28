import java.util.*;

public class myQuestionA{
    public static boolean checkPermu( String a, String b ){
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        Arrays.sort( aa );
        Arrays.sort( bb );
        String aaa = new String( aa );
        String bbb = new String( bb );
        return aaa.equals(bbb);
    }

    public static void main( String[] args ){
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        int cnt = 0;
        for( String[] pair : pairs ){
            System.out.println( "Pair " + cnt + " : " + checkPermu( pair[0], pair[1] ) );
            cnt++;
        }
    }
}