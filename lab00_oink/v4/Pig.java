/*
Code-X: Marcus Wu, Jonathon Song, Oscar Breen
APCS
Lab00 -- Pig.java version 4 improvements
2021-11-10
time spent -- 3 hrs
DISCO
if y is surrounded by non vowels then it is a vowel
-1 measn that there was no found character in IndexOf

QCC: How to deal with numbers? treat them like punctuation?

HOW WE UTILIZED SCANNER DEMO 
a .txt cna now run through this and  have each word trasnalted to pig latin

New in V4
the Import java.util.Scanner;

*/
import java.util.Scanner;
public class Pig
{
	//Q: How does this initialization make your life easier?
	private static final String VOWELS = "aeiouy";
	private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String PUNCS = ".,:;!?";

	/*=====================================
	boolean hasA(String,String) -- checks for a letter in a String
	pre:  w != null, letter.length() == 1
	post: hasA("cat", "a") -> true
	hasA("cat", "p")       -> false
	=====================================*/
	public static boolean hasA( String w, String letter ) {
	/* YOUR IMPLEMENTATION HERE */
		if( letter.length() != 1 ) {
			System.out.println("Letter must have length 1.");
			return false;
		}
		if( w.length() < 1 ) {
			System.out.println("String w length cannot be less than 1.");
			return false;
		}
		if ( w.indexOf( letter ) != -1 ) {
			return true;
		}
		else {
			return false;
		}
	}//end hasA()


	/*=====================================
	boolean isAVowel(String) -- tells whether a letter is a vowel
	precondition: letter.length() == 1
	=====================================*/
	public static boolean isAVowel( String letter ) {
	/* YOUR IMPLEMENTATION HERE */
		if ( letter.length() != 1 ) {
			System.out.println("Letter must have length 1.");
			return false;
		}     
		return hasA( VOWELS, letter );
	}


	/*=====================================
	int countVowels(String) -- counts vowels in a String
	pre:  w != null
	post: countVowels("meatball") -> 3
	=====================================*/
	public static int countVowels( String w ) {
		if( w.length() < 1 ) {
			System.out.println("String w length cannot be less than 1.");
			return -1;
		}
		int counter = 0;
		for ( int index = 0; index < w.length(); index++ ) {
			String letter = w.substring( index, index+1 );
			if ( isAVowel( letter ) ) {
				counter++;
			}
		}
		return counter;
	}


	/*=====================================
	boolean hasAVowel(String) -- tells whether a String has a vowel
	pre:  w != null
	post: hasAVowel("cat") -> true
	hasAVowel("zzz")       -> false
	=====================================*/
	public static boolean hasAVowel( String w ) {
		if( w.length() < 1 ) {
			System.out.println("String w length cannot be less than 1.");
			return false;
		}
		for ( int index = 0; index < w.length(); index++ ) {
			String letter = w.substring( index, index+1 );
			if ( isAVowel( letter ) ) {
				return true; 
			}
		}
		return false;
	}


	/*=====================================
	String allVowels(String) -- returns vowels in a String
	pre:  w != null
	post: allVowels("meatball") -> "eaa"
	=====================================*/
	public static String allVowels( String w ) {
		if( w.length() < 1 ) {
			System.out.println("String w length cannot be less than 1.");
			return "";
		}
		String output = "";
		for ( int index = 0; index < w.length(); index++ ) {
			String letter = w.substring( index, index+1 );
			if ( isAVowel( letter ) ) {
				output += letter;
			}
		}
		return output; 
	}
	
	/*=====================================
	String firstVowel(String) -- returns first vowel in a String
	pre:  w != null
	post: firstVowel("") --> ""
	firstVowel("zzz") --> ""
	firstVowel("meatball") --> "e"
	=====================================*/
	public static String firstVowel( String w ) {
		String ans = "";
		if ( hasAVowel(w) ) { //Q: Why this necess?
			ans = allVowels(w).substring(0,1);
		}
		return ans;
	}


	/*=====================================
	boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
	pre:  w != null and w.length() > 0
	post: beginsWithVowel("apple")  --> true
	beginsWithVowel("strong") --> false
	=====================================*/
	public static boolean beginsWithVowel( String w ) {
		if( w.length() <= 0 ) {
			System.out.println("String w length must be greater than 0. Returning false");
			return false;
		}
		return isAVowel( w.substring(0,1) );
	}


	/*=====================================
	String engToPig(String) -- converts an English word to Pig Latin
	pre:  w.length() > 0
	post: engToPig("apple")  --> "appleway"
	engToPig("strong") --> "ongstray"
	engToPig("java")   --> "avajay"
	=====================================*/
	public static String engToPig( String w ) {
		String ans = "";
		if ( beginsWithVowel(w) ) {
			ans = w + "way";
		}
		else {
			int vPos = w.indexOf( firstVowel(w) );
			ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
		}
		return ans;
	}

	/*=====================================
	boolean isPunc(String) -- tells whether a character is punctuation
	pre:  symbol.length() == 1
	post: isPunc(".") -> true
		  isPunc("b") -> false
	=====================================*/
	public static boolean isPunc( String symbol ) {
		if ( symbol.length() != 1 ){
			System.out.println("isPunc expects 1 character, returning false");
			return false;
		}
		return PUNCS.indexOf( symbol ) != -1;
	}


	/*=====================================
	boolean isUpperCase(String) -- tells whether a letter is uppercase
	pre:  letter.length() == 1
	post: isUpperCase("a") -> false
		  isUpperCase("A") -> true
	=====================================*/
	public static boolean isUpperCase( String letter ) {
		if ( letter.length() != 1 ) {
			System.out.println("isUpperCase expects 1 character, returning false");
			return false;
		}
		else {
			return CAPS.indexOf( letter ) != -1;
		}
	}


	/*=====================================
	boolean hasPunc(String) -- tells whether a String contains punctuation
	pre:  w != null
	post: hasPunc(cat.) -> true
		  hasPunc(cat) -> false
	=====================================*/
	public static boolean hasPunc( String w ) {
		if( w.length() < 1 ) {
			System.out.println("String w length cannot be less than 1.  Returning false");
			return false;
		}
		for ( int index = 0; index < w.length(); index++ ) {
			if ( isPunc( w.substring( index, index+1 ) ) ) {
				return true;
			}
		}
		return false;
	}
	

	/*=====================================
	boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
	pre:  w != null and w.length() > 0
	post: beginsWithUpper("Apple") -> true
		  beginsWithUpper("apple") -> false
	=====================================*/
	public static boolean beginsWithUpper( String w ) {
		if( w.length() <= 0 ) {
			System.out.println("String w length must be greater than 0. Returning false");
			return false;
		}
		return isUpperCase( w.substring( 0, 1 ) );
	}

public static String scannerThing(String w) {
 int spaces = w.indexOf(" ");
	if (spaces == -1) {
return engToPig(w);

}

    else {
	return scannerThing(w.substring ( 0, spaces)) + " " + scannerThing(w.substring (spaces+1));
}
}	
	
	public static void main(String[] args){
	Scanner pigscan = new Scanner (System.in);	
	for( String word : args ) {
			System.out.println( "allVowels \t" + allVowels(word) );
			System.out.println( "firstVowels \t" + firstVowel(word) );
			System.out.println( "countVowels \t" + countVowels(word) );
			System.out.println( "engToPig \t" + engToPig(word) );
			System.out.println( "---------------------" );
		while ( pigscan.hasNext() ) {
		System.out.println ( scannerThing(pigscan.next()) );
		}
	}

}
}