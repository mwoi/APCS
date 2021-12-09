// discordDucks (Marcus Wu + Nat, Gabriel Thompson + Iggy, Kartik Vanjani + Krrish)
// APCS1 pd8
// HW45: Array of Titanium
// 2021-12-08w
// time spent: 0.8hrs

/***************************
 * class SuperArray version 3.0
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 * uses interface ListInt

 * QCC:
 *  - What is a practical use for interfaces? Why would you want to make sure that a class
 *    has certain functions, and why would you want to enforce it?
 *  - What is the point of an abstract?
 *  - The directive asks us to "Modify main() in SuperArray to test ListInt’s methods (Not
 *    SuperArray’s)". How exactly would we do this, given that every method from ListInt
 *    must be implemented in SuperArray?
 * 
 * DISCO:
 *  - We got an error message for ~30 minutes that said "SuperArray is not abstract and does
 *    not override abstract method add(int,int) in ListInt". This was because the function
 *    add(), as we defined it in SuperArray, had a different return type than an ListInt
 *  - Every method from an interface needs to be defined in a class that implements it
 * 
 ***************************/

public class SuperArray implements ListInt
{

  private int[] _data;  //underlying ("encapsulated") container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 10;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _size *= 2;
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    this._data[index] = newVal;
    return temp;
  }


  //adds an item after the last item
  public boolean add( int newVal )
  {
    int[] newData = new int[_size + 1];
    for (int i = 0; i < _size; i++) {
       newData[i] = _data[i];
    }

    newData[_size] = newVal;
    _data = newData;
    _size++;
    return true;
  }


  //inserts an item at index
  public boolean add( int index, int newVal )
  {
    add(0);
    for (int i = _size - 1; i >= index; i--) {
       _data[i] = _data[i - 1];
    }
    _data[index] = newVal;
    return true;
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
    for (int i = index; i < this._size - 1; i++) {
      this._data[i] = this._data[i + 1];
    }
    this._size--;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      System.out.println("new length of underlying array: "
      + curtis._data.length );
      }

      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);

      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);

      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(2,88);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(1,77);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
