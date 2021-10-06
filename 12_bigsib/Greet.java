/* Duo ilikecats (Marcus Wu + Ziying Jian)
   APCS
   HW12 -- On Elder Individuality and the Elimination of Radio Fuzz
   2021-10-06

   DISCO
   	new can be used to declare an instance variable connected to BigSib, and richard, drspaceman, kongfooey, and mom can all be used to run methods in BigSib.java and return different messages
   QCC
   	what does static and non-static mean for variables and methods
*/


public class Greet {
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib();
    richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

    BigSib drspaceman = new BigSib();
    drspaceman.setHelloMsg("Salutations");
    greeting = drspaceman.greet("Dr. Spaceman");
    System.out.println(greeting);

    BigSib kongfooey = new BigSib();
    kongfooey.setHelloMsg("Hey ya");
    greeting = kongfooey.greet("Kong Fooey");
    System.out.println(greeting);

    BigSib mom = new BigSib();
    mom.setHelloMsg("Sup");
    greeting = mom.greet("mom");
    System.out.println(greeting);

  } //end main()
} //end Greet