/**
 *Team Purple Pineapples: Jason Zhou, Marcus Wu, Russell Goychayev
 *APCS pd7
 *HW81: Thank You, Next
 *2022-03-25
 *time spent: 0.7 hr
 */

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
      Iterator
    QCC
      Why is the line to create a new Iterator:
        Iterator it = L.iterator();
      instead of:
        Iterator it = new Iterator();
      What is iterator()?

    SUMMARY THE FIRST:
      Iterator is a class or interface that has methods which can facilitate
       iterating through a collection of objects. When an iterator is created for
       a collection L ( Iterator it = L.iterator(); ), it can also modify the
       original collection L using remove().
    SUMMARY THE SECOND:
      ..
**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    boolean ret = false;
    for ( Integer n : L ) {
      if ( n == key )
        return true;
    }
    return ret;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    boolean ret = false;
    Iterator it = L.iterator();
    while ( it.hasNext() ) {
      if ( it.next() == key )
        ret = true;
    }
    return ret;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> ret = new ArrayList<Integer>();
    for ( Integer n : L ) {
      if ( n % 2 == 1 )
        ret.add(n);
    }
    return ret;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    List<Integer> ret = new ArrayList<Integer>();
    Integer check = 0;
    Iterator it = L.iterator();
    while ( it.hasNext() ) {
      check = (Integer) it.next();
      if ( check % 2 == 1 )
        ret.add( check );
    }
    return ret;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Integer check = 0;
    Iterator it = L.iterator();
    while ( it.hasNext() ) {
      check = (Integer) it.next();
      if ( check % 2 == 0 )
        it.remove();
    }
  }


  public static void main( String [] args )
  {


    //var type: List   obj type: ArrayList
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    System.out.println("a) using a FOREACH loop");
    for ( Integer n : L )
      System.out.print( n + ", " );

    // b) explicitly using an iterator
    System.out.println("\nb) explicitly using an iterator");
    Iterator it = L.iterator();
    while ( it.hasNext() )
      System.out.print( it.next() + ", " );

    System.out.println("\n\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
        /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
