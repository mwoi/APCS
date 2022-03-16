// Team Purple Pineaples: Jason Zhou, Marcus Wu, Russell Goychayev
// APCS pd7
// HW72: So So Fast
// 2022-03-08m
// time spent: 0.5 hrs

/***
 * Algo: shrink the array (search space until our tracking variable (holder) is equal to the position of what y should be)
 *       if greater than increase bound by 1, or else left bound gets bigger 
 * 
 * BEST CASE: if the element that is the pivot is same as yth smallest. So O(N) also if its ordered i think
 * 
 * ELSE: O(N^2) since we keep searching O(N) N times.
 * 
 * DISCO: Split method makes this easier especially since we know it splits the array into parts greater or less than.
 * 
 * QCC:
 * 
 ***/


public class FastSelect 
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
   * DESCRIP
   * 
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return int 
   *
   */
  public static int split( int arr[], int a, int b, int c)
  {
	int v = arr[c];
    swap(c, b, arr);
    int s = a;
    for (int i = a; i < b; i++) {
        if (arr[i] <= v) {
            swap(i, s, arr);
            s += 1;
        }
    }
    swap(s, b, arr);
    return s;  
  }//end mysterion

  public static int fastSelect(int[] arr, int y) {
    int leftBound = 0;
    int rightBound = arr.length - 1;
    int pivot = rightBound;
    int holder = -1;
    while (holder != y - 1) {
        holder = split(arr, leftBound, rightBound, pivot);
        if(holder > y - 1) {
           rightBound = holder - 1;
           pivot = rightBound;
        }
        else {
           leftBound = holder + 1;
        }

    }
    return arr[holder];
  }

  public static void main(String[] args) {
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,37, 4982};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};

    System.out.println(fastSelect(arr1, 2));

    System.out.println("Best");
    System.out.println(fastSelect(arr3, 1));

  }
}
