public class Aufwandsanalyse {

	public static void main(String[] args) {

		Pascal pascal;
		for (int zeile = 1; zeile < 22; zeile += 1) {
			System.out.println("\n ######## ZEILE : " + zeile + " #######");

			pascal = new BinominalerPascal();
			System.out.print("Binominal");
			aufwandsAnalyse(pascal, zeile);

			pascal = new IterativerPascal();
			System.out.print("Iterativ");
			aufwandsAnalyse(pascal, zeile);

			pascal = new RekusiverPascal();
			System.out.print("Rekursiv");
			aufwandsAnalyse(pascal, zeile);
		}
		
		

	}

	private static void aufwandsAnalyse(Pascal pascal, int zeile) {

		long[] result = pascal.berechnePascalschesDreieck(zeile);

		printArray(result);

		System.out.println(" : " + pascal.getZaehler());
		pascal.setZaehler(0);
	}

	public static void printArray(long[] array) {
		for (int spalte = 0; spalte < array.length; spalte++) {
			if (array[spalte] != 0) {
				System.out.print(array[spalte] + "|");
			}
		}
	}
}
