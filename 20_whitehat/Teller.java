/*

FrogHats - Neil Lin, Kevin Cheng, Marcus Wu
APCS
HW20 -- External Audit
2021-10-20

DISCO: We can easily abuse default values of instance variables, and maybe this is why constructors are incredibly useful (to set and initialize these default values).
null without quotes denotes an empty string.

QCC: Why is there a .0000000004 at the end of the output of the harrison.withdraw()?

*/

public class Teller {
	public static void main(String[] args) {

		BankAccount harrison = new BankAccount(); //the bad guy
		BankAccount jerry = new BankAccount(); //the good guy
		//jerry testing begins

		jerry.setFullName("Jerry Tom");
		jerry.setPassword("purpleelephant12");
		jerry.setPin(7292);
		jerry.setAccNumber(578435789);
		System.out.println( jerry.accountInfo() );
		System.out.println( jerry.withdraw(24.99, 7292, "purpleelephant12") ); //oops! invalid amount
		System.out.println( jerry.deposit(200.00, 7292) );
		System.out.println( jerry.withdraw(24.99, 7292, "purpleelephant12") );
		//jerry testing ends

		//harrison testing
		harrison.setFullName("Harrison Gore");
		System.out.println( harrison.accountInfo() );

		//If we do not set a PIN, the "private int pin;" will default integer pin to a value of 0.
		//The PIN does not need get forced to 4 digits, since the method that checks this (checkPinNumber) is only run inside setPin, which was never ran.
		//The same happens to instance variable accNumber, which defualts to 0 and bypasses the check checkAccNumber within setAccNumber.
		//The same happens to instance variable password, which defaults to null.
		//Using these, we can use any method requiring an account PIN and password, without setting a PIN or password, and using 0 and null instead, respectively.

		//authentication with pin=0 and password=null, returns true
		System.out.println( "AUTHENTICATION: " + harrison.authenticate(0, null) + "\n" );

		//deposit can be used with pin=0 and password=null
		System.out.println( harrison.deposit(4324.11, 0) );
		System.out.println( harrison.deposit(43892.23, null) );

		//withdraw can be used with pin=0 and password=null
		System.out.println( harrison.withdraw(48216.34, 0, null) );
		//something weird happens to the balance here, not sure why
		System.out.println( harrison.withdraw(-231930213921.22, 0, null) ); //free money, withdrawing negative amounts
		//harrison testing ends
	}
}
		