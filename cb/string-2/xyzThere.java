/***

Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.


xyzThere("abcxyz")  true
xyzThere("abc.xyz")  false
xyzThere("xyz.abc")  true

***/

public class xyzThere {
	public static boolean xyzThere(String str) {
		for ( int x = 0; x < ( str.length() - 2 ); x++ ) {
			//if there is xyz in str
			if ( str.substring( x, x + 3 ).equals("xyz") ) {
				//if it starts with xyz
				if ( str.substring( x, x + 3 ).equals( str.substring( 0, 3 ) ) ) {
					return true;
				}
				//if it has xyz without . before it
				else if ( !( str.substring( x - 1, x ).equals(".") ) ) {
					return true;
				}
			}
		}
		//not have xyz without .
		return false;
	}
	
	public static void main(String[] args){
		System.out.println( xyzThere("abcxyz") );
		System.out.println( xyzThere("abc.xyz") );
		System.out.println( xyzThere("xyz.abc") );
	}
}