package esercitazioneSegreteriaUniversitaria;

public class Exam {

	private String examCode;
	private String examName;

	public Exam() {
		
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "Esame [codiceEsame=" + examCode + ", nomeEsame=" + examName + "]";
	}

	
}
