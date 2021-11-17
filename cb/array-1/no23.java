/***

Given an int array length 2, return true if it does not contain a 2 or 3.


no23([4, 5])  true
no23([4, 2])  false
no23([3, 5])  false

***/

public class no23 {
	public static boolean no23(int[] nums) {
		if ( nums[0] == 2 || nums[1] == 2 )
			return false;
		else if ( nums[0] == 3 || nums[1] == 3 )
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {4, 5};
		System.out.println( no23(a) + "   ...should be true" );
		int[] b = new int[] {4, 2};
		System.out.println( no23(b) + "   ...should be false" );
		int[] c = new int[] {3, 5};
		System.out.println( no23(c) + "   ...should be false" );
	}
}
