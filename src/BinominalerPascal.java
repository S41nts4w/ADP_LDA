import java.util.ArrayList;

public class BinominalerPascal implements Pascal {
	private long zaehler;
	private ArrayList<Long> faku;

	public BinominalerPascal() {
		faku = new ArrayList<Long>();
		zaehler = 0;
	}

	public long[] berechnePascalschesDreieck(int n) {
		if (n > 0) {
			long[] dreieckzeile = new long[n];
			n--;
			long nfakultaet = getFakultaetvon(n);

			for (int k = 0; k <= n / 2; k++) {
				zaehler++;
				dreieckzeile[k] = nfakultaet / (getFakultaetvon(k) * getFakultaetvon(n - k));

				dreieckzeile[n - k] = dreieckzeile[k];
			}

			return dreieckzeile;
		} else {
			throw new IllegalArgumentException("Keine Zeile <= 0 erlaubt!");
		}
	}

	protected long getFakultaetvon(int zahl) {
		if (zahl < 0) // Fehlerfall eingabe ist ungueltig
		{
			return -1;
		}

		if (faku.size() - 1 < zahl) // fakultaet muss noch berechnet werden
		{
			if (zahl == 0) // 0! ist definiert als 1
			{
				faku.add(zahl, (long) 1);
			} else
			// Fakultaet muss berechnet werden (0! ist
			// definiert
			// als
			// 1)
			{
				for (int i = faku.size(); i <= zahl; i++) {
					if (i == 0) {
						faku.add(i, (long) 1);
					} else {
						zaehler++;
						long temp = i * faku.get(i - 1);
						faku.add(i, temp);
					}
				}
			}
		}
		return faku.get(zahl);
	}

	public long getZaehler() {
		return zaehler;
	}

	public void setZaehler(long zaehler) {
		zaehler = zaehler;
	}

}
