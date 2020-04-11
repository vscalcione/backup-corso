package it.intersistemi.corso.todo.service.impl;

import java.util.List;

import it.intersistemi.corso.todo.model.TodoDTO;
import it.intersistemi.corso.todo.model.UserDTO;


public interface UserService extends CrudService<UserDTO, Integer> {
	UserDTO findByUserName(String userName);
	void addItemListToDo(String userName, String idActivity);
	void removeItemListToDo(String userName, String idActivity);
	List<TodoDTO> listToDo(String username);
}
