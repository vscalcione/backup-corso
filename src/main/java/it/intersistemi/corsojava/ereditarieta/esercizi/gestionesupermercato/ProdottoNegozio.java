package it.intersistemi.corsojava.ereditarieta.esercizi.gestionesupermercato;

import java.io.IOException;

public class ProdottoNegozio {
	private String productName, productDescription;
	private int barCode;
	private double price;
	
	public ProdottoNegozio(String productName, String productDescription, int barCode, double price) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.barCode = barCode;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double applicaSconto() {
		double nuovoPrezzo;
		nuovoPrezzo = this.getPrice() - this.getPrice() * 0.05;
		return nuovoPrezzo;
	}
	@Override
	public String toString() {
		return this.productName + " , " + this.productDescription + " , " + this.barCode + " , " + this.price;
	}
	
	public static void main(String[] args) throws IOException{
		ProdottoNegozio product1 = new ProdottoNegozio("Spaghetti Barilla", "pacco da 500gr di spaghetti", 11111,2.20);
		ProdottoNegozio product2 = new ProdottoNegozio("Padella", "padella", 10101,2.20);
		ProdottoNegozio product3 = new ProdottoNegozio("Sugo Mutti", "500gr di sugo al pomodoro", 01010, 2.20);
		ProdottoNegozio product4 = new ProdottoNegozio("Carne di maiale", "1kg d carne di maiale", 00011,2.20);
		
		System.out.println(product1.toString() + "\n" + product2.toString() + "\n" + product3.toString() + "\n" + product4.toString());
		ProdottoNegozio product5 = product3;
		double nuovoPrezzo = product3.applicaSconto();
		product5.setPrice(nuovoPrezzo);
		System.out.println("Nuovo prezzo: "+nuovoPrezzo);
		System.out.println(product5);
	}
}
