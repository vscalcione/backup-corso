package it.intersistemi.corso.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.intersistemi.corso.todo.model.TodoDTO;
import it.intersistemi.corso.todo.model.UserDTO;
import it.intersistemi.corso.todo.service.impl.TodoService;
import it.intersistemi.corso.todo.service.impl.UserService;

@Controller
@RequestMapping("/users")
public class UserController extends CrudController<UserDTO, String, UserService> {

	@Autowired
	private TodoService todoService;

	@Autowired
	public UserController(UserService userService) {
		super(userService);
	}

	@Override
	protected void onShowEditForm(Integer id, UserDTO dto, Model model) {
		List<TodoDTO> userToDoList = super.service.listToDo(dto.getUsername());
		model.addAttribute("userToDoList", userToDoList);
		Iterable<TodoDTO> todo_list = todoService.findAll();
		model.addAttribute("todo", todo_list);
	}

	@RequestMapping(value="/{id}/addItemListToDo", method=RequestMethod.POST)
	public String saveEntity(@PathVariable("id") Integer id,
			@RequestParam(value="userName", required=true) String userName,
			@RequestParam(value="idActivity", required=true) String idActivity,
			Model model) {
		this.service.addItemListToDo(userName, idActivity);
		return "redirect:/users/"+id+"/edit";
	}

	@Override
	protected String getEntityListModelName() {
		return "userList";
	}

	@Override
	protected String getEntityModelName() {
		return "user";
	}

	@Override
	protected String getListView() {
		return "users/userList";
	}

	@Override
	protected String getDetailsView() {
		return "users/userDetails";
	}

	@Override
	protected String getFormView() {
		return "users/userForm";
	}

	@Override
	protected String getListUrl() {
		return "/users";
	}
}
