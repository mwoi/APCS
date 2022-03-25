/**
 *Team Purple Pineapples: Jason Zhou, Marcus Wu, Russell Goychayev
 *APCS pd7
 *HW80: Generically Speaking
 *2022-03-25
 *time spent: 1.0 hr
 */

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

/** (Copied lib code so i can review this in the future)
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
public class LList<T> implements List<T> //your List.java must be in same dir
{

  //instance vars
  private DLLNode _head, _tail; //pointers to first and last nodes
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = _tail = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  //add a node to end of list
  public boolean add( T newVal )
  {
    addLast( newVal );
    return true; //per Java API spec
  }


  //insert a node containing newVal at position index
  public void add( int index, T newVal )
  {
    if ( index < 0 || index > size() )
      throw new IndexOutOfBoundsException();

    else if ( index == size() )
      addLast( newVal );

    DLLNode newNode = new DLLNode( newVal, null, null );

    //if index==0, insert node before head node
    if ( index == 0 )
      addFirst( newVal );
    else {
      DLLNode tmp1 = _head; //create alias to head

      //walk tmp1 to node before desired node
      for( int i=0; i < index-1; i++ )
        tmp1 = tmp1.getNext();

      //init a pointer to node at insertion index
      DLLNode tmp2 = tmp1.getNext();

      //insert new node
      newNode.setNext( tmp2 );
      newNode.setPrev( tmp1 );
      tmp1.setNext( newNode );
      tmp2.setPrev( newNode );

      //increment size attribute
      _size++;
    }
  }//end add-at-index


  //remove node at pos index, return its cargo
  public T remove( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    if ( index == 0 )
      return removeFirst();
    else if ( index == size()-1 )
      return removeLast();
    else {
      DLLNode tmp1 = _head; //create alias to head

      //walk to node before desired node
      for( int i=0; i < index-1; i++ ) {
        tmp1 = tmp1.getNext();
        System.out.println( "tmp1: " + tmp1.getCargo() );
      }
      //check target node's cargo hold
      T retVal = (T) tmp1.getNext().getCargo();

      //remove target node
      tmp1.setNext( tmp1.getNext().getNext() );
      System.out.println( "tmp1.getNext: " + tmp1.getNext().getCargo() );
      tmp1.getNext().setPrev( tmp1 );

      _size--;

      return retVal;
    }
  }


  public T get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = (T) tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = (T) tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  //--------------v  Helper methods  v--------------

  public void addFirst( T newFirstVal )
  {
    //insert new node before first node (prev=null, next=_head)
    _head = new DLLNode( newFirstVal, null, _head );

    if ( _size == 0 )
      _tail = _head;
    else
      _head.getNext().setPrev( _head );
    _size++;
  }


  public void addLast( T newLastVal )
  {
    //insert new node after last node (prev=_last, next=null)
    _tail = new DLLNode( newLastVal, _tail, null );

    if ( _size == 0 )
      _head = _tail;
    else
      _tail.getPrev().setNext( _tail );
    _size++;
  }


  public T getFirst() { return (T) _head.getCargo(); }

  public T getLast() { return (T) _tail.getCargo(); }


  public T removeFirst()
  {
    T retVal = getFirst();
    if ( size() == 1 ) {
      _head = _tail = null;
    }
    else {
      _head = _head.getNext();
      _head.setPrev( null );
    }
    _size--;
    return retVal;
  }

  public T removeLast()
  {
    T retVal = getLast();
    if ( size() == 1 ) {
      _head = _tail = null;
    }
    else {
      _tail = _tail.getPrev();
      _tail.setNext( null );
    }
    _size--;
    return retVal;
  }
  //--------------^  Helper methods  ^--------------


  // override inherited toString
  public String toString()
  {
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

    System.out.println("initially: " );
    System.out.println( james + "\tsize: " + james.size() );

    james.add("beat");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("a");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("need");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("I");
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james + "\tsize: " + james.size() );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james + "\tsize: " + james.size() );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove last: "
                        + james.remove( james._size-1) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );
  }//end main()

}//end class LList
