package aufgabe6;

import java.util.Arrays;

public class AddaSort {
	private int aufwandszaehler;
	private int aufwandszaehler2;
	long zeit1;
	long zeit2;

	public int[] sortiere(int[] liste) {
		zeit1 = System.nanoTime();
		int n = liste.length;
		int[] swap = new int[100 * n];
		int[] output = new int[n];
		int j = 0;
		for (int i = 0; i < n; i++) {
			swap[liste[i] - 700 * n] += 1;
			aufwandszaehler++;
		}
		int addierer = 0;
		for (int i = 0; i < swap.length; i++) {
			aufwandszaehler++;
			swap[i] += addierer;
			addierer = swap[i];
		}

		for (int i = 0; i < n; i++) {
			aufwandszaehler++;
			output[swap[liste[i] - (700 * n)] - 1] = liste[i];
			swap[liste[i] - 700 * n]--;
		}

		// for (int i = 0; i < swap.length; i++) {
		// while (swap[i] > 0) {
		// aufwandszaehler++;
		// output[j] = i + 700 * n;
		// j++;
		// swap[i]--;
		// if (j == n) {
		// zeit2 = System.nanoTime();
		// return output;
		// }
		// }
		// }
		zeit2 = System.nanoTime();
		return output;
	}

	private void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
//		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++) {
			aufwandszaehler2++;
			count[(arr[i] / exp) % 10]++;
		}

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			aufwandszaehler2++;
			count[i] += count[i - 1];
		}

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			aufwandszaehler2++;
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
		for (i = 0; i < n; i++) {
			aufwandszaehler2++;
			arr[i] = output[i];
		}
	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	public void radixsort(int arr[]) {
		zeit1 = System.nanoTime();
		// Find the maximum number to know number of digits
		int n = arr.length;
		int m = 10 * n;

		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 100; m / exp > 0; exp *= 10) {
			aufwandszaehler2++;
			countSort(arr, n, exp);
		}
		zeit2 = System.nanoTime();
	}
	
	public void sort(int n,int arr[]){
		zeit1 = System.nanoTime();
        int[] output = new int[n];
        int mod = 7*n;
        for(int i = 0; i < arr.length;i++){
            int index =(arr[i]/100)%mod;
            output[index] = arr[i];
            aufwandszaehler2++;
        }
        arr=output;
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
