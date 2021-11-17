/***

Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.


rotateLeft3([1, 2, 3])  [2, 3, 1]
rotateLeft3([5, 11, 9])  [11, 9, 5]
rotateLeft3([7, 0, 0])  [0, 0, 7]

***/

public class rotateLeft3 {
	public static int[] rotateLeft3(int[] nums) {
		int[] result = new int[3];
		result[0] = nums[1];
		result[1] = nums[2];
		result[2] = nums[0];
		return result;  
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3};
		System.out.println( rotateLeft3(a) + "   ...should be [2, 3, 1]" );
		int[] b = new int[] {5, 11, 9};
		System.out.println( rotateLeft3(b) + "   ...should be [11, 9, 5]" );
		int[] c = new int[] {7, 0, 0};
		System.out.println( rotateLeft3(c) + "   ...should be [0, 0, 7]" );
	}
}
