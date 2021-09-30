public class Methods{
	public static boolean isDivisible(int n, int m){
		return ( n % m == 0 && m != 0 );
	}

	public static boolean isTriangle(int a, int b, int c){
		return ( a < (b + c) && b < (a + c) && c < (a + b) );
	}

	public static int ack(int m, int n){
		if ( m == 0 ){
			return ( n + 1 );
		} else if ( m > 0 && n == 0 ) {
			return ack( m - 1, 1 );
		} else if ( m > 0 && n > 0 ) {
			return ack( m - 1, ack( m, n - 1 ) );
		} else{
			return 0;
		}
	}
}