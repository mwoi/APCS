/**
 *Team Purple Pineapples: Jason Zhou, Marcus Wu, Russell Goychayev
 *APCS pd7
 *HW76 -- We Got a Little Ol' Convoy
 *2022-03-14
 *time spent: 0.6 hr
 */

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

/**
 * DISCO: N/A
 * 
 * QCC: N/A
 * 
 */
public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList()
  {
    // YOUR CODE HERE
    //nothing goes here unless u want an error

  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    // YOUR CODE HERE
    //do this the first time (head has no pointers)
    if (_head == null) {
      _head = new LLNode(newVal, null);
    } else {
      //traverse
      LLNode holder = _head;
      //go through until its null
      for(;holder.getNext() != null;) {
       holder = holder.getNext();
      }
      holder.setNext(new LLNode(newVal, null));
    }
    
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode holder = _head;
    int num = 0;
    while (num < index) { 
      holder = holder.getNext();
      num++;
    }
    return holder.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode holder = _head;
    int num = 0;
    while (num < index) {
      holder = holder.getNext();
      num++;
    }
    String oldCargo = holder.getCargo();
    holder.setCargo(newVal);
    return oldCargo;
  }


  //return number of nodes in list
  public int size()
  {
    // YOUR CODE HERE
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    // YOUR CODE HERE
    String returnVal = "";
    LLNode holder = _head;
    while(holder != null) {
      returnVal += holder.getCargo() + ", ";
      holder = holder.getNext();
    }
    return returnVal;
  }


  //main method for testing
  public static void main( String[] args )
  {
    
    LList james = new LList();
    james.add("elmo");
    System.out.println(james.size());
    System.out.println(james.get(0));
    james.add("senpia");
    System.out.println(james.get(1));

    
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    
  }

}//end class LList
