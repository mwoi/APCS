/***

Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.


countEvens([2, 1, 2, 3, 4])  3
countEvens([2, 2, 0])  3
countEvens([1, 3, 5])  0

***/

public class countEvens {
	public static int countEvens(int[] nums) {
		int result = 0;
		for ( int x = 0; x < nums.length; x++ ) {
			if ( nums[x] % 2 == 0 )
				result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {2, 1, 2, 3, 4};
		System.out.println( countEvens(a) + "   ...should be 3" );
		int[] b = new int[] {2, 2, 0};
		System.out.println( countEvens(b) + "   ...should be 3" );
		int[] c = new int[] {1, 3, 5};
		System.out.println( countEvens(c) + "   ...should be 0" );
	}
}
