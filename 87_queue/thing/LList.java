/**
 *Team Purple Pineapples: Jason Zhou, Marcus Wu, Russell Goychayev
 *APCS pd7
 *HW77 -- Insert|Remove -- add and remove
 *2022-03-15
 *time spent: 0.8 hr
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
 * Algo: for add we create holder that points to wherever we want to add. We (break apart) the pointer to the next node
 *       at insertion and point it to the con cell that we want and we have the con cell point to the next node.
 * 
 *       for remove we do the same thing but we don't have that con cell, we just have the node point to two nodes ahead.
 * 
 */
package thing;


public class LList<T> implements List<T> //interface def must be in this dir
{

  //instance vars
  private LLNode<T> _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList()
  {
    // YOUR CODE HERE
    //nothing goes here unless u want an error

  }


  //--------------v  List interface methods  v--------------

  public boolean add( T newVal )
  {
    // YOUR CODE HERE
    //do this the first time (head has no pointers)
    LLNode<T> tmp = new LLNode<T>( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }


  public T get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode<T> holder = _head;
    int num = 0;
    while (num < index) { 
      holder = holder.getNext();
      num++;
    }
    return holder.getCargo();
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode<T> holder = _head;
    int num = 0;
    while (num < index) {
      holder = holder.getNext();
      num++;
    }
    T oldCargo = holder.getCargo();
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

  public T remove(int index)
  {
    //OMG IM DYING THAT IS THE UGLIST CODE I'VE WRITTEN
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    if (index == 0) {
      T val = _head.getCargo();
      _head = _head.getNext();
      _size--;
      return val;
      
    }
    T returnVal = null;
    LLNode<T> holder = _head;
    for (int i = 0; i < index - 1; i++) {
      holder = holder.getNext();
    } 
    returnVal = holder.getNext().getCargo();
    holder.setNext(holder.getNext().getNext());
    _size--;
    return returnVal;
  }

  public void add( int index, T newVal ) 
  {
    if ( index < 0 || index > size() )
      throw new IndexOutOfBoundsException();
    LLNode<T> holder = _head;
    if (index == 0) {
      _head = new LLNode<T>(newVal, holder);
      
    } else {
      for (int i = 0; i < index - 1; i++) {
        holder = holder.getNext();
      }
      holder.setNext(new LLNode<T>(newVal, holder.getNext()));
    }
    
   

  }

  // override inherited toString
  public String toString()
  {
    // YOUR CODE HERE
    String retStr = "HEAD->";
    LLNode<T> tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing

}//end class LList
