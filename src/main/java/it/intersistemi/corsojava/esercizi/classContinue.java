package it.intersistemi.corsojava.esercizi;

public class classContinue {
	public static void main(String[] args) {
		int res = 0;
		for (int i = 0,j = 5; i<5; i++,j--) {
			if (i == 3) {
			//continue;
			}
			res += i+j;
			System.out.println(res);
	    }
	}
}
