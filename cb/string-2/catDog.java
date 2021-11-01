/***

Return true if the string "cat" and "dog" appear the same number of times in the given string.


catDog("catdog")  true
catDog("catcat")  false
catDog("1cat1cadodog")  true

***/

public class catDog {
	public static boolean catDog(String str) {
		int numCat = 0;
		int numDog = 0;
		for ( int x = 0; x < ( str.length() - 2 ); x++ ) {
			if ( str.substring( x, x + 3 ).equals("cat") ) {
			numCat++;
			}
			else if ( str.substring( x, x + 3 ).equals("dog") ) {
			numDog++;
			}
		}
		if ( numCat == numDog ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args){
		System.out.println( catDog("catdog") );
		System.out.println( catDog("catcat") );
		System.out.println( catDog("lcatlcadodog") );
	}
}