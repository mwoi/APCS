/***

Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.


endOther("Hiabc", "abc")  true
endOther("AbC", "HiaBc")  true
endOther("abc", "abXabc")  true

***/

public class endOther {
	public static boolean endOther(String a, String b) {
		int endString = Math.max( a.length(), b.length() ) - Math.min( a.length(), b.length() );
		if ( a.length() > b.length() ) {
			if ( ( a.toLowerCase() ).substring( endString ).equals( b.toLowerCase() ) ) {
				return true;
			}
			else {
				return false;
			}
		}
		else if ( b.length() > a.length() ) {
			if ( ( b.toLowerCase() ).substring( endString ).equals( a.toLowerCase() ) ) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if ( ( a.toLowerCase() ).equals( b.toLowerCase() ) ) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	public static void main(String[] args){
		System.out.println( endOther("Hiabc", "abc") );
		System.out.println( endOther("AbC", "HiaBc") );
		System.out.println( endOther("abc", "abXabc") );
	}
}