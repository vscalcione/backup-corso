package it.intersistemi.corsojava.array;

import java.util.Random;

public class ArrayMain {

	public static void main(String[] args) {
		Random rndValue = new Random();
		int [] array1 = new int[10];
		int [] array2 = new int[10];
		int []newArray = new int[array1.length * 2];
		if(array1.length == array2.length) {
			for(int index = 0; index<array1.length; index++) {
				array1[index]=rndValue.nextInt(10);
				System.out.print(array1[index]);
				System.out.println("");
				array2[index]=array1[index];
				
				System.out.print(" "+array2[index]);
				newArray[index]=array1[index];
				System.out.print(" "+newArray[index]);
//				newArray[index]=array1[index];
//				array1[index] = array2[index];
//				System.out.println(newArray[index]);
			}
			
		}
	}
}
