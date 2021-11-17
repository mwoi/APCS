/***

Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.


bigDiff([10, 3, 5, 6])  7
bigDiff([7, 2, 10, 9])  8
bigDiff([2, 10, 7, 2])  8

***/

public class bigDiff {
	public static int bigDiff(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		for ( int x = 0; x < nums.length; x++ ) {
			max = Math.max( nums[x], max );
			min = Math.min( nums[x], min );
		}
		return ( max - min );
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {10, 3, 5, 6};
		System.out.println( bigDiff(a) + "   ...should be 7" );
		int[] b = new int[] {7, 2, 10, 9};
		System.out.println( bigDiff(b) + "   ...should be 8" );
		int[] c = new int[] {2, 10, 7, 2};
		System.out.println( bigDiff(c) + "   ...should be 8" );
	}
}
