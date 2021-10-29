/***
* boo crew: Lauren Lee, Marcus Wu, Oscar Brene
* APCS
* HW27 -- FOR the Love of Strings
* 2021-10-29
* time spent: 18minute
***/

/**
DISCO:
- String.substring() returns a smaller string from the given string
	- the first number in the parameter is required and represents from which character the substring will start from. **note, it counts starting from 0
	- the optional second number indicates how many characters starting from the first number there will be in the substring
- String.length() returns the length of the string. Starts at 1
- in a if statement, variables are reset in every if and else statement
QCC:
- which method would reverse the string in the most efficient and fastest way, with the least steps?
**/

public class Rof {
	
	public static String fenceF( int posts ) {
		String s = "|";
		for ( int x = 1; x < posts; x++ ) {
			s += "--|";
		}
		return s;
	}
	
	public static String reverseF( String s ) {
		String result = "";
		for ( int x = s.length(); x > 0; x-- ) { 
			result += s.substring( x-1, x ); //substring(x-1,x) returns char at length-1 (substring starts at 0)
		}
		return result;
	}
	
	public static String reverseR(String s) { 
		String result = "";
		if (s.length() == 1){
			result = result + s.substring(s.length()-1); //adds the last letter to result
		} else {
			result = s.substring(s.length()-1) + reverseR(s.substring(0,s.length()-1));// adds last letter of current string and invokes the recursion of the string with one less character
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println( fenceF(1) ); //expect "|"
		System.out.println( fenceF(2) ); //expect "|--|"
		System.out.println( fenceF(3) ); //expect "|--|--|"
		
		System.out.println( reverseF("stressed") ); //expect "desserts"
		System.out.println(reverseR("stressed")); //expect "dessserts"
	}
}