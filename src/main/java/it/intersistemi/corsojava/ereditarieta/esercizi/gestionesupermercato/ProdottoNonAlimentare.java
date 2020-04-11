package it.intersistemi.corsojava.ereditarieta.esercizi.gestionesupermercato;

public class ProdottoNonAlimentare extends ProdottoNegozio{
	String mainResource;
		
	public ProdottoNonAlimentare(String productName, String productDescription, int barCode, double price, String mainResource) {
		super(productName, productDescription, barCode, price);
		this.mainResource = mainResource;
	}

	public String getMainResource() {
		return mainResource;
	}

	public void setMainResource(String mainResource) {
		this.mainResource = mainResource;
	}

	public double applicaSconto() {
		double nuovoPrezzo;
		if (mainResource == "carta" || mainResource.equals("plastica") || mainResource == "legno") {
			nuovoPrezzo = this.getPrice() - this.getPrice() * 0.10;
			return nuovoPrezzo;
		} else {
			nuovoPrezzo = this.getPrice() - this.getPrice() * 0.05;
			return nuovoPrezzo;
		}
	}
	
	@Override
	public String toString() {
		return this.getProductName() + " , " + this.getProductDescription() + " , " + this.getBarCode() + " , " + this.getPrice() + " , " + this.mainResource;
	}

	public static void main(String[] args) {
		ProdottoNonAlimentare product1 = new ProdottoNonAlimentare("Calzini", "Maschili", 1704294223, 2.2, "plastica" );
		ProdottoNonAlimentare product2 = new ProdottoNonAlimentare("Calzini new", "Maschili", 1704294223,  2.2, "cotone" );		
		System.out.println(product1);
		System.out.println(product2);
		ProdottoNonAlimentare prodottoNegozio = product2;
		double nuovoPrezzo = product2.applicaSconto();
		prodottoNegozio.setPrice(nuovoPrezzo);
		System.out.println(nuovoPrezzo);
		System.out.println(prodottoNegozio);
	}
}
