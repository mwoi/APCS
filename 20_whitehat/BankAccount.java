// Team Up2U (Ziying Jian, Emily Ortiz, Kartik Vanjani, Scruffy, Applesauce, Krrish)
// APCS
// HW19 - Mo Money Mo Problems ...MORE AWESOME
// 2021-10-18

/*
DISCOVERIES:
- A boolean expression always returns a true or false value
- Unlike Python where you could do num1 < x < num2, Java doesn't understand that syntax
and you can only denote more than one inequality through the conditional, &&
- \n denotes a line break
- void, as a return type, means nothing is returned

QCC:
- Why does the number go up until 999999998 and not 999999999?
- How can authenticate() be used as an actual authenticator?
- What steps do we need to take in order to create a functional sign-in page?

*/


public class BankAccount<pinInput> {
    // instance vars
    private String name;
    private String password;
    private int pin;
    private long accNumber;
    private double balance;


    // methods
    public String setFullName(String nameInput){
        return  name = nameInput;
    }

    public String  setPassword(String passwordInput){
        return  password = passwordInput;
    }

    public int setPin(int pinInput){
        checkPinNumber(pinInput); // checks digits
        return  pin = pinInput;
    }

    public void checkPinNumber(int pinInput){
        if (1000 <= pinInput && pinInput <= 9998) {
        } else {
            pin = 9999;
            String errorMsg = "Invalid PIN number. Please retry.";
            System.out.println(errorMsg);
        }
    }

    // sets and checks acc #
    public long setAccNumber(long accInput){
        checkAccNumber(accInput); // checks digits
        return accNumber = accInput;
    }

    // helper function to check whether account # are correct digits
    public void checkAccNumber(long accInput){
        if (100000000 <= accInput && accInput <= 99999998) {
        } else {
            accNumber = 99999999;
            String errorMsg = "Not a valid account number. Please retry.";
            System.out.println(errorMsg);
        }
    }

    // returns acc info
    public String accountInfo(){
        String retStr = "\nAccount info: \n=============";
        retStr += "\nName: " + name;
        retStr = retStr + "\nPassword: " + password;
        retStr = retStr + "\nPIN: " + pin;
        retStr = retStr + "\nAccount Number: " + accNumber;
        retStr = retStr + "\nBalance: " + balance;
        retStr = retStr + "\n=======================";
        return retStr;
    }


    // withdraws amt if PIN & pswrd are both correct
    public boolean withdraw(double amount, int pinInput, String passwordInput){
        if (pinInput == pin && passwordInput == password) {
            if (amount > balance) { // checks for exceeding amounts
                System.out.println("Your amount is invalid. Please retry.");
                return false;
            } else {
                balance -= amount;
                System.out.println("Your new balance is " + balance);
                return true;
            }
        }
        else {
            System.out.println("Invalid PIN or password. Please retry.");
            return false;
        }
    }


    // deposits amt if PIN is correct
    public boolean deposit(double amount, int pinInput){
        if (pinInput == pin){ // requires only PIN to be correct
            if (amount < 0) { // checks for negative amounts
                System.out.println("Your amount is invalid. Please retry.");
                return false;
            } else {
                balance += amount;
                System.out.println("Your new balance is " + balance);
                return true;
            }
        }

        else {
            System.out.println("Invalid PIN. Please retry.");
            return false;
        }
    }


    // deposits amt if pswrd is correct
    public boolean deposit(double amount, String passwordInput){
        if (passwordInput == password){ // requires only psswrd to be correct
            if (amount < 0) {
                System.out.println("Your amount is invalid. Please retry.");
                return false;
            } else {
                balance += amount;
                System.out.println("Your new balance is " + balance);
                return true;
            }
        }

        else {
            System.out.println("Invalid password. Please retry.");
            return false;
        }
    }

    // authenticates acc # and password with params
    public boolean authenticate(long accInput, String psswd){
        if (psswd == password && accInput == accNumber){
            return true;
        } return false;
    }


    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.setFullName("Rich Rick");
        account.setPassword("1234");
        account.setPin(1234);
        account.setAccNumber(123456789);// invoking a method through an object
        // inspired by Team Nacho Patcho

        System.out.println("\nAUTHENTICATION *************************");
        System.out.println(account.authenticate(123456789, "1234"));
        System.out.println("\nACCOUNT *************************");
        System.out.println(account.accountInfo());


        System.out.println("\nDEPOSITING *************************");
        System.out.println("Depositing 100.0... should be 100.0: ");
        account.deposit(100.0, 1234);
        System.out.println("Depositing with negative amount: ");
        account.deposit(-100, "1234");


        System.out.println("\nWITHDRAWING *************************");
        System.out.println("Withdrawing 100.0... should be 0.0: ");
        account.withdraw(100, 1234, "1234");
        System.out.println("Withdrawing with more than you have in your account: ");
        account.withdraw(600, 1234, "1234");


    }
}