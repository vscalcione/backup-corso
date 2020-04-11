package it.intersistemi.corsojava.generics.esempi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CreatoreArray {

	
	
	public static <T> List <T> arrayToList(T[] elementi){
		
		List<T> lista = new ArrayList<T>();
		for (T elemento : elementi) {
			lista.add(elemento);
		}
		return lista;
	}
	
	
	public static <T> T[] listToArray (Class<T> clazz, List<T> lista) {
		
		@SuppressWarnings("unchecked")// zittire warning
		T[]  array = (T[]) Array.newInstance(clazz, lista.size()); //(T[]) new Object [lista.size()] ;
		ListIterator<T> listIt = lista.listIterator();
		while (listIt.hasNext()) {
			int index = listIt.nextIndex();
			array[index] = listIt.next();
			
		}
		return  array   ;
	}
	

	
	
	
	public static void main(String[] args) {
		
       String[] stringhe = {"1", "2"};
		
		List<String> listaDiStringhe = arrayToList (stringhe);
		
		System.out.println(listaDiStringhe);
		
		
		stringhe= listToArray(String.class, listaDiStringhe);
		
		for(int i=0;i<stringhe.length; i++) {
			
			System.out.println(stringhe[i]);
		}
	}

}
