/***

Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.


sum13([1, 2, 2, 1])  6
sum13([1, 1])  2
sum13([1, 2, 2, 1, 13])  6

***/

public class sum13 {
	public static int sum13(int[] nums) {
		int sum = 0;
		for ( int x = 0; x < nums.length; x++) {
			if ( nums[x] == 13 )
				x++;
			else
				sum += nums[x];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 2, 1};
		System.out.println( sum13(a) + "   ...should be 6" );
		int[] b = new int[] {1, 1};
		System.out.println( sum13(b) + "   ...should be 2" );
		int[] c = new int[] {1, 2, 2, 1, 13};
		System.out.println( sum13(c) + "   ...should be 6" );
	}
}
