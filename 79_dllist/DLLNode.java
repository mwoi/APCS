/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode
{
  //instance vars
  private String data;
  private DLLNode nextNode; 
  private DLLNode previousNode;

  // constructor
  public DLLNode( String value, DLLNode next, DLLNode previousNode )
  {
    this.data = value;
    this.nextNode = next;
    this.previousNode = previousNode;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return data;
  }

  public DLLNode getNext()
  {
    return nextNode;
  }
  
  public DLLNode getPrevious() 
  {
    return previousNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    this.data = newCargo;
    return this.data;
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

