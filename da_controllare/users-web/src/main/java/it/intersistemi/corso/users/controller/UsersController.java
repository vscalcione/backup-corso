package it.intersistemi.corso.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.intersistemi.corsojava.users.dao.UserRepository;
import it.intersistemi.corsojava.users.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method=RequestMethod.GET)
	public String userList(Model model) {
		Iterable<User> userList = this.userRepository.findAll();
		model.addAttribute("userList", userList);
		return "users/userList";
	}
	public String usersDetails(Integer id, Model model) {
		User user = this.userRepository.findById(id);
		model.addAttribute("users", user);
		return "users/userDetails";
	}


}
