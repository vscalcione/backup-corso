package it.intersistemi.corsojava.esercitazioni.banca;

public class ContoCorrente {
	
	String nomeIntestatario;
	String cognomeIntestatario;
	int numeroDiConto;
    double disponibilitaIniziale;
    static double massimoScoperto;
    
    public boolean preleva(double ammontare) {
		return true;
	}
	
	
	
	
	public boolean deposita(double ammontare) {
		return true;
	}
	
    
    public ContoCorrente(String nomeIntestatario, String cognomeIntestatario, int numeroDiConto) {
    	super();
    	this.nomeIntestatario = nomeIntestatario;
    	this.cognomeIntestatario = cognomeIntestatario;
    	this.numeroDiConto = numeroDiConto;
    	
    }
    
    public ContoCorrente(String nomeIntestatario, String cognomeIntestatario, int numeroDiConto,
    		double disponibilitaIniziale) {
    	super();
    	this.nomeIntestatario = nomeIntestatario;
    	this.cognomeIntestatario = cognomeIntestatario;
    	this.numeroDiConto = numeroDiConto;
    	this.disponibilitaIniziale = disponibilitaIniziale;
    	
    }
       
    
    

	public String getNomeIntestatario() {
		return nomeIntestatario;
	}


	public void setNomeIntestatario(String nomeIntestatario) {
		this.nomeIntestatario = nomeIntestatario;
	}


	public String getCognomeIntestatario() {
		return cognomeIntestatario;
	}

	public void setCognomeIntestatario(String cognomeIntestatario) {
		this.cognomeIntestatario = cognomeIntestatario;
	}

	public int getNumeroDiConto() {
		return numeroDiConto;
	}

	public void setNumeroDiConto(int numeroDiConto) {
		this.numeroDiConto = numeroDiConto;
	}

	public double getDisponibilitaIniziale() {
		return disponibilitaIniziale;
	}

	public void setDisponibilitaIniziale(double disponibilitaIniziale) {
		this.disponibilitaIniziale = disponibilitaIniziale;
	}
	
	public static void main(String[] args) {
		
		ContoCorrente conto1 = new ContoCorrente()
				conto1.setNumeroDiConto(463660);
		        conto1.setNomeIntestatario("Johnny");
		        conto1.setCognomeIntestatario("Sins");
		        conto1.setDisponibilitaIniziale(1500);
		        conto1.preleva(1500);
		        conto1.deposita(1500);
		        
	
	
	public boolean deposita(double disponibilitaIniziale)
	
	
	public boolean preleva (double disponibilitaIniziale)
	
	public boolean isScoperto()
	
	
	public String toString()
	
	
	public static void setMassimoScoperto(double valore);




	
		
		
		
		
		
	

}

}
