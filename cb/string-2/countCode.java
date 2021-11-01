/***

Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.


countCode("aaacodebbb")  1
countCode("codexxcode")  2
countCode("cozexxcope")  2

***/

public class countCode {
	public static int countCode(String str) {
		int code = 0;
		for ( int x = 0; x < ( str.length() - 3 ); x++ ) {
			if ( str.substring( x, x+2 ).equals("co") && str.substring( x+3, x+4 ).equals("e") ) {
				code += 1;
			}
		}
		return code;
	}
	
	public static void main(String[] args){
		System.out.println( countCode("aaacodebbb") );
		System.out.println( countCode("codexxcode") );
		System.out.println( countCode("cozexxcope") );
	}
}