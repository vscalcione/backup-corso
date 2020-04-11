package it.intersistemi.corsojava.amazon;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import it.intersistemi.corsojava.amazon.dao.model.Category;

public class NamedParameterJdbcTemplateMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("amazon-dao.xml");
		DataSource datasource = ctx.getBean(DataSource.class, "dataSource");
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(datasource);
		
//		Prodotto prodotto = new Prodotto();
//		prodotto.setAsin("ASIN_1");
//		prodotto.setNome("Vestito da sera");
//		prodotto.setDescrizione("Vestito da sera");
//		prodotto.setMarca("Marca");
//		prodotto.setModello("Modello");
//		prodotto.setCategoriaId(3);
//		
//		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(prodotto);
//		tmpl.update("insert into Prodotto (ASIN, NOME, DESCRIZIONE, MARCA, MODELLO, CATEGORIA_ID)" + 
//				"values(:asin, :nome, :descrizione, :marca, :modello, :categoria)", paramSource);

		Category category = new Category();
		category.setIdPadre(2);
		category.setNome("Categoria nuova 2");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(category);
		template.update("insert into Categoria (ID_PADRE, NOME) values(:idPadre, :nome)", paramSource, keyHolder);
		System.out.println(keyHolder.getKey().intValue());
	}
}
