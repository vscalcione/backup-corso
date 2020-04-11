package it.intersistemi.corsojava.amazon.dao.model;

public class User {
	private String username, email, password;	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Utente [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
}