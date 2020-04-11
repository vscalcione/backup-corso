package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class PoligonoMain {
	public static void main(String[] args) {
		Ennegono ennegono = new Ennegono(3, 1.5);
		System.out.println(ennegono.calcolaAngoloInterno());
		System.out.println(ennegono.calcolaApotema());
	}


	public static class Ennegono extends Poligono implements PoligonoRegolare {
		private int numeroLati;
		
		public Ennegono(int numeroLati, double lato) {
			super(creaArray(numeroLati, lato));
			this.numeroLati = numeroLati;
		}

		private static double[] creaArray(int numeroLati, double lato) {
			double[] lati = new double[numeroLati];
			for (int i = 0; i < lati.length; i++) {
				lati[i] = lato;
			}
			return lati;
		}
		
		
		@Override
		public int getNumeroLati() {
			return this.numeroLati;
		}

		@Override
		public double getLato() {
			// TODO Auto-generated method stub
			return super.getLati()[0];
		}

		@Override
		public Poligono clonaForma() {
			return new Ennegono(numeroLati, this.getLato());
		}

		@Override
		public double calcolaArea() {
			return 0;
		}
		
	}
}
