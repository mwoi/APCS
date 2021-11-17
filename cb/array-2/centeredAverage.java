/***

Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.


centeredAverage([1, 2, 3, 4, 100])  3
centeredAverage([1, 1, 5, 5, 10, 8, 7])  5
centeredAverage([-10, -4, -2, -4, -2, 0])  -3

***/

public class centeredAverage {
	public static int centeredAverage(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int sum = 0;
		for ( int x = 0; x < nums.length; x++ ) {
			max = Math.max( nums[x], max );
			min = Math.min( nums[x], min );
			sum += nums[x];
		}
		return ( ( sum - max - min ) / ( nums.length - 2 ) );
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3, 4, 100};
		System.out.println( centeredAverage(a) + "   ...should be 3" );
		int[] b = new int[] {1, 1, 5, 5, 10, 8, 7};
		System.out.println( centeredAverage(b) + "   ...should be 5" );
		int[] c = new int[] {-10, -4, -2, -4, -2, 0};
		System.out.println( centeredAverage(c) + "   ...should be -3" );
	}
}
