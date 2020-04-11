package it.intersistemi.corsojava.esercizi;
import java.util.*;

public class ProvaMultiKey {

	public static void main(String[] args) {
		Map<ComparableMultiKey<String,Double,Float>, String> mappa=new TreeMap<>();
		mappa.put(new ComparableMultiKey<>("ciao32", 5.3, 3.55f),"valore2");
		mappa.put(new ComparableMultiKey<>("ciao", 5.6, 3.58f),"valore1");
		mappa.put(new ComparableMultiKey<>("ciao32", null, 3.567f),"valore3");
		mappa.put(new ComparableMultiKey<>("ciao3", 5.1, 3.5f),"valore4");
		mappa.put(new ComparableMultiKey<>("ciao3", 5.1, 3.5f),"valore5");
		mappa.put(new ComparableMultiKey<>("ciao5", 5.632, null),"valore6");
		
		Iterator<Map.Entry<ComparableMultiKey<String,Double,Float>,String>> iteratore;
		iteratore=mappa.entrySet().iterator();
		while(iteratore.hasNext()){
			Map.Entry<ComparableMultiKey<String,Double,Float>,String> entry=iteratore.next();
			System.out.println(entry.getKey());
		}
	}

}
