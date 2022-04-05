/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] splits = expr.split(" ");
    Stack<String> stack = new ALStack<String>();
    Stack<Integer> ops = new ALStack<Integer>();

    //use for loop to parse expr
    for (int i=0; i<splits.length; i++){
      //initialize a String to represent each character in expr
      String givenChar = splits[i];

      //follow a case-by-case basis for digits, +, -, *, and )
      //ops:
      if ( givenChar.equals( "+") ){
        ops.push( 1 );
      }
      else if ( givenChar.equals( "-") ){
        ops.push( 2 );
      }
      else if ( givenChar.equals( "*" ) ){
        ops.push( 3 );
      }

      //digits:
      else if ( !givenChar.equals( ")" ) ){
        stack.push( givenChar );
      }

      // closer
      else {

        stack.push( unload( ((int) ops.pop()), stack) );
        
      }
      
      
    }

    return stack.peekTop();
  }//end evaluate()



  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    int retVal = Integer.parseInt( numbers.pop() );
    int om = retVal;
    
    //add
    if ( op == 1 ){
      while ( !numbers.peekTop().equals( "(") ){
        retVal += Integer.parseInt( numbers.pop() );
      }
    }
    //subtract
    else if (op == 2 ){
      retVal = 0;
      Stack<Integer> tempHolder = new ALStack<Integer>();
      while ( !numbers.peekTop().equals( "(") ){
        tempHolder.push(Integer.parseInt(numbers.pop()));
      }
      System.out.println(tempHolder);
      int firstVal = tempHolder.pop();
      while (!(tempHolder.isEmpty())) {
        retVal -= tempHolder.pop();
        System.out.println(retVal);
      }
      
      retVal = firstVal + retVal - om;
    }
    //multiply
    else if ( op == 3 ){
      while ( !numbers.peekTop().equals( "(") ){
        retVal *= Integer.parseInt( numbers.pop() );
      }
    }
    numbers.pop();
    

    return Integer.toString( retVal );
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {
      String zoo1 = "( - 56 50 14 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...-8
    

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
