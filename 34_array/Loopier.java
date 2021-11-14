/*
Team discordDucks (Kartik Vanjani, Gabriel Thompson, Marcus Wu)
APCS
HW34 -- A Pirate’s Life for Me
2021-11-14
time spent: 0.6hrs

DISCO:
 - You can search through an array breaking it down into the first index and the rest
 - When arrays are printed out, they don't have a comma after the last item which is annoying

QCC:
 - Does a slicing function for arrays exist in the Java Library? If so, what is it?
 - Is there a way to do our linear search recursive function without it being such a mess?

*/

public class Loopier {
	// 1. A static method to populate an existing array with randomly generated ints.
	public static int[] generate( int[] array ) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 10);
		}
		return array;
	}
	
	// 2. A static method to return a String version of an array of ints.
	public static String stringify( int[] array ) {
		String out = "{";
		for (int i = 0; i < array.length; i++) {
			out += array[i];
			if (i < array.length - 1) {
				out += ", ";
			}
		}
		out += "}";
		return out;
	}
	
	// 3a. Iterative linear search
	public static int linSearch( int[] a, int target ) {
		for (int index = 0; index < a.length; index++) {
			if (index == target) {
				return index;
			}
		}
		return -1;
	}
	
	// 3b. Recursive linear search
	// main function, which calls helper function
	public static int linSearchR( int[] a, int target ) {
		return linSearchRHelper(a, target, 0);
	}
	
	// helper function which does most of the work
	public static int linSearchRHelper( int[] a, int target, int index ) {
		if (a.length == 1) { // if the array is length 1, just check if the first index is the target
			if (a[0] == target) {
				return index;
			} else {
				return -1;
			}
		}
		else {              // otherwise, divie the problem up into the first index and the rest
			if (a[0] == target) {
				return index;
			} else {
				return linSearchRHelper(slice(a, 1), target, index+1);
			}
		}
	}
	
	// basic slicing function that just slices from the starting index
	public static int[] slice( int[] array, int start ) {
		int[] output = new int[array.length - 1];
		for (int i = start; i < array.length; i++) {
			output[i - start] = array[i];
		}
		return output;
	}
	
	// overloaded slicing function that also takes in an end index
	public static int[] slice( int[] array, int start, int end ) {
                int[] output = new int[end - start];
                for (int i = start; i < end; i++) {
                        output[i - start] = array[i];
                }
                return output;
        }
	
	// 4a. Iterative frequency counter
	public static int freq( int[] a, int target ) {
		int counter = 0;
		for (int item : a) {
			if (item == target) {
				counter++;
			}
		}
		return counter;
	}
	
	// 4b. Recursive frequency counter
	public static int freqRec( int[] a, int target ) {
		if (a.length == 1) {
			if (a[0] == target) {
				return 1;
			}
			return 0;
		}
		return freqRec(slice(a, 0, 1), target) + freqRec(slice(a, 1), target);
	}
	
	// Driver, to run basic test cases
	public static void main(String[] args) {
		int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		a = generate(a);
		System.out.println(stringify(a) + " ... should be a random array of length 10");
		int[] b = {3, 8, 4, 2, 7, 3, 4, 9, 3, 11, 4, 6, 3, 13};
		System.out.println(linSearchR(b, 9) + " ... should be 7");
		System.out.println(freqRec(b, 3) + " ... should be 4");
	}
}
