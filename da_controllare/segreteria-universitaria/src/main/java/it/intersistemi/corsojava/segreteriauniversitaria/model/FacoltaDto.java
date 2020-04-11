package it.intersistemi.corsojava.segreteriauniversitaria.model;

public class FacoltaDto {
	Integer idFacolta;
	String nomeFacolta;
	int numeroIscritti;
	public Integer getIdFacolta() {
		return idFacolta;
	}
	public void setIdFacolta(Integer idFacolta) {
		this.idFacolta = idFacolta;
	}
	public String getNomeFacolta() {
		return nomeFacolta;
	}
	public void setNomeFacolta(String nomeFacolta) {
		this.nomeFacolta = nomeFacolta;
	}
	public int getNumeroIscritti() {
		return numeroIscritti;
	}
	public void setNumeroIscritti(int numeroIscritti) {
		this.numeroIscritti = numeroIscritti;
	}
}
