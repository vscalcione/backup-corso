package it.intersistemi.corsojava.esercitazioni.banca;

public class BancaMain {

	public static void main(String[] args) {
		IstitutoBancario contoUnicredit = new IstitutoBancarioImpl("unicredit", "001","456" );
		IstitutoBancario contoBnl = new IstitutoBancarioImpl("bnl", "006","789" );
		IstitutoBancario contoIntesa = new IstitutoBancarioImpl("intesa", "089","123" );
		
		try {
			System.out.println(contoUnicredit.aggiungiContoCorrente("Mirko", "Bartoli"));
			System.out.println(contoBnl.aggiungiContoCorrente("Giulia", "Ferri"));
			System.out.println(contoIntesa.aggiungiContoCorrente("sara", "rossi"));
			System.out.println(contoUnicredit.aggiungiContoCorrente("mario", "rossi"));
		}catch (ContoCorrenteException e){
			e.printStackTrace();
		}

}
}
