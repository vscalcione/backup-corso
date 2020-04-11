package it.intersistemi.corsojava.esercizi;

public class MultiKey<K1,K2,K3>{
	private K1 chiave1;
	private K2 chiave2;
	private K3 chiave3;
	
	public MultiKey(K1 chiave1, K2 chiave2, K3 chiave3){
		if(chiave1==null){
			throw new IllegalArgumentException("la priva chiave non pu� essere vuota");
		}
		this.chiave1=chiave1;
		this.chiave2=chiave2;
		this.chiave3=chiave3;
	}

	public K1 getChiave1() {
		return chiave1;
	}

	public K2 getChiave2() {
		return chiave2;
	}

	public K3 getChiave3() {
		return chiave3;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chiave1 == null) ? 0 : chiave1.hashCode());
		result = prime * result + ((chiave2 == null) ? 0 : chiave2.hashCode());
		result = prime * result + ((chiave3 == null) ? 0 : chiave3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultiKey other = (MultiKey) obj;
		if (chiave1 == null) {
			if (other.chiave1 != null)
				return false;
		} else if (!chiave1.equals(other.chiave1))
			return false;
		if (chiave2 == null) {
			if (other.chiave2 != null)
				return false;
		} else if (!chiave2.equals(other.chiave2))
			return false;
		if (chiave3 == null) {
			if (other.chiave3 != null)
				return false;
		} else if (!chiave3.equals(other.chiave3))
			return false;
		return true;
	}
	public String toString(){
		return "chiave1:"+chiave1+
				"\nchiave2:"+chiave2+
				"\nchiave3:"+chiave3;
	}
	public static <T1 extends Comparable<T1>,T2 extends Comparable<T2>,T3 extends Comparable<T3>> 
						MultiKey<T1,T2,T3> valueOf(T1 key1, T2 key2, T3 key3){
		return new MultiKey<>(key1,key2,key3);
	}
}
