/***
discordDucks (Gabriel Thompson + Iggy, Kartik Vanjani + Krrish, Marcus Wu + Nat)
APCS pd8
HW49 -- Rational Standard Compliance
2021-12-22
time spent: 0.5hrs
***/

/*********************************************************************

DISCO:
 - In order to write a method that takes in a Object, but only wants a Rational, you
   need to check if it's a Rational before preceeding, and typecast it when using it.
      i. More concisely, "typecast your input"
 - If one of your test cases involves an error being printed out, that must come last
   because otherwise, it will prevent the rest of the tests cases from running.
 - The "float" primitive does not have a built-in compareTo() method.

QCC:
 - It doesn't seem like our "throw" statement is working, given that it's not throwing
   the error message that we wrote in.
 - What is the point of using the Comparable interface? We tried removing the
   "implements Comparable", and the program still worked and the "throw" statement
   actually functioned. Why implement Comparable?
     i. The assignment never explicitly says to implement Comparable, it just says to
        "bring [the class] into compliance with the Comparable interface". Does this
        mean we actually need to implement it or not (QAF post to come)
 - Why is equals() not part of the Comparable interface? It seems like it logically
   should be, and it's also mentioned in ap251/library/resources/api_equals.pdf.
     i. equals() is not listed as a part of the Comparable interface on the Java API:
        https://www2.cs.duke.edu/csed/ap/subset/doc/ap/java/lang/Comparable.html

*********************************************************************/

public class Rational implements Comparable {
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

	public float floatValue() {
		return (float) numerator / denominator;
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

	// HW49 additions from now until main()
	public int compareTo(Object r) {
		if (r instanceof Comparable) {
			float thisVal = this.floatValue();
			float otroVal = ((Rational) r).floatValue();

			if (thisVal == otroVal) { return 0; }
			if (thisVal >  otroVal) { return 1; }
			return -1;
		} else {
			throw new ClassCastException("\nLol enter a Rational u noob");
		}
	}

	public boolean equals(Object r) {
		if (r instanceof Comparable) {
			float thisVal = this.floatValue();
			float otroVal = ((Rational) r).floatValue();

			return thisVal == otroVal;
		} else {
			throw new ClassCastException("\nLol enter a Rational u noob");
		}
	}
}
