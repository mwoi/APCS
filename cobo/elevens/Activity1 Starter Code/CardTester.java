/**
Team Explorers: Eric He + bob, Marcus Wu + nat, Russell Goychayev + bob
APCS
L07: But These Go Up To Eleven
2022-03-18
Time Spent: 1.0 hours
*/

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card a = new Card("4", "hearts", 10);
		Card b = new Card("2", "spades", 3);
		Card c = new Card("4", "hearts", 10);

		System.out.println(a.matches(c));
		System.out.println(a.matches(b));
		System.out.println(a.rank());
		System.out.println(a.suit());

	}
}
