package aufgabe6;

import java.util.Random;

public class Befueller {

	/**
	 * Füllt gegebenes Element[] mit den Werten von 1 bis elemente.length in
	 * zufälliger Reihenfolge.
	 * 
	 * @param elemente
	 */
	public static void fuelleZufaellig(int[] elemente) {
		fuelleSortiert(elemente);
		int index, temp;
		Random random = new Random();
		for (int i = elemente.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = elemente[index];
			elemente[index] = elemente[i];
			elemente[i] = temp;
		}
	}

	/**
	 * Füllt gegebenes Element[] mit den Werten von 1 bis elemente.length in
	 * aufsteigender Reihenfolge.
	 * 
	 * @param elemente
	 */
	public static void fuelleSortiert(int[] elemente) {
		for (int i = 0; i < elemente.length; i++) {
			elemente[i] = i + 1;
		}
	}

	/**
	 * Füllt gegebenes Element[] mit den Werten von 1 bis elemente.length in
	 * absteigender Reihenfolge.
	 * 
	 * @param elemente
	 */
	public static void fuelleUmgekehrtSortiert(int[] elemente) {
		int j = elemente.length - 1;
		for (int i = 1; i <= elemente.length; i++) {
			elemente[j] = i + 1;
			j--;
		}
	}

	/**
	 * Füllt gegebenes Element[] mit den Werten von 1 bis elemente.length in
	 * alternierender Reihenfolge. => 1, N, 2, N-1, 3, N-2 ... :N =
	 * elemente.length
	 * 
	 * @param elemente
	 */
	public static void fuelleAlternierend(int[] elemente) {
		for (int i = 0; i < elemente.length; i++) {
			if (i % 2 == 0) {
				elemente[i] = i + 1;
			} else {
				elemente[i] = elemente.length - i + 1;
			}
		}
	}

	private static void spezialBefuellt(int k, int[] elemente) {
		int beginning = 700 * (int) Math.pow(10, k);
		for (int i = 0; i < elemente.length; i++) {
			elemente[i] = (int) (beginning + (100 * i) + (Math.random() * 100));
		}
	}

	public static void spezialZufaellig(int k, int[] elemente) {
		spezialBefuellt(k, elemente);
		int index, temp;
		Random random = new Random();
		for (int i = elemente.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = elemente[index];
			elemente[index] = elemente[i];
			elemente[i] = temp;
		}
	}

}
