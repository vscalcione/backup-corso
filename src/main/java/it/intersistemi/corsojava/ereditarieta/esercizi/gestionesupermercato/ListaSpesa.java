package it.intersistemi.corsojava.ereditarieta.esercizi.gestionesupermercato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class ListaSpesa extends ProdottoNegozio{
	String mainResource;
	Data data;
	
	public ListaSpesa(String productName, String productDescription, int barCode, double price, String mainResource, Data data) {
		super(productName, productDescription, barCode, price);
		this.mainResource = mainResource;
		this.data = data;
	}

	public String getMaterialePrincipale() {
		return mainResource;
	}

	public void setMaterialePrincipale(String mainResource) {
		this.mainResource = mainResource;
	}

	@Override
	public String toString() {
		return this.getProductName() + " , " + this.getBarCode() + " , " + this.getProductDescription() + " , " + this.getPrice() + " , " 
				+ this.mainResource;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		ListaSpesa product1 = new ListaSpesa ("Spaghetti Barilla", "pacco da 500gr di spaghetti", 11111, 2.20, "pasta", new Data(4, 3, 2019));
		ListaSpesa product2 = new ListaSpesa ("Padella", "padella", 10101, 2.20, "metallo", new Data(5, 4, 2018));
		ListaSpesa product3 = new ListaSpesa ("Sugo Mutti", "500gr di sugo al pomodoro", 01010, 2.20, "pomodori", new Data(6, 5, 2017));
		ListaSpesa product4 = new ListaSpesa ("Carne di maiale", "1kg d carne di maiale", 00011, 2.20, "carne", new Data(7, 6, 2016));
	
		printMenu(product1, product2, product3, product4);
		ListaSpesa[] magazzino = new ListaSpesa[10];
		magazzino[0] = product1;
		magazzino[1] = product2;
		magazzino[2] = product3;
		magazzino[3] = product4;
		ListaSpesa[] carrello = new ListaSpesa[10];
		int scelta, i;
		double sum = 0;
		for (int j = 0; j < carrello.length; j++) {
			scelta = ConsoleInputInteri.leggiIntero(console, "Scelta: ");
			carrello[j] = magazzino[scelta];
			if(carrello[j] != null) {
				System.out.println("Hai scelto: " + carrello[j] + " \nDigita 5 per pagare");
			}
			if(scelta == 5) {
				break;
			}
		}
		System.out.println("");
		for (i = 0; i < carrello.length; i++) {

			if (carrello[i] != null) {

				System.out.println("Nel tuo carrello � presente: " + carrello[i]);
			}

			if (carrello[i] != null) {
				sum = sum + carrello[i].getPrice();
			}
		}
		System.out.println("Il totale da pagare �: " + sum);
	}
	
	public static void printMenu(ListaSpesa product1, ListaSpesa product2, ListaSpesa product3, ListaSpesa product4) {
		System.out.println("Buongiorno Gentilissimo Cliente");
		System.out.println("Premi 1 per scegliere il prodotto: " + product1.getProductName() + "\nPremi 2 per scegliere il prodotto: "
				+ product2.getProductName() + "\nPremere 3 per scegliere il prodotto: " + product3.getProductName() + "\nPremere 4 per scegliere il"
				+ "prodotto: " + product4.getProductName());
	}
}
