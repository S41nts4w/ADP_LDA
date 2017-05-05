package aufgabe6;

public class StartUp {
	public static void main(String[] args) {
		averageCase();
	}

	private static void averageCase() {
		int[] elemente;
		int[] temp;
		Quicksort quickMedian = new Quicksort(1);
		Quicksort quickRandom = new Quicksort(2);
		Quicksort quickLast = new Quicksort(3);

		for (int n = 10; n <= 10000; n *= 10) {

			elemente = new int[n];
			Befueller.fuelleZufaellig(elemente);

			temp = copyArray(elemente);

			quickMedian.setSchleifenZaehler(0);
			quickMedian.sortiere(temp);

			temp = copyArray(elemente);

			quickRandom.setSchleifenZaehler(0);
			quickRandom.sortiere(temp);

			temp = copyArray(elemente);

			quickLast.setSchleifenZaehler(0);
			quickLast.sortiere(temp);

			System.out.println("Problemgöße n: " + n + "\nMedianSchleife: "
					+ quickMedian.getSchleifenZaehler() + "\nRandomSchleife: " + quickRandom.getSchleifenZaehler()
					+ "\nLastSchleife: " + quickLast.getSchleifenZaehler());
		}
	}

	private static int[] copyArray(int[] original) {
		int[] result = new int[original.length];

		for (int i = 0; i < original.length; i++) {
			result[i] = original[i];
		}
		return result;
	}
}
