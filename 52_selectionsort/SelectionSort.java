// Marcus Wu
// APCS pd8
// HW52 -- implementing selection sort
// 2022-01-05w
// time spent: 1 hr

/******************************
 *   class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO:
 *   - SelectionSort iterates through the array n times for an array of n items.
 *   - For every iteration, or pass, SelectionSort traverses the array from right to left.
 *   - At the end of the first pass, the largest value is moved to the rightmost end of the array.
 *   - The process is repeated with the second largest value being moved to the second item from the right, 
 *     the third value moved to the third item from the right, etc. until n passes are completed.
 * DISCO
 *   - You can't have a nested for loop that uses the same variable ( e.g., int i = data.size() ) as the outer
 *     for loop, or it will yield an error ( variable i is already defined... )
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n-1 passes
 * q1: What do you know after pass p?
 * a1: p elements from the rightmost end of the array are sorted
 * q2: How do you know if sorted?
 * a2: n (or n-1) passes have occurred
 * q3: What does a pass boil down to?
 * a3: maxPos and the largest value on interval [0,size-p] is found, then moved to the right and sorted
 ******************************/


import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos; //index of the greatest value
    int pass = 1;

    for( int i = data.size() - 1; i >= 0; i-- ) {
      System.out.println( "\nbegin pass " + pass );//diag
      maxPos = 0;
      
      for( int j = data.size() - pass; j >= 0; j-- ) {
        if ( data.get(j).compareTo( data.get(maxPos) ) > 0 )
            maxPos = j;

        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag
      } //end of loop
    Comparable temp = data.get(maxPos);
    data.set( maxPos, data.get(i) );
    data.set( i, temp );
    pass++;
    System.out.println( "after swap: " +  data );//diag
    } //end of all loops, sorted 
  }//end selectionSort


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort


  public static void main( String [] args )
  {


    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );
    /*===============for VOID methods=============
      ============================================*/


      ArrayList glena = new ArrayList<Integer>();
      glena.add(7);
      glena.add(1);
      glena.add(5);
      glena.add(12);
      glena.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glena );
      ArrayList glenSorted = selectionSort( glena );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glena );

      ArrayList cocoa = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + cocoa );
      ArrayList cocoSorted = selectionSort( cocoa );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + cocoa );
      System.out.println( cocoa );
    /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class SelectionSort
