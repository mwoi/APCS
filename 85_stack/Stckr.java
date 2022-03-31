// Team Purple Pineapples: Jason Zhou, Russell Goychayev, Marcus Wu
// APCS pd7
// HW85: Leon Leonwood Stack
// 2022-03-30
// time spent: 0.5 hr

// Disco: v cool. there was a bug but it was a minor bug that we fixed up

// QCC:


/***
 * class Stckr
 * 
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    Stack<String> cakes = new LLStack<String>();
    //Stack<Z> cakes = new LLStack<Z>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    cakes.push("cob");
    cakes.push("charlie");
    cakes.push("boa");
    cakes.push("elmo");
    cakes.push("sans");
    System.out.println(cakes);
    while (!cakes.isEmpty()) {
      System.out.println(cakes);
      System.out.println(cakes.pop());
    }




    //...

  }//end main

}//end class
