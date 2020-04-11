package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public final class PoligoniUtil {

	private PoligoniUtil() {
	}
	
	public static double[] calcolaPerimetri(Poligono[] poligoni) {
		double[] perimetri = new double[poligoni.length];
		for (int i = 0; i < poligoni.length; i++) {
			perimetri[i] = poligoni[i].calcolaPerimetro();
		}
		return perimetri;
	}
	
	public static Poligono[] clonaForme(Poligono[] poligoni) {
		Poligono[] cloni = new Poligono[poligoni.length];
		for (int i = 0; i < poligoni.length; i++) {
			cloni[i] = poligoni[i].clonaForma();
		}
		return cloni;
	}

	public static double[] calcolaAree(Poligono[] poligoni) {
		double[] aree = new double[poligoni.length];
		for (int i = 0; i < poligoni.length; i++) {
			aree[i] = poligoni[i].calcolaArea();
		}
		return aree;
	}
}
