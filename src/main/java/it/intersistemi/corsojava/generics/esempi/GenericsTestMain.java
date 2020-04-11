package it.intersistemi.corsojava.generics.esempi;

import java.util.ArrayList;
import java.util.List;

public class GenericsTestMain {
	public static void main(String[] args) {
		List<String> listOne = new ArrayList<String>();
		listOne.add("String1");
		listOne.add("String2");
		listOne.add("String3");
		listOne.add("String4");
		listOne.add("String5");
		
		List<Number> listTwo = new ArrayList<Number>();
		listTwo.add(1);
		listTwo.add(2);
		listTwo.add(3.0);
		listTwo.add(4.3f);
		listTwo.add(15.3);
		
		List<Double> listThree = new ArrayList<Double>();
		listThree.add(3.9);
		listThree.add(1.2);
		listThree.add(6.2);
		listThree.add(5.7);
		listThree.add(4.3);
		
		List<Boolean> listFour = new ArrayList<Boolean>();
		listFour.add(true);
		listFour.add(false);
		listFour.add(true);
		listFour.add(Boolean.FALSE);
		listFour.add(Boolean.TRUE);
		
		List<Character> listFive = new ArrayList<Character>();
		listFive.add('c');
		listFive.add('i');
		listFive.add('a');
		listFive.add('o');
		listFive.add('!');

		System.out.println("==== Stampa listOne ===========================");
		stampa(listOne);
		System.out.println("==== Stampa listTwo ===========================");
		stampa(listTwo);
		System.out.println("==== Stampa listThree ===========================");
		stampa(listThree);
		System.out.println("==== Stampa listFour ===========================");
		stampa(listFour);
		System.out.println("==== Stampa listFive ===========================");
		stampa(listFive);

	}
	
	public static void stampa(List<?> lista) {
		for (Object object : lista) {
			if(object instanceof String) {
//				System.out.println("");
				System.out.println("Stampo la stringa: "+object);
			}else if(object instanceof Number) {
//				System.out.println("");
				System.out.println("Stampo il number: "+object);
			}else if(object instanceof Double) {
				System.out.println("Stampo il double: "+object);
			}else if(object instanceof Boolean) {
				System.out.println("Stampo il boolean : "+object);
			}
			else {
//				System.out.println("");
				System.out.println("Stampo generic ?: "+object);
			}
		}
	}
}