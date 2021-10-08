/* Marcus Wu
   APCS
   HW14 -- Customize Your Creation
   2021-10-08

   DISCO
   	i dont think its possible for a default constructor to return different values for multiple instance variables. if there are no parameters, they are all invoking the same constructor BigSib() which returns value "Word up" for each
   QCC
   	why use a default constructor over one that can take arguments
*/


public class Greet {
	public static void main(String[] args){
		String greeting;
		BigSib richard = new BigSib();
		BigSib grizz = new BigSib();
		BigSib dotCom = new BigSib();
		BigSib tracy = new BigSib();
		greeting = richard.greet("freshman");
		System.out.println(greeting);
		greeting = tracy.greet("Dr. Spaceman");
		System.out.println(greeting);
		greeting = grizz.greet("Kong Fooey");
		System.out.println(greeting);
	  	greeting = dotCom.greet("mom");
		System.out.println(greeting);
	} // end main()
} // end Greet