/* Marcus Wu
   APCS
   HW08 -- Refactor Freshie Zero
   2021-10-01

   DISCOVERIES
   	nothing new
   UNRESOLVED QUESTIONS
   	what is (String[] args)
	what is static, and why are there errors when a function is not static
*/



public class Greet{
	public static void main(String[] args){
		greet("River");
		greet("Vanjani");
		greet("Yagupsky");
	}
	public static void greet(String name){
		System.out.println("Hello, " + name +  ". Hello, thank-you, and hello.");
	}
}
