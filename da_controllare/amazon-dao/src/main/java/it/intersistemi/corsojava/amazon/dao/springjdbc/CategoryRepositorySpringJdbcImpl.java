package it.intersistemi.corsojava.amazon.dao.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import it.intersistemi.corsojava.amazon.dao.CategoryRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.CategoryRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Category;

public class CategoryRepositorySpringJdbcImpl implements CategoryRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Iterable<Category> findAll() {
		return jdbcTemplate.query("Select * from categoria", new CategoryRowMapper());
	}

	@Override
	public Category findById(Integer id) {
		return jdbcTemplate.queryForObject("Select * from categoria where id = ?",
				new CategoryRowMapper(), id);
	}

	@Override
	public Integer insert(Category obj) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update("INSERT INTO categoria (id_padre, nome)"
				+ " VALUES (?, ?)",
				obj.getIdPadre(),
				obj.getNome(),
				keyHolder
				);
		return keyHolder.getKey().intValue();
	}

	@Override
	public boolean update(Category obj) {
		int rowsAffected = jdbcTemplate.update("UPDATE categoria SET id_padre = ?, nome = ?,"
				 + "WHERE id = ?",
				obj.getIdPadre(),
				obj.getNome(),
				obj.getId()
				);
		return rowsAffected !=0;
	}
	
	@Override
	public Iterable<Category> findChildrenCategories(Integer id) {
		if(id == null) {
			return this.findRootCategories();
		}else {
		return jdbcTemplate.query("Select * from categoria where id_pade = ?",
				new CategoryRowMapper(), id);
		}
	}

	@Override
	public Iterable<Category> findRootCategories() {
		return jdbcTemplate.query("Select * from categoria where id_pade is null", new CategoryRowMapper());
	}

}
