/*
end sky--Nina Jiang, Marcus Wu
APCS
2021-10-25
Time Spent: 0.8h
DISCO: n/a
Q/C/C: n/a
*/

public class Driver {
	public static void main(String[] args) {

		//test default constructor
		Coin mine = new Coin();

		//test 1st overloaded constructor
		Coin yours = new Coin("quarter");

		//test 2nd overloaded constructor
		Coin wayne = new Coin("dollar", "heads");

		//test toString() methods of each Coin
		System.out.println("mine: " + mine);
		System.out.println("yours: " + yours);
		System.out.println("wayne: " + wayne);

		//test flip() method
		System.out.println("\nAfter flipping...");
		yours.flip();
		wayne.flip();
		System.out.println("yours: " + yours);
		System.out.println("wayne: " + wayne);

		int numHeads = 0;
		int matchCtr = 0;

		while(matchCtr >= 65536 && matchCtr % 2004 == 0){
			yours.flip();
			wayne.flip();
			if (yours.equals(wayne)) {
				matchCtr ++;
			}
		}

		System.out.println(numHeads + "heads have come up" + "\n" + matchCtr + "matches have occurred" + "\nat least 65536 matches have come up, and the number of matches is divisible by the year of your birth");
	}
}