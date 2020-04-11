package it.intersistemi.corsojava.amazon;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import it.intersistemi.corsojava.amazon.dao.model.Product;

public class JdbcTemplateMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ammazzon-dao.xml");
		DataSource datasource = ctx.getBean(DataSource.class, "dataSource");
		JdbcTemplate template = new JdbcTemplate(datasource);
//		List<Categoria> categorie = tmpl.query("Select * from Categoria", new CategoriaRowMapper());
//		categorie.forEach(System.out::println);
		List<Product> prodotti = template.query("select * from prodotto", new BeanPropertyRowMapper<Product>(Product.class));
		prodotti.forEach(System.out::println);
	}
}