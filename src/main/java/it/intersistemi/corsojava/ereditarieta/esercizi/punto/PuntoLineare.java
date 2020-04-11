package it.intersistemi.corsojava.ereditarieta.esercizi.punto;

public class PuntoLineare {
	private int coordinateX;
	public PuntoLineare(int coordinateX) {
		System.out.println("PuntoLineare: "+coordinateX);
		this.coordinateX = coordinateX;
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}
}
