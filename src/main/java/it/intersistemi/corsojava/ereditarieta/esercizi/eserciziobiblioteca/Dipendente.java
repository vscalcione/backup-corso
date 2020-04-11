package it.intersistemi.corsojava.ereditarieta.esercizi.eserciziobiblioteca;

public class Dipendente {
	private String employeeId;
	private double salary, extraordinary;
	public Dipendente(String employeeId, double salary, double extraordinary) {
		super();
		this.employeeId = employeeId;
		this.salary = salary;
		this.extraordinary = extraordinary;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getExtraordinary() {
		return extraordinary;
	}
	
	public void setExtraordinary(double extraordinary) {
		this.extraordinary = extraordinary;
	}
	
	public double paga(int extraordinaryHours) {
		double paga = extraordinaryHours * extraordinary + salary;
		return paga;
	}

	@Override
	public String toString() {
		return "Dipendente [employeeId=" + employeeId + ", salary=" + salary + ", extraordinary=" + extraordinary + "]";
	}
	
	public static void main(String[] args) {
		Dipendente dip1 = new Dipendente("123456", 1200.0, 10.0);
		System.out.println(dip1.toString());
		System.out.println("Paga totale: " + dip1.paga(10));
		DipendenteA dipA = new DipendenteA("123456", 1200.0, 10.0, 5);
		System.out.println(dipA.toString());
		System.out.println("Paga totale: " + dipA.paga(10));
	}
}
