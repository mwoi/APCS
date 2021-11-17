/***

Given an array of ints, return a new array length 2 containing the first and last elements from the original array. The original array will be length 1 or more.


makeEnds([1, 2, 3])  [1, 3]
makeEnds([1, 2, 3, 4])  [1, 4]
makeEnds([7, 4, 6, 2])  [7, 2]

***/

public class makeEnds {
	public static int[] makeEnds(int[] nums) {
		int[] result = new int[2];
		result[0] = nums[0];
		result[1] = nums[nums.length - 1];
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3};
		System.out.println( makeEnds(a) + "   ...should be {1, 3}" );
		int[] b = new int[] {1, 2, 3, 4};
		System.out.println( makeEnds(b) + "   ...should be {1, 4}" );
		int[] c = new int[] {7, 4, 6, 2};
		System.out.println( makeEnds(c) + "   ...should be {7, 2}" );
	}
}
