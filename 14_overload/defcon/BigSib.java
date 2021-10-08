/* Marcus Wu
   APCS
   HW14 -- Customize Your Creation
   2021-10-08

   DISCO
   	see Greet.java
   QCC
   	--
*/


public class BigSib{
	private String helloMsg;

	public BigSib(){ //default constructor, no args
		helloMsg = "Word up";
	}

	public String greet(String name){
		return (helloMsg + " " + name);
	}
}


