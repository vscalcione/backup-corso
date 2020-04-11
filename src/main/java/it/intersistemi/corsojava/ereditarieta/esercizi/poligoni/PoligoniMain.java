package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class PoligoniMain {

	public static void main(String[] args) {
		Poligono[] poligoni = {
				new Rettangolo(10, 20),
				new Quadrato(50),
				new Cerchio(5),
				new Rettangolo(4, 6),
				new Cerchio(15.3),
				new Quadrato(56.4)
		};

		for (int i = 0; i < poligoni.length; i++) {
			System.out.println("Poligono "+i+": "+poligoni[i]);
		

		double[] perimetri = PoligoniUtil.calcolaPerimetri(poligoni);
		for ( i = 0; i < perimetri.length; i++) {
			System.out.println("Perimetro "+i+": "+perimetri[i]);
		}
		
		double[] aree = PoligoniUtil.calcolaAree(poligoni);
		
		for ( i = 0; i < aree.length; i++) {
			System.out.println("Area "+i+": "+aree[i]);
		}}

	}
	

}
