package aufgabe6;

public class Quicksort
{
	int aufwandsZaehler;
	private int[] array;
    private int length;
    private int pivotModus;
	
	/**
	 * Sortiert gegebenes Element[] in aufsteigender Reihenfolge. 
	 * 
	 * @param elemente
	 * @param modus 1 : Pivot = Median of Three | 2 : Pivot = Random | Rest : Pivot = Last
	 */
    public Quicksort(int pivotModus){
    	this.pivotModus = pivotModus;
    }
    
	public void sortiere(int[] liste)
	{
		if (liste == null || liste.length == 0) {
            return;
        }
        this.array = liste;
        length = liste.length;
        quickSort(0, length - 1);
	}
	 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = erzeugePivot(array, lowerIndex, higherIndex);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
            	aufwandsZaehler++;
                i++;
            }
            while (array[j] > pivot) {
            	aufwandsZaehler++;
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
                aufwandsZaehler+=2;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	public void print(int[] liste)
	{
		for(int i = 0; i < liste.length; i++)
		{
			System.out.print(liste[i] + " | ");
			
		}
		System.out.println();
	}

	private int erzeugePivot(int[] liste, int links, int rechts)
    {
    	int pivot;
    	int first = liste[links];
		int middle = liste[links+((rechts-links)/2)];
		int last = liste[rechts];
		
    	if(pivotModus == 1)
    	{
    		pivot = Math.max(Math.min(first,middle), 
                    Math.min(Math.max(first,middle),last));
    		
    		return pivot;
    	}
    	else if(pivotModus == 2)
    	{
    		pivot = first + (int)(Math.random()*(last-first)+1);
    		return pivot;
    	}
    	else{
    		return first;
    	}
    }
	
	public int getSchleifenZaehler()
	{
		return aufwandsZaehler;
	}
	
	public void setSchleifenZaehler(int zaehler)
	{
		aufwandsZaehler = zaehler;
	}
}