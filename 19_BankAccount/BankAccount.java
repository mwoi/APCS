/* 

FrogHats - Neil Lin, Kevin Cheng, Marcus Wu
APCS
HW19 -- Mo Money Mo Problems ...MORE AWESOME
2021-10-19

DISCO: "\n" in strings starts on a new line

QCC: what is toString(), and why not just use System.out.print()? why should withdraw() and authenticate() be booleans instead of void?

*/

public class BankAccount {

	//instance variables
	private String name, password;
	private int pin, id;
	private double balance;
	
	//setting attributes
	public String setName( String newName ) {
		name = newName;
		return name;
	}

	public String setPassword( String newPassword ) {
		password = newPassword;
		return password;
	}

	public int setPin( int newPin ) {
		if ( ( newPin >= 1000 ) && ( newPin <= 9998 ) ) {
			pin = newPin;
			return pin;
		}
		else {
			pin = 9999;
			System.out.println("Error: PIN should be 4 digits long.");
			return pin;
		}
	}

	public int setId( int newId ) {
		if ( ( newId >= 100000000 ) && ( newId <= 999999998 ) ) {
			id = newId;
			return id;
		}
		else {
			id = 999999999;
			System.out.println("Error: Account number should be 9 digits long.");
			return id;
		}
	}

	public double setBalance( double newBalance ) {
		balance = newBalance;
		return balance;
	}

	public void deposit( double value ) {
		balance += value;
	}

	public boolean withdraw( double value ) {
		if ( value > balance ) { //withdrawing too much
			System.out.println("Error: Cannot withdraw more than current balance.");
			return false;
		}
		else {
			balance -=  value;
			return true;
		}
	}

	public boolean authenticate( int inputId, String inputPassword ) {
		if ( ( id == inputId ) && ( password == inputPassword ) ) {
			return true;
		}
		else {
			return false;
		}
	}

	//returns account info
	public String toString() {
		String retStr = "\nAccount info:\n=======================";
		retStr = retStr + "\nName: " + name;
		retStr = retStr + "\nPassword: " + password;
		retStr = retStr + "\nPIN: " + pin;
		retStr = retStr + "\nAccount Number: " + id;
		retStr = retStr + "\nBalance: " + balance;
		retStr = retStr + "\n=======================";
		return retStr;
	}

	//main
	public static void main( String[] args ) {
		//account with valid details
		BankAccount ba = new BankAccount();

		ba.setName("Richard");
		ba.setPassword("abc123");
		ba.setPin(4389);
		ba.setId(584385548);
		ba.setBalance(21953.45);
		ba.deposit(40.44);
		ba.withdraw(20000.01);
		ba.authenticate(584385548, "abc123");

		System.out.print( ba.toString() );

		//test account with bad pin and id
		BankAccount ba2 = new BankAccount();

		ba2.setName("Richie");
		ba2.setPassword("purpleelephant12");
		ba2.setPin(583192918);
		ba2.setId(1002);
		ba2.setBalance(5348492.21);
		ba2.deposit(145.73);
		ba2.withdraw(17300000.00);
		ba2.authenticate(1002, "purpleelephant16");

		System.out.print( ba2.toString() );
	}
}