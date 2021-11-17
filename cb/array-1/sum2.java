/***

Given an array of ints, return the sum of the first 2 elements in the array. If the array length is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.


sum2([1, 2, 3])  3
sum2([1, 1])  2
sum2([1, 1, 1, 1])  2

***/

public class sum2 {
	public static int sum2(int[] nums) {
		if ( nums.length == 0 )
			return 0;
		else if ( nums.length == 1 )
			return nums[0];
		else
			return nums[0] + nums[1];
	}

	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3};
		System.out.println( sum2(a) + "   ...should be 3" );
		int[] b = new int[] {1, 1};
		System.out.println( sum2(b) + "   ...should be 2" );
		int[] c = new int[] {1, 1, 1, 1};
		System.out.println( sum2(c) + "   ...should be 2" );
	}
}
