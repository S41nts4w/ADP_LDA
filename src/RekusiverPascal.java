public class RekusiverPascal implements Pascal {

	private long zaehler;

	public long[] berechnePascalschesDreieck(int zeile) {
		long[] pascal = new long[zeile];

		for (int reihe = 0; reihe < zeile; reihe++) {
			zaehler++;
			pascal[reihe] = function_pascal(zeile - 1, reihe);

		}

		return pascal;
	}

	private long function_pascal(int zeile, int spalte) {
		if (spalte == 0 || spalte == zeile) {
			return 1;
		}
		zaehler++;
		return function_pascal(zeile - 1, spalte) + function_pascal(zeile - 1, spalte - 1);
	}

	public long getZaehler() {
		return zaehler;
	}

	public void setZaehler(long zaehler) {
		zaehler = zaehler;
	}

}
