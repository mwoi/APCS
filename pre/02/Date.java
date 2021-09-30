public class Date{
	public static void main(String[] args){
		String day = "Saturday";
		int date = 11;
		String month = "September";
		int year = 2021;

		System.out.println("American format:");
		System.out.println(day + ", " + month + " " + date + ", " + year);

		System.out.println("European format:");
		System.out.println(day + " " + date + " " + month + " " + year);
	}
}