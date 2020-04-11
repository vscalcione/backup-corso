package it.intersistemi.corsojava.generics.esempi;

import java.util.HashMap;
import java.util.Map;

public class MultiChiave <K1,K2,K3> { 

	private K1 key1;
    private K2 key2;
	private K3 key3;


	public  MultiChiave (K1 key1, K2 key2, K3 key3) {
		if (key1==null) {
			
			throw new IllegalArgumentException ("almeno la prima chiave valore deve essere diversa da zero");
		}
		
		this.key1 = key1;
		this.key2 = key2;
		this.key3 = key3;
	}
	
	
	public K1 getKey1() {
		return key1;
	}



	public K2 getKey2() {
		return key2;
	}



	public K3 getKey3() {
		return key3;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key1 == null) ? 0 : key1.hashCode());
		result = prime * result + ((key2 == null) ? 0 : key2.hashCode());
		result = prime * result + ((key3 == null) ? 0 : key3.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) { //non potremmo chiamare metodi senza castare almeno ad object
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		MultiChiave <K1,K2,K3> other = (MultiChiave <K1,K2,K3>)  obj;
		if (key1 == null) {
			if (other.key1 != null)
				return false;
		} else if (!key1.equals(other.key1))
			return false;
		if (key2 == null) {
			if (other.key2 != null)
				return false;
		} else if (!key2.equals(other.key2))
			return false;
		if (key3 == null) {
			if (other.key3 != null)
				return false;
		} else if (!key3.equals(other.key3))
			return false;
		return true;
	}




	

   public static <T1,T2,T3> MultiChiave<T1,T2,T3> valueOf(T1 key1,T2 key2,T3 key3)
   { return new MultiChiave<>( key1, key2, key3 ); //key1, key2, key3
   }



	public static void main(String[] args) {
		
		Map<MultiChiave<Integer,String,Double>, String> multiChiaveMap = new HashMap<>();
		
		multiChiaveMap.put(new MultiChiave< Integer ,String , Double>(30,"ciao",4.56), "ciccio");

		String valore = multiChiaveMap.get(MultiChiave.valueOf(30, "ciao", 4.56));
		
		System.out.println(valore);
	}

}
