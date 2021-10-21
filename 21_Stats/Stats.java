/*
 * Frog Hats - Neil Lin, Kevin Cheng, Marcus Wu
 * APCS
 * HW21 -- STAtisTically Speaking
 * 2021-10-20
 *
 * DISCO:
 * The Math functions in java
 * Doing things that normally require decimals using int is nearly impossible without type casting.
 * 
 * QCC:
 * How do we take the square root of a number without the math functions? I tried using Newton's Method to loop a number closer and closer to the true square root of the input, but it doesn't work for int because the approximation can't start approaching the true square root in Newton's Method. 
 */

public class Stats {

	public static int mean(int a, int b) {
		return (a + b)/2;
	}

	public static double mean(double a, double b) {
		return (a + b)/2;
	}

	public static int max(int a, int b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}

	public static double max(double a, double b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}

	public static int newtonsMethod(int y) {
		int x = 1;

		while ((x*x - y)/(2*x) != 0) {
			x = x - (x*x - y)/(2*x);
		}
		return x;
		//I don't see another method of computing the square root while also returning its value in int, without using type casting
		//The method returns 7 because (7*7 - 36)/14 = 13/14, which is equal to int 0
	}
	

	public static int geoMean(int a, int b) {
		return newtonsMethod(a*b);
	}

	public static double geoMean(double a, double b) {
		return (Math.sqrt(a*b));
	}
}