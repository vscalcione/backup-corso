package it.intersistemi.corsojava.ereditarieta.esercizi.gestionesupermercato;

public class ProdottoAlimentare extends ProdottoNegozio{
	Data data;
	public ProdottoAlimentare(String productName, String productDescription, int barCode, double price, Data data) {
		super(productName, productDescription, barCode, price);
		this.data = data;
	}
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public double applicaSconto() {
		double nuovoPrezzo;
		nuovoPrezzo = this.getPrice() - this.getPrice() * 0.20;
		return nuovoPrezzo;
	}
	
	@Override
	public String toString() {
		return this.getProductName() + " , " + this.getBarCode() + " , " + this.getProductDescription() + " , " + this.getPrice() + " , "
				+ this.getData();
	}

	public static void main(String[] args) {
		Data currentDate = new Data (11,11,2017) ;
		ProdottoAlimentare product1 = new ProdottoAlimentare("Salame", "Fatto in casa", 1704217702, 3.4, new Data (12,11,2017));
		ProdottoAlimentare product2 = new ProdottoAlimentare("Salame new", "Fatto in Casa", 1704217703, 3.4, new Data(19,12,2017) );		
		System.out.println(product1);
		System.out.println(product2);
		Data data = product1.data;
		int risultato = currentDate.getDifference(data);
		if (risultato<10){
			ProdottoAlimentare prodottoNegozio = product2;
			double nuovoPrezzoUnitario = product2.applicaSconto();  
			prodottoNegozio.setPrice(nuovoPrezzoUnitario); 
			System.out.println(nuovoPrezzoUnitario);
			System.out.println(prodottoNegozio);}
			System.out.println(risultato);
			System.out.println(product1.data);
	}
}
