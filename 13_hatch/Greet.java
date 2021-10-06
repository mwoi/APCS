/* Duo ilikecats (Marcus Wu + Ziying Jian)
   APCS
   HW13 -- Where do BigSibs Come From?
   2021-10-07

   DISCO
   	
   QCC
   	
*/


public class Greet {
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib("Word up");
    //richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

    BigSib drspaceman = new BigSib("Salutations");
    //drspaceman.setHelloMsg("Salutations");
    greeting = drspaceman.greet("Dr. Spaceman");
    System.out.println(greeting);

    BigSib kongfooey = new BigSib("Hey ya");
    //kongfooey.setHelloMsg("Hey ya");
    greeting = kongfooey.greet("Kong Fooey");
    System.out.println(greeting);

    BigSib mom = new BigSib("Sup");
    //mom.setHelloMsg("Sup");
    greeting = mom.greet("mom");
    System.out.println(greeting);

  } //end main()
} //end Greet