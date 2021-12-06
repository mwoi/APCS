/***
discordDucks (Gabriel Thompson + Iggy, Kartik Vanjani + Krrish, Marcus Wu + Nat)
APCS pd8
HW42 -- Be More Rational
2021-12-05
time spent: 0.6hrs
***/

/***

DISCO:
 - gcd() doesn't take in two inputs as we previously thought, rather, it uses the numerator and
   denominator of the class instance
 - You can subtract by just negating the parameter instance, and running add() with it
 - You can write if statements without {} brackets, and also not use brackets for following else if
   and else statements
 - We didn't need to make 30 separate variables for the test cases, as we could've reassigned the
   values of them, but we only realized this at the end and didn't want to change all of them

QCC:
 - Is there anyone to write add() without temporarily storing the other denominator? It's not that
   bad but it makes it a bit less concise
 - Our code doesn't fully work with negative numerators or denominators, because we can't run GCD
   on them. We're not sure how to fix this
 - We're not totally sure that we did the right thing in returning either 1, 0, or -1 for compareTo().
   The instructions just said to return "a positive integer" or "a negative integer" or 0, but I
   this feels sort of vague somehow

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

	public void add( Rational r ) {
		int tempDenominator = this.denominator;
		this.numerator = this.numerator * r.denominator;
		this.denominator = this.denominator * r.denominator;
		r.denominator = r.denominator * tempDenominator;
		r.numerator = r.numerator * tempDenominator;

		this.numerator = this.numerator + r.numerator;
	}

	public void subtract( Rational r ) {
		// multiply other by -1, then add
		r.multiply( new Rational(-1, 1) );
		add(r);
	}

	public int gcd(){
                int i = 1;
                int answer = 0;
                while (i <= this.numerator){
                        if (this.numerator % i == 0 && this.denominator % i == 0)   {answer = i;}
                        i++;
                }
                return answer;
        }

	public void reduce() {
		int divisor = gcd();
		this.numerator = this.numerator / divisor;
		this.denominator = this.denominator / divisor;
	}

	public int compareTo( Rational r ) {
		if (this.floatValue() > r.floatValue())
			return 1;
		else if (this.floatValue() < r.floatValue())
			return -1;
		return 0;
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

		System.out.println("\nadd() test cases:");
		Rational o = new Rational(1, 2);
		Rational p = new Rational(3, 4);
		o.add(p);
		System.out.println(o + " ...should be equivalent to \"5 / 4\"");
		Rational q = new Rational(5, 7);
		Rational r = new Rational(1, 2);
		q.add(r);
		System.out.println(q + " ...should be equivalent to \"17 / 14\"");

                System.out.println("\nsubtract() test cases:");
                Rational s = new Rational(1, 2);
                Rational t = new Rational(3, 4);
                s.subtract(t);
                System.out.println(s + " ...should be equivalent to \"-1 / 4\"");
                Rational u = new Rational(5, 7);
                Rational v = new Rational(1, 2);
                u.subtract(v);
                System.out.println(u + " ...should be equivalent to \"3 / 14\"");

		System.out.println("\ngcd() test cases:");
		Rational w = new Rational(8, 4);
		System.out.println(w.gcd() + " ...should be \"4\"");
                Rational x = new Rational(7, 3);
                System.out.println(x.gcd() + " ...should be \"1\"");

		System.out.println("\nreduce() test cases:");
		w.reduce();
                System.out.println(w + " ...should be \"2 / 1\"");
		x.reduce();
                System.out.println(x + " ...should be \"7 / 3\"");

		System.out.println("\ncompareTo() test cases:");
		Rational y = new Rational(51, 17);
		Rational z = new Rational(48, 16);
		System.out.println(y.compareTo(z) + " ...should be \"0\"");
		Rational aa = new Rational(6, 3);
		Rational ab = new Rational(23, 12);
		System.out.println(aa.compareTo(ab) + " ...should be \"1\"");
		Rational ac = new Rational(4, 3);
		Rational ad = new Rational(3, 2);
		System.out.println(ac.compareTo(ad) + " ...should be \"-1\"");
	}
}
