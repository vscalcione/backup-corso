package it.intersistemi.model;

public class Phone implements Entity<PhonePK>{
	private PhonePK id;
	private String type;
	private String phone;
	
	
	public PhonePK getId(){
		return id;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setId(PhonePK id) {
		this.id = id;
	}
	
	
}
