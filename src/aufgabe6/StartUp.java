package aufgabe6;

public class StartUp {
	public static void main(String[] args) {
		averageCase();
	}

	private static void averageCase() {
		int[] elemente;
		int[] temp;
		Quicksort quickMedian = new Quicksort(1);
		
		int k =1;
		elemente = new int[(int) Math.pow(10, k)];
		temp = new int[(int) Math.pow(10, k)];
		Befueller.spezialZufaellig(k, elemente);
		Befueller.spezialZufaellig(k, temp);
		
		AddaSort test = new AddaSort();
//		temp = test.sortiere(elemente);
		
//		for(int i= 0;i<temp.length;i++){
//			System.out.println(temp[i]);
//		}
		
		test.radixsort(temp, (int)Math.pow(10, k));
		for(int i= 0;i<temp.length;i++){
			System.out.println(temp[i]);
			
		}
		
		quickMedian.sortiere(elemente);
		
		
		
				
		System.out.println(quickMedian.getSchleifenZaehler());
		System.out.println(quickMedian.getZeitAufwand());
//		System.out.println(test.getAufwand());
		System.out.println(test.getZeitAufwand());
		System.out.println(test.getAufwand2());
	}

	private static int[] copyArray(int[] original) {
		int[] result = new int[original.length];

		for (int i = 0; i < original.length; i++) {
			result[i] = original[i];
		}
		return result;
	}
}
