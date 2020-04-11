package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.CategoryRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.CategoryRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	private static final String QUERY_FIND_ALL = "SELECT * FROM Categoria";
	private static final String QUERY_FIND_BY_ID = "SELECT * FROM Categoria WHERE id = ?";
	private static final String QUERY_INSERT = "INSERT INTO Categoria (id_padre, nome) VALUES (?, ?)";
	private static final String QUERY_UPDATE = "UPDATE Categoria SET id_padre = ?, nome = ? WHERE id = ?";
	private static final String QUERY_FIND_ROOT_CATEGORIES = "SELECT * FROM Categoria WHERE id_padre IS NULL";
	private static final String QUERY_FIND_CHILDREN_CATEGORIES = "SELECT * FROM Categoria WHERE id_padre = ?";

	@Autowired
	private DataSource ds;

	@Override
	public Iterable<Category> findAll() {
		try (Connection conn = ds.getConnection();) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY_FIND_ALL);
			return new CategoryRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Category findById(Integer id) {
		try (Connection conn = ds.getConnection();) {
			PreparedStatement stmt = conn.prepareStatement(QUERY_FIND_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			return new CategoryRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer insert(Category obj) {
		try (Connection conn = ds.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
			if (obj.getIdPadre() != null) {
				stmt.setInt(1, obj.getIdPadre());
			} else {
				stmt.setNull(1, Types.INTEGER);
			}
			stmt.setString(2, obj.getNome());

			stmt.executeUpdate();
			// Gestisco il recupero del valore auto_increment
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				obj.setId(rs.getInt(1));
			}
			return obj.getId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Category obj) {
		try (Connection conn = ds.getConnection();) {

			PreparedStatement stmt = conn.prepareStatement(QUERY_UPDATE);
			if (obj.getIdPadre() != null) {
				stmt.setInt(1, obj.getIdPadre());
			} else {
				stmt.setNull(1, Types.INTEGER);
			}
			stmt.setString(2, obj.getNome());
			stmt.setInt(3, obj.getId());

			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Category> findChildrenCategories(Integer idPadre) {
		if (idPadre == null) {
			return this.findRootCategories();
		} else {
			try (Connection conn = ds.getConnection();) {
				PreparedStatement stmt = conn.prepareStatement(QUERY_FIND_CHILDREN_CATEGORIES);
				stmt.setInt(1, idPadre);
				ResultSet rs = stmt.executeQuery();
				return new CategoryRowMapper().toList(rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public Iterable<Category> findRootCategories() {
		try (Connection conn = ds.getConnection();) {
			PreparedStatement stmt = conn.prepareStatement(QUERY_FIND_ROOT_CATEGORIES);
			ResultSet rs = stmt.executeQuery();
			return new CategoryRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
