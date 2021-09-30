public class Time{
	public static void main(String[] args){
		
		double secondsInDay = 24 * 60 * 60;
		double hour = 15, minute = 36, second = 4;
		double timeInSeconds = hour * 60 * 60 + minute * 60 + second;
		double timeLeftInDay = secondsInDay - timeInSeconds;
		double percentPassed = timeInSeconds / secondsInDay * 100;
		
		System.out.println("Number of seconds since midnight: " + timeInSeconds);
		System.out.println("Number of seconds remaining in the day: " + timeLeftInDay);
		System.out.println("Percent of the day that has passed: " + percentPassed + "%");
		
	}
}