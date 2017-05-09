package aufgabe6;

import java.util.Arrays;

public class AddaSort {
	private int aufwandszaehler;
	private int aufwandszaehler2;
	long zeit1;
	long zeit2;

	// Der Counting-Sort, der das Array nach einer bestimmten Stelle Soritert,
	// aufgerufen vom RadixSort
	static int counter = 0;

	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Ursprungswert / die gesuchte Stelle Modulo 10 (Wegschneiden der
		// stellen davor und dahinter) -> gesuchter Index
		for (i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
			counter++;
		}

		// Hochzählen der count Stellen um die echte Position herzustellen fuer
		// das Output Array
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
			counter++;
		}

		// Fuellen des zwischen-Arrays am Index der erzeugt wird, durch den
		// Ursprungswert / die gesuchte Stelle Modulo 10 (Wegschneiden der
		// stellen davor und dahinter)
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
			counter++;
		}

		// Uebertragen des erstellten Arrays auf das Ursprungs Array
		for (i = 0; i < n; i++) {
			arr[i] = output[i];
			// counter++;
		}
	}

	// Radix Sort Algortihmus, fuehrt den Counting-Sort intern auf bestimmte
	// Stellen aus
	static void radixsort(int arr[], int n) {
		// Beschränkung auf die gesuchte Stelle im Counting Sort
		int m = n * 10;

		// Uebergibt die Aktuell durchsuchte Stelle (exp) fuer den Counting Sort
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(arr, n, exp);
			counter++;
		}
	}

	// Ausdrucken von Arrays
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// einfache einordnung am Index Alternativer unsicherer Algortihmus
	public void sort(int n, int arr[]) {
		zeit1 = System.nanoTime();
		int[] output = new int[n];
		int mod = 7 * n;
		for (int i = 0; i < arr.length; i++) {
			int index = (arr[i] / 100) % mod;
			output[index] = arr[i];
			aufwandszaehler2++;
		}
		arr = output;
		zeit2 = System.nanoTime();
	}

	public long getZeitAufwand() {
		return zeit2 - zeit1;
	}

	public int getAufwand() {
		return aufwandszaehler;
	}

	public int getAufwand2() {
		return aufwandszaehler2;
	}

}
