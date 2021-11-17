/***

Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2.


double23([2, 2])  true
double23([3, 3])  true
double23([2, 3])  false

***/

public class double23 {
	public static boolean double23(int[] nums) {
		if ( nums.length != 2 )
			return false;
		else if ( nums[0] == nums[1] )
			return ( nums[0] == 2 ) || ( nums[0] == 3 );
		else
			return false;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 2};
		System.out.println( double23(a) + "   ...should be true" );
		int[] b = {3, 3};
		System.out.println( double23(b) + "   ...should be true" );
		int[] c = {2, 3};
		System.out.println( double23(c) + "   ...should be false" );
	}
}
