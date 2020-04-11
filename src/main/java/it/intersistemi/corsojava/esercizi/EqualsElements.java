package it.intersistemi.corsojava.esercizi;

public class EqualsElements {
	public static void main(String[] args){
		int[] array1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] array2 = new int[] {2, 11, 4, 13, 6, 15, 8, 17, 10, 19};
		System.out.println("Elementi uguali in entrambi gli array: ");
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if(array1[i] == array2[j]) {
					System.out.print(array1[i]+" ");
				}
			}
		}
		
	}
}
