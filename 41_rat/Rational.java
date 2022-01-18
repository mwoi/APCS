/***
discordDucks (Gabriel Thompson + Iggy, Kartik Vanjani + Krrish, Marcus Wu + Nat)
APCS pd8
HW41 -- Be Rational
2021-12-01
time spent: 0.5hrs
***/

/***

DISCO:
 - "double" is a more accurate way of storing floating-point values, and therefore is our returntype of
   choice for the function floatValue()
 - You need to check if the resulting denominator will be zero for both multiply() and divide(), to
   make sure that each method doesn't set the ratio the class stores to an invalid fraction

QCC:
 - Is there a better way to handle making sure that you don't divide by 0? It makes the code more ugly
   because the entire function has to be within an if/else statement
 - What is the harm of making instance variables (particularily the ones in this case) public, what is
   the advantage of keeping them private?
 - It seems inefficient to create so many instances of "Rational" for the test cases -- is there a
   cleaner or more efficient way of doing that?
 - Does Java have a built in ratio object similar to this one?

***/

public class Rational {
	private int numerator;
	private int denominator;

	public Rational() {
		numerator = 0;
		denominator = 1;
	}

	public Rational(int num, int denom) {
		if (denom == 0) {
			numerator = 0;
			denominator = 1;
			System.out.println("ERROR: Denominator cannot be 0");
		} else {
			numerator = num;
			denominator = denom;
		}
	}

	public String toString() {
		return numerator + " / " + denominator;
	}

	public double floatValue() {
		return (double) numerator / denominator;
	}

	public void multiply(Rational r) {
		if (r.denominator == 0)
			System.out.println("ERROR: Cannot divide by 0");
		else {
			numerator *= r.numerator;
			denominator *= r.denominator;
		}
	}

	public void divide(Rational r) {
		if (r.numerator == 0)
                        System.out.println("ERROR: Cannot divide by 0");
                else {
			numerator *= r.denominator;
			denominator *= r.numerator;
		}
	}

	public static void main(String[] args) {
		System.out.println("\ntoString() and constructor test cases:");
		Rational a = new Rational();
		System.out.println(a + " ...should be \"0 / 1\"");
		Rational b = new Rational(5, 2);
		System.out.println(b + " ...should be \"5 / 2\"");
		Rational c = new Rational(1, 0);
		System.out.println(c + " ...should yield error");

		System.out.println("\nfloatValue() test cases:");
		Rational d = new Rational(6, 3);
		System.out.println(d.floatValue() + " ...should be \"2.0\"");
		Rational e = new Rational(5, 3);
		System.out.println(e.floatValue() + " ...should be \"1.66666667\"");
		Rational f = new Rational(-18, 9);
		System.out.println(f.floatValue() + " ...should be \"-2.0\"");

		System.out.println("\nmultiply() test cases:");
		Rational g = new Rational(5, 4);
		Rational h = new Rational(6, 10);
		g.multiply(h);
		System.out.println(g + " ...should be \"30 / 40\"");
		Rational i = new Rational(5, 10);
		Rational j = new Rational();
		i.multiply(j);
		System.out.println(i + " ...should be \"0 / 10\"");

		System.out.println("\ndivide() test cases:");
		Rational k = new Rational(10, 3);
		Rational l = new Rational(6, 4);
		k.divide(l);
		System.out.println(k + " ...should be \"40 / 18\"");
		Rational m = new Rational(5, 5);
		Rational n = new Rational();
		m.divide(n);
		System.out.println(m + " ...should yield an error\n");
	}
}