
public class IterativerPascal implements Pascal {

	private long zaehler;

	public long[] berechnePascalschesDreieck(int zeile) {
		long[][] pascal = new long[zeile][zeile + 2];
		long result;

		pascal[0][1] = 1;

		for (int reihe = 1; reihe < zeile; reihe++) {
			zaehler++;
			for (int spalte = 1; spalte < zeile + 2; spalte++) {
				zaehler++;
				result = pascal[reihe - 1][spalte] + pascal[reihe - 1][spalte - 1];
				pascal[reihe][spalte] = result;
				if (result == 0) {
					break;
				}
			}
		}

		return pascal[zeile - 1];
	}

	public long getZaehler() {
		return zaehler;
	}

	public void setZaehler(long zaehler) {
		this.zaehler = zaehler;
	}

}
