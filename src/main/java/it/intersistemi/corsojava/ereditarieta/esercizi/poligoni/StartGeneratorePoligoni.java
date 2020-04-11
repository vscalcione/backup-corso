package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

import it.intersistemi.corsojava.poligoni.Cerchio;
import it.intersistemi.corsojava.poligoni.Poligono;
import it.intersistemi.corsojava.poligoni.PoligonoRegolare;

public class StartGeneratorePoligoni {
	public static void main(String[] args) {
		FabbricaDiPoligoni fabbrica=new FabbricaDiPoligoni();
		Poligono[] poligoni=fabbrica.fabbricaPoligono(20);
		for (int i = 0; i < poligoni.length; i++) {
			Poligono poligono = poligoni[i];
			if(poligono instanceof Cerchio) {
				Cerchio cerchio = (Cerchio) poligono;
				System.out.println(cerchio.getClass().getSimpleName()
						+ " : Raggio "+cerchio.getRaggio()
						+ " : Perimetro "+cerchio.calcolaPerimetro()
						+ " : Area "+cerchio.calcolaArea());
				System.out.println("**********************************************************");
			}else {
					System.out.println(poligono.getClass().getSimpleName()
							+ " : NumeroLati "+poligono.getNumeroLati()
							+ " : Perimetro "+poligono.calcolaPerimetro()
							+ " : Area  "+poligono.calcolaArea()
					);
					System.out.println("**********************************************************");
				}
			if(poligono instanceof PoligonoRegolare) {
				PoligonoRegolare poligonoRegolare = (PoligonoRegolare) poligono;
				System.out.println("\tlato: "+poligonoRegolare.getLato() + ", apotema: "+poligonoRegolare.calcolaApotema());
				System.out.println("**********************************************************");
			}
		}
	}
}
