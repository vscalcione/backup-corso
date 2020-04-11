package it.intersistemi.corsojava.user.dao;

import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import it.intersistemi.corsojava.users.dao.UserRepository;
import it.intersistemi.corsojava.users.model.User;

public class UserRepositorySpringJdbcTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("users-dao-context.xml");
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		User[] users = new User[100];
		for (int i = 0; i < users.length; i++) {
			User user = new User();
			user.setUserName("user_"+i);
			user.setPassword("password_"+i);
			user.setEnabled(true);
			Integer userId = userRepository.insert(user);
			user.setUserID(userId);
			users[i] = user;
		}
		Arrays.stream(users).forEach(u -> System.out.println(u.getUserID() + " - " + u.getUserName()));
	}
}