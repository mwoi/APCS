/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		String statementLower = statement.toLowerCase();

		if ( statement.toLowerCase().indexOf(" no ") >= 0 ) //NO
		{
			response = "Why so negative?";
		}
		else if ( statementLower.indexOf("mother") >= 0 //FAMILY
			|| statementLower.indexOf("father") >= 0
			|| statementLower.indexOf("sister") >= 0
			|| statementLower.indexOf("brother") >= 0
			)
		{
			response = "Tell me more about your family.";
		}
		else if ( statementLower.indexOf("dog") >= 0 //PETS
			|| statementLower.indexOf("cat") >= 0
			|| statementLower.indexOf("fish") >= 0
			|| statementLower.indexOf("bird") >= 0
			|| statementLower.indexOf("pet") >= 0
			)
		{
			response = "Tell me more about your pets.";
		}
		else if ( statementLower.indexOf("mykolyk") >= 0 ) //TEACHER
                {
                        response = "He sounds like a good teacher.";
                }
		else if ( statementLower.indexOf("alive") >= 0 //ALIVE
			&& statementLower.indexOf("you") >= 0
			)
                {
                        response = "I can see you.";
                }
		else if ( statementLower.indexOf("banana") >= 0 //FRUIT
			|| statementLower.indexOf("apple") >= 0
			|| statementLower.indexOf("grape") >= 0
			|| statementLower.indexOf("orange") >= 0
			) 
                {
                        response = "Fruit are great, I like mangos.";
                }
		else if ( statementLower.indexOf("magpie") >= 0 ) //MAGPIE
                {
                        response = "Tell me more about magpies.";
                }
		else if ( statement.trim().length() == 0 ) //EMPTY OR ALL WHITESPACE STATEMENT
                {
                        response = "Say something, please.";
                }
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Who asked?";
		}
		else if (whichResponse == 5)
		{
			response = "Mhmm.";
		}

		return response;
	}
}
