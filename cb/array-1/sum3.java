/***

Given an array of ints length 3, return the sum of all the elements.


sum3([1, 2, 3])  6
sum3([5, 11, 2])  18
sum3([7, 0, 0])  7

***/

public class sum3 {
	public static int sum3(int[] nums) {
		return ( nums[0] + nums[1] + nums[2] );
	}

	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3};
		System.out.println( sum3(a) + "   ...should be 6" );
		int[] b = new int[] {5, 11, 2};
		System.out.println( sum3(b) + "   ...should be 18" );
		int[] c = new int[] {7, 0, 0};
		System.out.println( sum3(c) + "   ...should be 7" );
	}
}
