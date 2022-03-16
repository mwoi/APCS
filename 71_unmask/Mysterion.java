/**
Team Slightly Under-ripe Bananas (Joshua Yagupsky, Marcus Wu, Ivina Wang)
APCS pd7
HW71 -- Whut Dis.
2022-03-7
time spent: 1.0 hr
**/

/***
 * SKEELTON for
 * class Mysterion
 * tests preliminary hypotheses re: utility of mystery algo
 *
 * <h1>It's a Bird, It's a Plane! It's.... MYSTERION</h1>
 * The Mysterion method moves all of the elements in the range [a,b-1] of an array such that all elements less than the value at c end up to the left of the value at c, and all elements greater than the value at c end up to the right of the value at c.
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Joshua Yagupsky, Marcus Wu, Ivina Wang
 * @version 1.0
 * @since   2022-03-07m
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s]
 *
 * DISCO:
 * int a and b denote the range being partitioned by v.
 * QCC:
 * Wheres arr2 in the skeleton? why does it skip from arr1 to arr3?
 * Why is mysterion return an int s?
 *
 * q0: What does it do?
 * a0:
 * The Mysterion method takes a subrange of an array (from a to b, inclusive) and an element in that subrange, what we call v.
 * It then moves all of the elements in that subrange such that all elements less than v end up to its
 * left, while all elements greater than v end up to its right.
 * To accomplish this, it first swaps v with the last element in the subrangeto keep it safe. Next, it initializes a special array index, s.
 * Everything to the left of s is what the algorithm has already determined is less than v.
 * We now loop through each element in the subrange (except for the last one). If the value we find is less than our value v, we swap it with whatever's at s and increment s.
 * Once we've completed the loop, all elements in the subrange less than v will be to the left of s. We then swap whatever's at s with v. This completes the partition.
 * q1: What is its Big-Oh runtime?
 * a1: The algorithm is linear, or O(n), because the most difficult task we have to do is traverse the range from a to b-1.
 * The computational complexity of this varies linearly with the size of the range.
 ***/


public class Mysterion
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  /**
   * int mysterion(int[],int,int,int)
   * DESCRIP:
   * Assigns the value of arr[c] to v
   * Moves everything bigger than v to the right of v and everything less than v to the left of v.
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return int
   *
   */
  public static int mysterion(int[] arr, int a, int b, int c){
    int v = arr[c];
    swap(c, b, arr);
    int s = a;
    for (int i = a; i < b; i++){
      if (arr[i] < v){
        swap(s, i, arr);
        s++;
      }
    }
    swap(b, s, arr);
    return s;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};


    // run mysterion on each array,
    // holding a & b fixed, varying c...
    for( int testC = 0; testC < 5; testC++ ) {
      System.out.println("arr1: ");
      printArr(arr1);
      mysterion(arr1,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" + testC +"...");
      printArr(arr1);
      System.out.println("-----------------------");

      System.out.println("arr3:");
      printArr(arr3);
      mysterion(arr3,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" + testC +"...");
      printArr(arr3);
      System.out.println("-----------------------");

      System.out.println("arr4:");
      printArr(arr4);
      mysterion(arr4,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" + testC +"...");
      printArr(arr4);
      System.out.println("-----------------------");

      System.out.println("arr5:");
      printArr(arr5);
      mysterion(arr5,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" + testC +"...");
      printArr(arr5);
      System.out.println("-----------------------");
    }
  }//end main

}//end class Mysterion
