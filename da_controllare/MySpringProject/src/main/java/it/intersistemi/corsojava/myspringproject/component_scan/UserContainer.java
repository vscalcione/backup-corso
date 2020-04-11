package it.intersistemi.corsojava.myspringproject.component_scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.intersistemi.corsojava.myspringproject.User;

@Component
public class UserContainer {
	@Autowired
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Contenitore\n " + user.toString();
	}
}
