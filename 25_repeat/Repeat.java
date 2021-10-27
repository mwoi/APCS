/*
Nina Jiang + Marcus Wu + Kevin Cheng
APCS
HW25 -- Do I repeat myself?
2021-10-27
time spent: 0.7
DISCO: n/a
Q/C/C: n/a
*/

public class Repeat {
	public static String fenceW(int numPosts) {
		int x = numPosts;
		String result = "|";
		while (1 < x) {
			result += "--|";
			x--;
		}
		return result;
	}

	public static String fenceR(int numPosts) {
		if (numPosts == 1) {
			return "|";
		} else {
			return fenceR(numPosts - 1) + "--|";
		}
	}

	public static void main(String[] args) {
		System.out.println(fenceW(3));
		System.out.println(fenceR(3));
	}
}