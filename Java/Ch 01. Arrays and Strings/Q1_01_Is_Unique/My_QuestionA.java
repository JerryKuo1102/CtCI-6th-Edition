import java.util.*; 

public class My_QuestionA{
	//static main calls static method
	public static boolean isUniqueChars( String word ){
		/*
		1. Can use hash set to see of there are duplicated entries
		HashSet can be used to implement Set which contains no duplicated entries
		2. If no other data structure can be used, we need to maintain a list
		*/
		boolean ret = true;
		int str_len = word.length();
		//should use wrapper type
		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<str_len; i++){
			ret &= set.add( word.charAt(i) );
		}
		return ret;
	}
	public static boolean isUniqueChars_two( String word ){
		int str_len = word.length();
		//maintain a list of appeared character
		boolean[] a = new boolean[128];
		for( boolean i : a ) i = false;
		//System.out.print( (int)' ' );
		for( int i=0; i<str_len; i++ ){
			if( a[word.charAt(i) - ' '] == false ){
				a[word.charAt(i) - ' '] = true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for( String i : words ){
			System.out.println(i + ": " + isUniqueChars_two(i));
		}
	}
}