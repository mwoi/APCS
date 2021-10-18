public class AccountCreator {

	static BankAccount Kevin = new BankAccount();
	static BankAccount Neil = new BankAccount("Neil Lin", "rightzebraattackbinder", 56, 1284393);
	static BankAccount Marcus = new BankAccount("Marcus Wu", "password", 78901234, 1273450984);

	public static void main(String[] args) {
		//Testing the default constructor
		Kevin.myAccountInfo();

		//Testing deposit and withdrawl
		Neil.deposit(7654);
		Neil.myAccountInfo();
		System.out.println("Name: Neil Lin, Balance: $76.54, PIN: 56, Password: rightzebraattackbinder, ID:1284393");
	
		Neil.withdrawl(5642);
		Neil.myAccountInfo();
		System.out.println("Should return $20.12");

		//Testing the digit limiters for pin and id
		Marcus.myAccountInfo();
		System.out.println("PIN: 1234, ID: 273450984");
	}
}