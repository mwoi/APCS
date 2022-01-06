// Oscar Breen -- Team Consonants2 -- Ari, Marcus 
// APCS pd8
// HW53 -- implementing insertion sort
// 2022-01-06r
// time spent: 0.6 hrs

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
 * adding new element to the list, sorts it through comparison of the element to its left, if larger than it,
   then it continues along to the next element, if not, it swaps the two numebrs adn then rechecks if it, 
   in its new spot, is also smaller or larger than another value to its left
 * DISCO: while i at first still thought it would be veiwing only in paris of the two, it still remains that the list before 
 	, and the fact that its sorted, exists along each pass, as it goes through data set, not switiching between two different
	arrays (which we initally tried to do)
 *
 * QCC; is this the longest in terms of time sorting method we have made? becasue it seems that it's the most inefficient
 	and what was meant in class when it was said that a comparison is shorter than a swap, doesnt the comparison still need a swap?
 * q0: How many passes to sort n elements?
 * a0: n - 1 passes
 * q1: What do you know after pass p?
 * a1: that p+1 elements are sorted
 * q2: How will you know when sorted?
 * a2: after the number of passes equals the size +1
 * q3: What constitues a pass?
 * a3: increasing the sorted list size by one
 * q4: What must you track?
 * a4: how far along the array it has sorted (partitions)
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
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
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {




    for(int partition = 1; partition < data.size(); partition ++  ) {
      //partition marks first item in unsorted region
	
      System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      System.out.println( data );
       
      //traverse sorted region from right to left
      for( int i = partition; i > 0 ; i-- ) { // for styatement to contiunue swap for the number of partitions (size)

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo(data.get(i-1)) < 0  ) {  //bigger or smaller question

          System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          Comparable sorting = data.get(i);
	  data.set(i , data.get(i-1));    //swaps them here
	  data.set(i-1, sorting);
        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort


  public static void main( String [] args )
  {
    
      System.out.println("\n\n\n" + "----------*** Testing sort-in-place (void) version... ***---------- ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );
      ArrayList sally = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList sally before sorting:\n" + sally );
      insertionSortV(sally);
      System.out.println( "\nArrayList sally after sorting:\n" + sally );
     

    
      System.out.println( "\n" + "\n\n\n" + "----------*** Testing non-void version... ***---------- " );
      ArrayList mark = new ArrayList<Integer>();
      mark.add(7);
      mark.add(1);
      mark.add(5);
      mark.add(12);
      mark.add(3);
      System.out.println( "\nArrayList mark before sorting:\n" + mark );
      ArrayList markSorted = insertionSort( mark );
      System.out.println( "\nsorted version of ArrayList mark:\n"
      + markSorted );
      System.out.println( "\nArrayList mark after sorting:\n" + mark );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      

  }//end main

}//end class InsertionSort
