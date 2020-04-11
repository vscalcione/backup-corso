package it.intersistemi.corsojava.ereditarieta.esercizi.eserciziobiblioteca;

public class DVD extends Library{
	private int videoDuration;
	public DVD(String productTitle, String userName, String userSurname, int pubblicationYear, Data startDate, Data endDate, int videoDuration) {
		super(productTitle, userName, userSurname, pubblicationYear, startDate, endDate);
		this.videoDuration = videoDuration;
	}
	public int getVideoDuration() {
		return videoDuration;
	}
	public void setVideoDuration(int videoDuration) {
		this.videoDuration = videoDuration;
	}
}
