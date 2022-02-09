/*
Team Turtle (Marcus Wu and Ivina Wang)
APCS pd7
HW#61 -- Instructions so Simple...
2022-02-08
time spent: 1 hr
*/
/***
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
    You split the array in half until the half arrays have only
      1 element
    Then merge the arrays maintaining ascending order, until you are left with
      1 sorted array
***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {

    int[] output = new int[ ( a.length + b.length ) ];
  	int checkA = 0;
  	int checkB = 0;

  	for ( int i = 0; i < output.length ; i++ ) {
  		if ( checkA == a.length ) { //if done checking array a
  			output[i] = b[checkB];
  			checkB++;
  		} else if ( checkB == b.length ) { //if done checking array b
  			output[i] = a[checkA];
  			checkA++;
  		} else {
  			if ( a[checkA] < b[checkB] ) { //if a < b, add a to output
  				output[i] = a[checkA];
  				checkA++;
  			} else { //if b < a or b == a, add b to output
  				output[i] = b[checkB];
  				checkB++;
  			}
  		}
  	}

	return output;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    if ( arr.length > 1 ) {
      int half = arr.length / 2;
      int[] a = new int[half];
      int[] b = new int[arr.length - half];

      for ( int i = 0; i < a.length; i++ ) { //copies first half of arr to a
        a[i] = arr[i];
      }
      for ( int j = 0; j < b.length; j++){ //copies second half of arr to b
        b[j] = arr[half + j];
      }
      arr = merge( sort(a), sort(b) );
    }
    return arr;
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
  }//end main()

}//end class MergeSort
