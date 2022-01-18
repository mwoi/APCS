// discordDucks (Gabriel Thompson + Iggy, Kartik Vanjani + Krrish, Marcus Wu + Nat)
// APCS pd8
// HW51 -- implementing bubblesort
// 2022-01-03m
// time spent: 0.6hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 *   i. Make one "pass" through the array from right to left for each item, keeping track
 *      of the number of passes with the variable "passNum"
 *  ii. In each pass, go left from the last item until the passNum'th item, comparing each
 *      pair of two adjacent items.
 * iii. If the left item of the pair is greater than the item to the right, swap the two
 *      indexes. Repeat this for each pass.
 *  iv. When all passes have been completed, the array has been sorted
 *
 * DISCO
 *   - ArrayLists are pass-by-reference
 *   - You only need to do the p-1 passes for an array of length p, because the last item
 *     will have to be in the right spot.
 *   - We largely forgot how to use ArrayLists over break ):
 *
 * QCC
 *   - While writing our program, we tried using the '>' operator on two comparables. This
 *     yielded the following error:
 *
 *         BubbleSort.java:69: error: bad operand types for binary operator '>'
 *                 if (previous > current) {
 *                              ^
 *           first type:  Comparable
 *           second type: Comparable
 *
 *     This seems sort of counter-intuitive given that it seems like you should be able to
 *     compare Comparables with greater than/less than. Why can we not do this? What even
 *     is a Comparable?
 *   - When we were learning about primitives, we learned about how much space each occupies
 *     (e.g. ints take 32 bits). When a Comparable is declared, it can be an int, or a float,
 *     or a variety of objects, and presumably Java has to allocate an appropriate amount of
 *     storage. How much is this? How are objects even stored in computer memory at all?
 *
 * q0: If a pass requires no swaps, what do you know?
 * a0: The array is sorted
 * q1: After pass p, what do you know?
 * a1: The first or last p items are in their correct place, depending on whether you
       are going from left to right or right to left
 * q2: How many passes are necessary to completely sort?
 * a2: The same as the length of the array you are sorting
 *
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
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
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    for (int passNum = 0; passNum < data.size() - 1; passNum++) {
      for (int index = data.size() - 1; index > passNum; index--) {
        Comparable previous = data.get(index - 1);
	Comparable current = data.get(index);
        int comparison = previous.compareTo(current);

        if (comparison > 0) {
          data.set(index, previous);
	  data.set(index - 1, current);
	}
      }
    }
  }

  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> copy = new ArrayList<Comparable>();
    for (int i = 0; i < input.size(); i++)
       copy.add(input.get(i));

    bubbleSortV(copy);
    return copy;
  }


  public static void main( String [] args )
  {

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
    /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class BubbleSort
