/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

// discordDucks (Gabriel Thompson + Iggy, Kartik Vanjani + Krrish, Marcus Wu + Nat)
// APCS pd8
// HW40 -- 2D arrays
// 2021-11-30
// time spent: 0.5hrs

/***

DISCO:
 - Squirly brackets can be used to express an array within an array
 - Spacing within the type declaration for an array does not matter (e.g. "int [][] a" is the same as
   "int[][] a"
 - You can write FOREACH loops that use arrays for iteratives

QCC:
 - Is there a proper way to print out a 2d array? We did it by using squirly brackets and putting each
   subarray with a two-space indent before it
 - For print2(), is there a better way to account for the last subarray not having a comma afterwards?
   We had to use an "index" variable which almost defeated the point of using FOREACH.
 - Which is more efficient, FOR or FOREACH?
 - Do 3d arrays exist?

***/

public class TwoDimArray
{

  // helper function for print1() and print2(), prints out a 1d array
  public static void printArray( int[] a ) {
    System.out.print("{");

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
      if (i < a.length - 1)
        System.out.print(", ");
    }

    System.out.print("}");
  }

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    System.out.println("{");

    for (int subIndex = 0; subIndex < a.length; subIndex++) {
      System.out.print("  ");
      printArray(a[subIndex]);
      if (subIndex < a.length - 1)
        System.out.print(",");
      System.out.println();
    }

    System.out.println("}");
  }

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    int index = 0;
    System.out.println("{");

    for ( int[] line : a ) {
      System.out.print("  ");
      printArray(line);

      if (index < a.length - 1)
        System.out.print(", ");
      System.out.println();
      index++;
    }
    System.out.println("}");
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int sum = 0;
    for ( int[] sub : a ) {
      for ( int item : sub ) {
        sum += item;
      }
    }
    return sum;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    int sum = 0;

    for (int i = 0; i < m.length; i++)
      sum += sumRow(i, m);
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int sum = 0;

    for (int i = 0; i < a[r].length; i++)
      sum += a[r][i];
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    int summer = 0;

    for ( int item : m[r] )
      summer += item;

    return summer;
  }


  public static void main( String [] args )
  {
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
      print1(m1);
      print1(m2);
      print1(m3);
      print2(m1);
      print2(m2);
      print2(m3);
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));

    // your own custom test cases welcomed and encouraged
  }

}//end class TwoDimArray