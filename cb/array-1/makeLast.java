/***

Given an int array, return a new array with double the length where its last element is the same as the original array, and all the other elements are 0. The original array will be length 1 or more. Note: by default, a new int array contains all 0's.


makeLast([4, 5, 6])  [0, 0, 0, 0, 0, 6]
makeLast([1, 2])  [0, 0, 0, 2]
makeLast([3])  [0, 3]

***/

public class makeLast {
	public static int[] makeLast(int[] nums) {
		int[] result = new int[nums.length * 2];
		result[result.length - 1] = nums[nums.length - 1];
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {4, 5, 6};
		System.out.println( makeLast(a) + "   ...should be [0, 0, 0, 0, 0, 6]" );
		int[] b = new int[] {1, 2};
		System.out.println( makeLast(b) + "   ...should be [0, 0, 0, 2]" );
		int[] c = new int[] {3};
		System.out.println( makeLast(c) + "   ...should be [0, 3]" );
	}
}
