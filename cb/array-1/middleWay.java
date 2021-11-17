/***

Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements.


middleWay([1, 2, 3], [4, 5, 6])  [2, 5]
middleWay([7, 7, 7], [3, 8, 0])  [7, 8]
middleWay([5, 2, 9], [1, 4, 5])  [2, 4]
***/

public class middleWay {
	public static int[] middleWay(int[] a, int[] b) {
		int[] result = new int[2];
		result[0] = a[1];
		result[1] = b[1];
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3};
		int[] b = new int[] {4, 5, 6};
		System.out.println( middleWay(a, b) + "   ...should be [2, 5]" );
		int[] c = new int[] {7, 7, 7};
		int[] d = new int[] {3, 8, 0};
		System.out.println( middleWay(c, d) + "   ...should be [7, 8]" );
		int[] e = new int[] {5, 2, 9};
		int[] f = new int[] {1, 4, 5};
		System.out.println( middleWay(e, f) + "   ...should be [2, 4]" );
	}
}
