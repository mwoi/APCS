/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode<T>
{
  //instance vars
  private Object data;
  private DLLNode nextNode;
  private DLLNode previousNode;

  // constructor
  public DLLNode( Object value, DLLNode next, DLLNode previousNode )
  {
    this.data = value;
    this.nextNode = next;
    this.previousNode = previousNode;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo()
  {
    return (T) data;
  }

  public DLLNode getNext()
  {
    return nextNode;
  }

  public DLLNode getPrev()
  {
    return previousNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo )
  {
    this.data = newCargo;
    return (T) this.data;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    this.nextNode = newNext;
    return this.nextNode;
  }

  public DLLNode setPrevious( DLLNode newPrevious )
  {
    this.previousNode = newPrevious;
    return this.previousNode;
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
