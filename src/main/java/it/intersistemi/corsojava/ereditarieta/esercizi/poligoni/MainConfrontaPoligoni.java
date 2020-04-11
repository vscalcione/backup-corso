package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

//import polimorfismo.Base;
//import polimorfismo.Derivata;

public class MainConfrontaPoligoni {

	public static void main(String[] args) {

		Poligono[] poligoni = {

				new Rettangolo(10, 20), new Quadrato(50), new Cerchio(5), new Rettangolo(4, 6), new Cerchio(15.3),
				new Quadrato(56.4), new Rettangolo(12, 24), new Quadrato(56), new Cerchio(8) };

		gestisciPoligoni(poligoni); // solo il nome della variabile
        tipoPoligono(poligoni);
	}

	private static void gestisciPoligoni(Poligono[] poligoni) {

		for (int i = 0; i < poligoni.length; i++) {

			System.out.println("Poligono " + i + ": " + poligoni[i]);}

			double[] perimetri = PoligoniUtil.calcolaPerimetri(poligoni);
			for (int i = 0; i < perimetri.length; i++) {
				System.out.println("Perimetro " + i + ": " + perimetri[i]);

				double[] aree = PoligoniUtil.calcolaAree(poligoni);

				for (i = 0; i < aree.length; i++) {
					System.out.println("Area " + i + ": " + aree[i]);
				}
			}

		}
	

	
	private static void tipoPoligono(Poligono [] poligoni) {
		
		
		for (int i = 0; i < poligoni.length; i++) {
			Poligono prova = poligoni [i]; 
		
		if ( prova instanceof Quadrato ) {
			
		Quadrato quadrato = (Quadrato) prova; // non posso farlo senza cast. conviene controllare con istance of
              double latoQuadrato=quadrato.getLato();
              System.out.println( "Quadrato di lato: "+ latoQuadrato);
	}
		
	
		else if ( prova instanceof Rettangolo) {
			Rettangolo rettangolo = (Rettangolo) prova; // non posso farlo senza cast. conviene controllare con istance of
            double baseRettangolo=rettangolo.getBase();
            double altezzaRettangolo=rettangolo.getAltezza();
            System.out.println(baseRettangolo+ " "+altezzaRettangolo);
	}
		else if (prova instanceof Rettangolo) {
			
			Cerchio cerchio = (Cerchio) prova; // non posso farlo senza cast. conviene controllare con istance of
            double raggioCerchio=cerchio.getR();
            System.out.println(raggioCerchio);
			
		}
		System.out.println();
		}
		}
	
}
