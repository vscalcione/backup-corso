package it.intersistemi.corsojava.esercitazioni.banca;

public class IstitutoBancariolmpl {
	
	String nome;
	String abi;
	String cab;
	
	
	  public IstitutoBancariolmpl(String nome, String abi, String cab) {
	    	super();
	    	this.nome = nome;
	    	this.abi = abi;
	    	this.cab = cab; 
	    	
	    	
	    	
	  }


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbi() {
		return abi;
	}

	public void setAbi(String abi) {
		this.abi = abi;
	}
	
	public String getCab() {
		return cab;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}
}
