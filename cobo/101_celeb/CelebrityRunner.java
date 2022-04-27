/**
 * Starts the Celebrity Game application
 * @author cody.henrichsen
 *
 */
import java.util.Scanner;
import java.util.Scanner.*;

public class CelebrityRunner
{
	/**
	 * The entry point of the Java application.
	 * @param args Unused parameter as it is a GUI based program.
	 */
	public static void main(String [] args)
	{
		// Scanner e = new Scanner(System.in);
		CelebrityGame game = new CelebrityGame();
		// game.addCelebrity("Hii", "deez", "pikachu");
		// game.addCelebrity("elll", "asdfasdf", "pikachu");
		// System.out.println(game.getCelebrityGameSize());
		// while (game.getCelebrityGameSize() != 0) {
		// 	System.out.println(game.sendClue());
		// 	while (!game.processGuess(e.nextLine())) {
		// 		System.out.println("try again");
		// 	}
		// 	System.out.println(game.sendAnswer() + "CORRECT");
		// }
		CelebrityFrame e = new CelebrityFrame(game);
		
	}
}
