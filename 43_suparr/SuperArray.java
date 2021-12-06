// discordDucks (Kartik Vanjani + Krrish, Gabriel Thompson + Iggy, Marcus Wu + Nat)
// APCS pd8
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-06m
// time spent: 0.4hrs

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.

 * QCC:
 *  - Could we use the Object class to expand this to cover all datatypes, not just ints? 
 *  - Should there be an overloaded constructor that takes in an array length?
 *  - Given that it's possible to create a superarray, why aren't they used more often? Is it
 *    purely for memory and efficiency?
 *  - Given that we made set() and get() functions (meaning that the user has access to _data,
 *    why make data private?
 * 
 * DISCO:
 *  - The only to change the length of the array assigned to a variable is to re-instantiate
 *    it, which deletes all the elements. In order to maintain elements, you must use a temp
 *    variable

 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
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
    String out = "[";
    for (int i = 0; i < this._size; i++) {
       out += this.get(i);
       if (i < this._size - 1)
         out += ", ";
    }
    out += "]";
    return out;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[this._size];
    for (int i = 0; i < this._size; i++)
      temp[i] = this._data[i];

    _data = new int[this._size * 2];
    for (int i = 0; i < this._size; i++)
      this._data[i] = temp[i];

    this._size = this._size * 2;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    if (index < this._size)
      return this._data[index];

    System.out.println("Index out of range. -1 was returned");
    return -1;
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int old = get(index);
    this._data[index] = newVal;
    return old;
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
      }
  }//end main()


}//end class
