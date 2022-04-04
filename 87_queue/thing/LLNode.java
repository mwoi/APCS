/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

package thing;


public class LLNode<T>
{
  //instance vars
  private T data;
  private LLNode<T> nextNode; 

  // constructor
  public LLNode( T value, LLNode<T> next )
  {
    this.data = value;
    this.nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo()
  {
    return data;
  }

  public LLNode<T> getNext()
  {
    return nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo )
  {
    this.data = newCargo;
    return this.data;
  }

  public LLNode<T> setNext( LLNode<T> newNext )
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

}//end class LLNode

