package it.intersistemi.model;

public class Email implements Entity<EmailPK> {
	private EmailPK id;
	private String type;
	private String email;
	
	
	
	public EmailPK getId(){
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(EmailPK id) {
		this.id = id;
	}
	
	
}
