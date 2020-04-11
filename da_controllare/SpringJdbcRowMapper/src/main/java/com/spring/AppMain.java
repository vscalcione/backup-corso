package com.spring;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.EmployeeDao;
import com.spring.model.Employee;

public class AppMain {

	public static void main(String[] args) throws SQLException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");

		EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("employeeDao");

		// Find By Id!
		Employee emp = employeeDao.findById(2);		
		System.out.println("-------------Find by Id---------------------");
		System.out.println(emp.toString());

		// Find all!
		Collection<Employee> emplist = employeeDao.findAll();
		System.out.println("-------------Find all---------------------");
		for (Employee employee : emplist) {
			System.out.println(employee.toString());
		}

		// Closing the application context!
		((AbstractApplicationContext) applicationContext).close();
	}
}