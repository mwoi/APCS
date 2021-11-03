/*
 * Frog Hats - Kevin Cheng, Marcus Wu, Neil Lin
 * APCS
 * HW29 -- Which Way Do You Roll?
 * 2-11-2021
 *
 * DISCO:
 * How to convert ints to Strings and Strings to ints
 * How to have the program respond to args from the command line
 * How do access arrays
 *
 * QCC:
 * How do I place commas recursively?
 * += adds to the back of the String. Is there any way for it to add to the front of the String?
 */
 
public class Commafier {
	public static String CommafyF(int n) {
		String commaN = "";
		String nStr = Integer.toString(n);

		for (int digit = nStr.length() - 1; digit >= 0; digit--) {
			char addon = nStr.charAt(digit);
			if ((nStr.length() - digit) % 3 == 1 && digit + 1 != nStr.length()) {
				commaN = addon + "," + commaN;
			} else {
				commaN = addon + commaN;
			}
		}
		return commaN;
	}

	/*
	public static String CommafrR(int n) {
		String commaN = "";
		String nStr = Integer.toString(n);
		int digit = 0;
		char addon = nStr.charAt(digit);

		if (nStr.length > 1) {
			if ((nStr.length() - digit) % 3 == 1 && nStr.length() != 1) {
				commaN += addon + "," + CommafrR(Integer.parseInt(nStr.substring(1)));
			} else {
				commaN += addon + CommafrR(Integer.parseInt(nStr.substring(1)));
			}
		} else {
			commaN = nStr;
		}
		return commaN;
	}
	*/
// I have no idea how to do this recursively.
// If I deleted digits from the front, it wouldn't return the zeroes in the int.
// If I deleted digits from the back, it wouldn't know when to place the commas because you would need the digit's position relative to the back to place commas. Deleting the back would change where commas are relative to the back.

	public static void main(String[] args) {
		for (int argNum = 0; argNum <= args.length - 1; argNum++) {
			System.out.println(CommafyF(Integer.parseInt(args[argNum])));
		}
	}
}