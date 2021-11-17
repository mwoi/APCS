/***

Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal.


sameFirstLast([1, 2, 3])  false
sameFirstLast([1, 2, 3, 1])  true
sameFirstLast([1, 2, 1])  true

***/

public class sameFirstLast {
	public static boolean sameFirstLast(int[] nums) {
		return ( nums.length > 0 ) && ( nums[0] == nums[nums.length - 1] );
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3};
		System.out.println( sameFirstLast(a) + "   ...should be false" );
		int[] b = new int[] {1, 2, 3, 1};
		System.out.println( sameFirstLast(b) + "   ...should be true" );
		int[] c = new int[] {1, 2, 1};
		System.out.println( sameFirstLast(c) + "   ...should be true" );
	}
}
