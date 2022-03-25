/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode<T>
{
  //instance vars
  private T data;
  private DLLNode nextNode;
  private DLLNode prevNode;

  // constructor
  public DLLNode( T value, DLLNode previous, DLLNode next )
  {
    this.data = value;
    this.nextNode = next;
    this.prevNode = previous;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo()
  {
    return data;
  }

  public DLLNode getNext()
  {
    return nextNode;
  }

  public DLLNode getPrev()
  {
    return prevNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo )
  {
    this.data = newCargo;
    return this.data;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    this.nextNode = newNext;
    return this.nextNode;
  }

  public DLLNode setPrev( DLLNode newPrevious )
  {
    this.prevNode = newPrevious;
    return this.prevNode;
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


    //Q: when head ptr moves to next node in list, what happens to the node it just left?

    //Its info is gone.

    //...so better: ?
    //
    //
    //

  }//end main

}//end class LLNode
