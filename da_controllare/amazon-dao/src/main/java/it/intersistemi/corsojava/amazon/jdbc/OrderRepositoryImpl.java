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

import it.intersistemi.corsojava.amazon.dao.OrderRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.OrderRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Order;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<Order> findAll() {
		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ordineo");
			return new OrderRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Order findById(Integer id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ordine WHERE numero_ordine = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			return new OrderRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer insert(Order obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO ordine (stato_pagamento, modalita_pagamento, sconto,"
					+ "username, indirizzo_spedizione) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, obj.getStatoPagamento());
			stmt.setString(2, obj.getModalitaPagamento());
			if (obj.getSconto() != null) {
				stmt.setInt(3, obj.getSconto());
				} else {
					stmt.setInt(3, Types.INTEGER);
				}		
			stmt.setString(4, obj.getUsername());
			stmt.setString(5, obj.getIndirizzoSpedizione());
			int result = stmt.executeUpdate();
			return obj.getnOrdine();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Order obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE ordine SET stato_pagamento= ?, modalita_pagamento = ?, sconto = ?,"
					+ " username = ?, indirizzo_spedizione = ? "
					+ "WHERE numero_ordine = ?");
			stmt.setString(1, obj.getStatoPagamento());
			stmt.setString(2, obj.getModalitaPagamento());
			stmt.setInt(3, obj.getSconto());
			stmt.setString(4, obj.getUsername());
			stmt.setString(5, obj.getIndirizzoSpedizione());
			stmt.setInt(6, obj.getnOrdine());
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Order> findByUsername(String nome) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ordine WHERE username = ?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			return new OrderRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
