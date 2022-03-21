/**
Team Explorers: Eric He + bob, Marcus Wu + nat, Russell Goychayev + bob
APCS
L07: But These Go Up To Eleven
2022-03-18
Time Spent: 1.0 hours
*/

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"A", "B", "C"};
		String[] suits = {"Giraffes", "Lions"};
		int[] values = {2, 1, 6};

		Deck deck = new Deck(ranks, suits, values);
		System.out.println( deck );
		deck.deal();
		System.out.println( deck );

	}
}
