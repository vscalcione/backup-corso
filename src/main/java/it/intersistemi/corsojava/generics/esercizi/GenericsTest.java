package it.intersistemi.corsojava.generics.esercizi;

import java.util.List;

public class GenericsTest {
	
	

	public static void main(String[] args) {
		
		List<?> ciaoone = new ArrayList<String>();
		List<?> ciaoneTwo = new ArrayList<Number>();
		List<?> ciaoneThree = new ArrayList<Number>();
		List<?> ciaoneFour = new ArrayList<Number>();
		
		List<Number>ciaoone = new ArrayList<String>();
		ciaoone.add('c');
		ciaoone.add('1');
		ciaoone.add('a');
		ciaoone.add('o');
		
		
		List<Number>ciaoneTwo = new ArrayList<Number>();
		ciaoneTwo.add('')
		ciaoneTwo.add()
		ciaoneTwo.add()
		ciaoneTwo.add()
		
		stampa(ciaoone);
		stampa(ciaoneTwo);
		stampa(ciaoneThree);
		stampa(ciaoneFour);
		
		List<Number>ciaoneThree = new ArrayList<String>();
		ciaoone.add('c');
		ciaoone.add('1');
		ciaoone.add('a');
		ciaoone.add('o');
		
		List<Number>ciaoneFour = new ArrayList<String>();
		ciaoone.add('c');
		ciaoone.add('1');
		ciaoone.add('a');
		ciaoone.add('o');
		
		List<Number>ciaoneFive = new ArrayList<String>();
		ciaoone.add('c');
		ciaoone.add('1');
		ciaoone.add('a');
		ciaoone.add('o');

	}
	
	private static void Stampa(List<?> ciaoone) {
		for(Object object : ciaoone) {
			if(Object instanceof String) {
				System.out.println("Stampo la String: "+object);
			}else if(object instanceof Number) {
				
			}
		}
	}

}
