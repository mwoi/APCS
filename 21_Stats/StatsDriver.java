public class StatsDriver {

	public static void main(String[] args) {
		
		System.out.println(Stats.mean(2, 18) + "\nShould return 10\n");
		System.out.println(Stats.mean(1, 0) + "\nShould return 0\n");
		
		System.out.println(Stats.mean(1.0, 0.0) + "\nShould return 0.5\n");
		System.out.println(Stats.mean(6.0, 7.0938749) + "\nShould return 6.54693745\n");

		System.out.println(Stats.max(1, -2) + "\nShould return 1\n");

		System.out.println(Stats.max(1.1, 1.0111111) + "\nShould return 1.1\n");

		System.out.println(Stats.geoMean(-4, -9) + "\nShould return 6\n");

		System.out.println(Stats.geoMean(230.0, 934.76) + "\nShould return 463.675317436673568726\n");
	}
}