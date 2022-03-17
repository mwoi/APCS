/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String data;
  private LLNode nextNode; 

  // constructor
  public LLNode( String value, LLNode next )
  {
    this.data = value;
    this.nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return data;
  }

  public LLNode getNext()
  {
    return nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    this.data = newCargo;
    return this.data;
  }

  public LLNode setNext( LLNode newNext )
  {
    this.nextNode = newNext;
    return this.nextNode;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return "Data is: " + data;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

    // A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }
    

    //Q: when head ptr moves to next node in list, what happens to the node it just left?

    //Its info is gone.

    //...so better: ?
    //
    //
    //

  }//end main

}//end class LLNode

