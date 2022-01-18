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

public class Driver {

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

		// ADDITIONS FROM HW49
		System.out.println("\ncompareTo() test cases:");
		Rational o = new Rational(5, 6);
		Rational p = new Rational(4, 3);
		System.out.println(o.compareTo(p) + " ...should be -1");
		o = new Rational(4, 3);
		System.out.println(o.compareTo(p) + " ...should be 0");
		o = new Rational(15, 7);
		System.out.println(o.compareTo(p) + " ...should be 1");

		System.out.println("\nequals() test cases:");
		o = new Rational(8, 6);
		System.out.println(o.equals(p) + " ...should be true");
		o = new Rational(8, 7);
		System.out.println(o.equals(p) + " ...should be false");

		System.out.println("\nFinal compareTo() test case:\nTHE FOLLOWING SHOULD BE AN ERROR:\n");
		System.out.println(o.compareTo("lol"));
	}

}
