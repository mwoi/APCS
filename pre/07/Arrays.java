public static double powArray(double[] a, double b){
	for (int i = 0; i < a.length; i++){
		a[i] = Math.pow(a[i], b);
	}
	return a;
}

public static int histogram(int[] a, int b){
	int[] counters = new int[b];
	for (int i = 0; i < a.length; i++){
		int index = a[i];
		counters[index]++;
	}
	return counters;
}



public static int indexOfMax(int[] a){
	int indexHighest = 0;
	for (i = 0; i < a.length; i++){
		if (a[i] > indexHighest){
			indexHighest = i;
		}
	}
	return indexHighest
}