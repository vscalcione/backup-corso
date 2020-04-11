package esercitazioneSegreteriaUniversitaria;

public enum Universita {

	Ingegneria("Ingegneria"),
	Fisica("Fisica"),
	Filosofia("Filosofia"),
	Storia("Storia"),
	Lingue("Lingue"),
	Statistica("Statistica"),
	Economia("Economia"),
	Latino("Latino");
	
	private String facolta;
	
	Universita (String facolta)
	
	{
            this.facolta=facolta;
	}

	public String getFacolta() {
		return facolta;
	}

	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
}
