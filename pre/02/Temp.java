import java.util.Scanner;

public class Temp{
	public static void main(String[] args){
		double celsius;
		Scanner in = new Scanner(System.in);
		
		System.out.print("What is the temperature in Celsius? ");
		celsius = in.nextDouble();
		double fahrenheit = celsius * 9 / 5 + 32; 
		
		System.out.printf("%.1f celsius = %.1f fahrenheit", celsius, fahrenheit);
	}
}