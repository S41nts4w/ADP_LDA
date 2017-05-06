package aufgabe6;

public class StartUp {
	public static void main(String[] args) {
		averageCase();
	}

	private static void averageCase() {
		int[] elemente;
		int[] temp;
		Quicksort quickMedian = new Quicksort(1);
		
		int k =6;
		elemente = new int[(int) Math.pow(10, k)];
		temp = new int[elemente.length];
		Befueller.spezialZufaellig(k, elemente);
		Befueller.spezialZufaellig(k, temp);
		
		AddaSort test = new AddaSort();

		test.sort(temp.length, temp);
		
		quickMedian.sortiere(elemente);
		
		
		
				
		System.out.println("Quicksort Aufwand: "+quickMedian.getSchleifenZaehler());
		System.out.println("Quicksort Zeitaufwand: "+quickMedian.getZeitAufwand());
//		System.out.println(test.getAufwand());
		System.out.println("AddaSort Zeitaufwand: "+test.getZeitAufwand());
		System.out.println("AddaSort Aufwand: "+test.getAufwand2());
	}

	private static int[] copyArray(int[] original) {
		int[] result = new int[original.length];

		for (int i = 0; i < original.length; i++) {
			result[i] = original[i];
		}
		return result;
	}
}
