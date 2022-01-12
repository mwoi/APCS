// Marcus Wu
// APCS pd8
// HW54 -- One File to Bring Them All...
// 2022-01-12w
// time spent: .3 hr

import java.util.ArrayList;

public class MySorts
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
  // finds the largest element in an array and moves it to the rightmost position, then the next largest 
  //    to the rightmost - 1, etc.
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end
    //maxPos will point to position of SELECTION (greatest value)
    int maxPos; //index of the greatest value
    int pass = 1;
    int counterC = 0;
    int counter = 0;

    for( int i = data.size() - 1; i >= 0; i-- ) {
      //System.out.println( "\nbegin pass " + pass );//diag
      maxPos = 0;
      
      for( int j = data.size() - pass; j >= 0; j-- ) {
        counterC++;
        if ( data.get(j).compareTo( data.get(maxPos) ) > 0 )
            maxPos = j;

        //System.out.println( "maxPos: " + maxPos );//diag
        //System.out.println( data );//diag
      }//end of loop
    Comparable temp = data.get(maxPos);
    data.set( maxPos, data.get(i) );
    data.set( i, temp );
    counter++;
    pass++;
    //System.out.println( "after swap: " +  data );//diag
    }//end of all loops, sorted 
    System.out.println("\nSwaps: " + counter + "\nComparisons: " + counterC + "\nPasses: " + pass);
  }//end selectionSort
  
  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  // starts off with an array of size 1, then adds 1 to the partition size and compares the added element
  //    with the one on its left, swapping if it is smaller. this repeats until the size of the partition 
  //    is equal to the size of the array.
  public static void insertionSort( ArrayList<Comparable> data )
  {
    int counter = 0;
    int counterC = 0;
    int counterP = 0;

    for( int partition = 1; partition < data.size(); partition++ ) {
      //partition marks first item in unsorted region
	  counterP++;
      //System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      //System.out.println( data );
       
      //traverse sorted region from right to left
      for( int i = partition; i > 0 ; i-- ) { // for styatement to contiunue swap for the number of partitions (size)
        counterC ++;
        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo(data.get(i-1)) < 0  ) {  //bigger or smaller question
          //System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          Comparable sorting = data.get(i);
	      data.set(i , data.get(i-1)); //swaps them here
	      data.set(i-1, sorting);
	      counter ++;
        }
        else
          break;
      }
    }
    //System.out.println("\nSwaps: " + counter + "\nComparisons: " + counterC + "\nPasses: " + counterP );
  }//end insertionSortV
  
  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  // iterates through the array from right to left, comparing pairs of elements, and if the left item is larger, 
  //    they swap. if not, the left item in the pair is compared with the item to the left of it, and this repeats.
   public static void bubbleSort( ArrayList<Comparable> data )
  {
    int counter = 0;
    int counterP = 0;
    int counterC = 0;
    for (int passNum = 0; passNum < data.size() - 1; passNum++) {
      counterP++;
      for (int index = data.size() - 1; index > passNum; index--) {
        Comparable previous = data.get(index - 1);
	    Comparable current = data.get(index);
        int comparison = previous.compareTo(current);
        counterC++;
        if (comparison > 0) {
          data.set(index, previous);
	      data.set(index - 1, current);
	      counter++;
	    }
      }
    }
    //System.out.println("\nSwaps: " + counter + "\nComparisons: " + counterC + "\nPasses: " + counterP );
  }//end counter
}//end all