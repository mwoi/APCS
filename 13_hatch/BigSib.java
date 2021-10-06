/* Duo ilikecats (Marcus Wu + Ziying Jian)
   APCS
   HW13 -- Where do BigSibs Come From?
   2021-10-07

   DISCO
   	see Greet.java
   QCC
   	--
*/


public class BigSib{
	private String helloMsg;
	public BigSib(String msg){ //constructor
		helloMsg = msg;
	}

	public String greet(String name){
		return (helloMsg + " " + name);
	}
}


