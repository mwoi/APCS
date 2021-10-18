/*
 * Frog Hats - Kevin Cheng, Neil Lin, Marcus Wu
 * APCS
 * 2021-10-17
 *
 * DICSO:
 * You can limit the number of digits of a value by taking the remainder of the number to some power of 10.
 * One way overloading a constructor can be useful, for when not all data is filled in
 * Type casting for converting between different units, if it ever is necessary. 
 *
 * QCC:
 * How do we give everyone a unique ID that we don't have to fill in?
 * Is it necessary for the new Bank Account classes to be static for them to be executed?
 *
 * Q2:
 * 
 *
 * Q3:
 *
 *
 */

public class BankAccount {

	private String accountHolder, password;
	private int pin, id;
	private long balance;

	public BankAccount() {
		accountHolder = "John Doe";
		password = "";
		pin = 0;
		id = 0;
		balance = 0;
	}

	public BankAccount(String holderName, String newPassword, int newPin, int newId) {
		
		//To ensure the pin is 4 digits long and the id is 9 digits long
		pin = newPin % 10000;
		id = newId % 1000000000;

		accountHolder = holderName;
		password = newPassword;
	}

	public void setAccountName(String newName) {
        	accountHolder = newName;
    	}

	public void setPassword(String newPassword) {
		password = newPassword;
	}

	public void setPin(int newPin) {
		pin = newPin % 10000;
	}

	public void deposit(double value) {
		long longValue = (long) value;
		balance += longValue;
	}

	public void withdrawl(double value) {
		long longValue = (long) value;
		balance -= value;
	}

	public void myAccountInfo() {
		System.out.println("Account Holder Name: " + accountHolder);

		//Separate the long into cents and dollars
		long centsBalance = balance % 100;
		long dollarsBalance = (balance - centsBalance) / 100;
		System.out.println("Account Balance: $" + dollarsBalance + "." + centsBalance);
		
		System.out.println("Pin Number: " + pin);
		System.out.println("Password: " + password);
		System.out.println("Account ID: " + id);
	}
}