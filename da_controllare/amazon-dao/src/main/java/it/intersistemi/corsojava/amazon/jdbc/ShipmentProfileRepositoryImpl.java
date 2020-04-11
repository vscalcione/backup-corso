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

import it.intersistemi.corsojava.amazon.dao.ShipmentProfileRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ShipperProfileRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.ShipmentProfile;

@Repository
public class ShipmentProfileRepositoryImpl implements ShipmentProfileRepository{

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<ShipmentProfile> findAll() {
		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM profilo_spedizione");
			return new ShipperProfileRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ShipmentProfile findById(String id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM profilo_spedizione WHERE nome = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			return new ShipperProfileRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String insert(ShipmentProfile obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO profilo_spedizione (nome, costo, giorni_spedizione) "
					+ "VALUES (?, ?, ?)");
			stmt.setString(1, obj.getNome());
			if (obj.getCosto() != null) {
				stmt.setDouble(2, obj.getCosto());
				} else {
					stmt.setDouble(2, Types.DOUBLE);
				}	
			if (obj.getTempoSpedizione() != null) {
				stmt.setInt(3, obj.getTempoSpedizione());
				} else {
					stmt.setInt(3, Types.INTEGER);
				}	
			int result = stmt.executeUpdate();
			return obj.getNome();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(ShipmentProfile obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE profilo_spedizione SET costo = ?, giorni_spedizione = ?"
					+ "WHERE nome = ?");
			stmt.setDouble(1, obj.getCosto());
			stmt.setInt(2, obj.getTempoSpedizione());
			stmt.setString(3, obj.getNome());
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
