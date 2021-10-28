/* 
 * Frog Hats - Kevin Cheng, Marcus Wu, Neil Lin
 * APCS
 * HW26 -- GCD Three Ways
 * 2021-10-27
 * Time Spent: 0.6 hours
 *
 * DICSO:
 * Using final to try to make a variable a constant doesn't work for recursion
 * What a final variable is
 * If the java compiler doesn't detect return statements with scope in the entire method, then it's an error.
 *
 * QCC:
 * none
 */

public class Stats {
	public static int gcd(int a, int b) {
		int check = b;
		while (a % check != 0 || b % check != 0) {
			check--;
		}
		return check;
	}

	public static int gcdER(int a, int b) {
		if (a > b) {
			return gcdER(a - b, b);
		} else if (a < b) {
			return gcdER(a, b - a);
		} else {
			return a;
		}
	}

	public static int gcdEW(int a, int b) {
		while (a != b) {
			if (a > b) {				
				a -= b;
			} else {
				b -= a;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(gcd(2363, 2567) + "\n" + gcdER(2363,2567) + "\n" + gcdEW(2363,2567));
		System.out.println("All should return 17");
	}
}