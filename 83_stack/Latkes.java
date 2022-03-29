// Team Purple Pineapples: Jason Zhou, Russell Goychayev, Marcus Wu
// APCS pd7
// HW83: Stacks on Stacks
// 2022-03-28
// time spent: 0.2 hr

/***
 * 
 * 
 * class Latkes
 * 
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO:
      Stacks are cool.

    QCC:


 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    _stack = new String[initCapacity];
    _stackSize = initCapacity;
  }// O(?)
  //O(1)



  //means of insertion
  public void push( String s )
  {
    String[] holder = new String[_stackSize + 1];
    for (int i = 0; i < _stack.length; i++) {
      holder[i] = _stack[i];
    }
    holder[_stackSize] = s;
    _stackSize++;
    _stack = holder;
  }// O(n)



  //means of removal
  public String pop( )
  {
    String[] holder = new String[_stackSize - 1];
    for (int i = 0; i < _stack.length - 1; i++) {
      holder[i] = _stack[i];
    }
    String returnVal = _stack[_stackSize - 1];
    _stackSize--;
    _stack = holder;
    return returnVal;
  }// O(n)


  //chk for emptiness
  public boolean isEmpty()
  {
    return (_stackSize == 0);
  }// O(1)


  //chk for fullness
  public boolean isFull()
  {
    /* your
       SIMPLE
       SMART
       magicks
       here
    */
    return _stackSize == _stack.length;
  }// O(1)


  //main method for testing
  public static void main( String[] args )
  {


    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
      System.out.println( tastyStack.pop() );
        System.out.println( tastyStack.pop() );

          System.out.println( tastyStack.pop() );
            System.out.println( tastyStack.pop() );
              System.out.println( tastyStack.pop() );
              

      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
