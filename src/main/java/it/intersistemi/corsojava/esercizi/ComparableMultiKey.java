package it.intersistemi.corsojava.esercizi;

public final class ComparableMultiKey<K1 extends Comparable<K1>,K2 extends Comparable<K2>,K3 extends Comparable<K3>> extends MultiKey<K1,K2,K3> implements Comparable<ComparableMultiKey<K1, K2, K3>>{
	
	public ComparableMultiKey(K1 chiave1, K2 chiave2, K3 chiave3){
		super(chiave1,chiave2,chiave3);
	}
	
	public K1 getChiave1(){
		return super.getChiave1();
	}
	public K2 getChiave2(){
		return super.getChiave2();
	}
	public K3 getChiave3(){
		return getChiave3();
	}

	@Override
	public int compareTo(ComparableMultiKey<K1, K2, K3> multichiavi) {
		int confronto;
		//se la prima chiave di questo oggetto � diversa da la 
		//prima chiave dell'oggetto da confrontare allora ritorno
		//la diversit� tra le due
		confronto=getChiave1().compareTo(multichiavi.getChiave1());
		if(confronto!=0){
			return confronto;
		}
		//se invece la prima chiave � uguale controllo se la seconda
		//� uguale o no e faccio la stessa cosa della prima chiave
		confronto=controllaChiavi(getChiave2(), multichiavi.getChiave2());
		if(confronto!=0){
			return confronto;
		}
		//se anche la chiave 2 � uguale ritorno la comparazione della 
		//chiave 3, se la chiave 3 � uguale, ritorner� comunque 0
		//dalla chiamata compareTo sulla chiave 3 che verr� poi 
		//restituita tramite return da questo metodo
		return getChiave3().compareTo(multichiavi.getChiave3());
	}
	
	private static <T extends Comparable<T>> 
						int controllaChiavi(T chiave1, T chiave2){
		//controllo anche se le 2 chiavi non sono null
		if((chiave1!=null) && (chiave2!=null)){
			return chiave1.compareTo(chiave2);
		}
		else if(chiave1==chiave2){
			//se una delle 2 chiavi � null e le 2 chiavi sono uguali, 
			//automaticamente tutte e 2 le chiavi sono null e quindi
			//sono uguali e restituisco 0
			return 0;
		}
		else if(chiave1==null){
			//se la chiave1 � null, viene prima dell'altra e quindi
			//ritorna -1
			return -1;
		}
		else{
			//se la chiave2 � null ma la chiave1 no, viene prima 
			//la chiave 2 e quindi ritorna 1;
			return 1;
		}
	}
	public static <T1 extends Comparable<T1>,T2 extends Comparable<T2>,T3 extends Comparable<T3>> 
								ComparableMultiKey<T1,T2,T3> valueOf(T1 key1, T2 key2, T3 key3){
		return new ComparableMultiKey<>(key1,key2,key3);
	}
	

}
