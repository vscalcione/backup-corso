package esercitazioneSegreteriaUniversitaria;

public class Facolta {
	

	private String codiceFacolta;
	private String nomeFacolta;
	
	
public Facolta() {}

public String getCodiceFacolta() {
	return codiceFacolta;
}

public void setCodiceFacolta(String codiceFacolta) {
	this.codiceFacolta = codiceFacolta;
}

public String getNomeFacolta() {
	return nomeFacolta;
}

public void setNomeFacolta(String nomeFacolta) {
	this.nomeFacolta = nomeFacolta;
}

@Override
public String toString() {
	return "FacoltaUniversitaria [codiceFacolta=" + codiceFacolta + ", nomeFacolta=" + nomeFacolta + "]";
}


	


}
