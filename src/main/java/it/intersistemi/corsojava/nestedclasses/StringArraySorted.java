package it.intersistemi.corsojava.nestedclasses;

import java.util.Arrays;
import java.util.Comparator;

public class StringArraySorted {
	public static void main(String[] args) {
		String[] stringArray = {"aa","bbb","cccc","yyyyy","rrrrrr","zzzzzzz"};
		System.out.println("Array originario: ");
		printArray(stringArray);
		Arrays.sort(stringArray);
		System.out.println("==========================");
		System.out.println("Array ordinato alfabeticamente: ");
		printArray(stringArray);
		System.out.println("==========================");
		System.out.println("2a tipologia di ordinamento");
		Arrays.sort(stringArray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		printArray(stringArray);
		System.out.println("==========================");
		System.out.println("3a tipologia di ordinamento");
		Arrays.sort(stringArray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		printArray(stringArray);
	}

	private static void printArray(String[] stringArray) {
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print(stringArray[i]+" , ");
		}
		System.out.println("");
	}
}
