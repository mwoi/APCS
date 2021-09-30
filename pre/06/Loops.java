public class Loops{
	public static double power(double x, int n){
		double r = x;
		for ( int i = 1; i < n; i++ ){
			r *= x;
		}
		return r;
	}

	public static int factorial(int n){
		if ( n == 0 ){
			return 1;
		} else{
			int r = n;
			for ( int i = 1; i <= n; i++ ){
				r *= i;
			}
			return r;
		}
	}

	public static double myexp(double x, int n){
		double r = 1;
		double numer = 1;
		double denom = 1;
		for ( int i = 1; i < n; i++ ){
			r += ( ( numer *= x ) / ( denom *= n ) );
		}
		return r;
	}
	
}