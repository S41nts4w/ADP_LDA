package aufgabe6;

public class AddaSort {
	private int aufwandszaehler;
	
	public int[] sortiere(int[]liste){
		int n = liste.length;
		int [] swap = new int[100*n];
		int [] output = new int[n];
		int j=0;
		for(int i=0; i<n; i++){
			swap[liste[i]-700*n] += 1;
		}
		for(int i = 0; i<swap.length;i++){
			while(swap[i]>0){
				output[j]=i+700*n;
				j++;
				swap[i]--;
				if(j==n){
					return output;
				}
			}
		}
		return output;
	}

}
