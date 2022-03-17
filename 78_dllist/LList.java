
/**
 *Team Purple Pineapples: Jason Zhou, Marcus Wu, Russell Goychayev
 *APCS pd7
 *HW78: Double Up
 *2022-03-16
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
 *       NOW WE DO THE SAME THING AS ABOVE BUT WE ADD THE PREVIOUS POINTERS !!!
 */
public class LList implements List //interface def must be in this dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList()
  {
    // YOUR CODE HERE
    _head = null;
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    // YOUR CODE HERE
    //do this the first time (head has no pointers)
    DLLNode holder = new DLLNode( newVal, _head, _tail );
    //adding first element (  TAIL -> [ cell ] <- HEAD)
    if (_head == null) {
      _head = holder;
      _tail = holder;
    } else {
      // TAIL -> [ cell ] -> <- [elmo] -> HEAD
      _head.setPrevious(holder);
      holder.setNext(_head);
      _head = holder;

    }
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    DLLNode holder = _head;
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
    DLLNode holder = _head;
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

  public String remove(int index)
  {
    //OMG IM DYING THAT IS THE UGLIST CODE I'VE WRITTEN
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    if (index == 0) {
      String val = _head.getCargo();
      _head = _head.getNext();
      _size--;
      return val;
      
    } else if(index == _size - 1) {
      String val = _head.getCargo();
      _head = _head.getPrevious();
      _head.setNext(null);
      _size--;
      return val;
    }
    String returnVal = "";
    DLLNode holder = _head;
    for (int i = 0; i < index - 1; i++) {
      holder = holder.getNext();
    } 

    returnVal = holder.getNext().getCargo();
    holder.setNext(holder.getNext().getNext());
    holder.getNext().setPrevious(holder);
    _size--;
    return returnVal;
  }

  public void add( int index, String newVal ) 
  {
    if ( index < 0 || index > size() )
      throw new IndexOutOfBoundsException();
    DLLNode holder = _head;
    if (index == 0) {
      add(newVal);      
    } else {
      for (int i = 0; i < index - 1; i++) {
        holder = holder.getNext();
      }
      holder.setNext(new DLLNode(newVal, holder.getNext(), holder));
      holder.getNext().getNext().setPrevious(holder.getNext());
    }
    _size++;
   

  }

  // override inherited toString
  public String toString()
  {
    // YOUR CODE HERE
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    
    LList james = new LList();
    james.add("elmo");
    james.add("fineas");
    james.add(0, "flea");
    System.out.println(james);
    System.out.println(james.get(0));
    
    System.out.println(james);
    
  }

}//end class LList
