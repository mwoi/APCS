/*
Team Purple Pineapples: Jason Zhou, Russell Goychayev, Marcus Wu
APCS pd7
HW84 -- Stack: What Is It Good For?
2022-03-29
time spent: 1.5 hours
*/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    //make a Latkes with initCapacity = s.length()
    Latkes stack = new Latkes( s.length() );

    //push each char of s onto said Latkes
    for (int i = 0; i<s.length(); i++){
      stack.push( s.substring( i, i+1) );
    }

    //pop each char of said Latkes into retVal
    String retVal = "";
    while ( !stack.isEmpty() ){
      retVal += stack.pop();
    }

    return retVal;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {

    //initialize a Latkes with initCapacity = s.length()
    Latkes stack = new Latkes( s.length() );

    /*
    ALGO:
    if stack is empty and all chars in s have not yet been added:
      add the next char in s
    else:
      if stack.getLast() is the complement of a given char:
        stack.pop()
      else:
        stack.push( given char )
    */
    for (int i=0; i<s.length(); i++){
      String givenChar = s.substring( i, i+1 );

      if ( stack.isEmpty() ) {
        stack.push( givenChar );
      }
      else {
        if ( (stack.getLast().equals( "(") && givenChar.equals( ")" )) ||
             (stack.getLast().equals( "[") && givenChar.equals( "]" )) ||
             (stack.getLast().equals( "{") && givenChar.equals( "}" )) ) {
          stack.pop();
             }
        else {
          stack.push( givenChar );
        }
      }
    }

    return stack.isEmpty();
  }



  //main method to test
  public static void main( String[] args )
  {

    //System.out.println(flip("stressed"));
    //System.out.println(allMatched( "({}[()])" )); //true
    //System.out.println(allMatched( "([)]" ) ); //false
    //System.out.println(allMatched( "(){([])}" ) ); //true
    //System.out.println(allMatched( "](){([])}" ) ); //false
    //System.out.println(allMatched( "(){([])}(" ) ); //false
    //System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
  }

}//end class
