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

import it.intersistemi.corsojava.amazon.dao.ProductOrderRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ProductOrderRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.ProductOrder;
import it.intersistemi.corsojava.amazon.dao.model.ProductOrderPK;

@Repository
public class ProductOrderRepositoryImpl implements ProductOrderRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<ProductOrder> findAll() {
		try (Connection conn = ds.getConnection();) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ordine_prodotto");
			return new ProductOrderRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ProductOrder findById(ProductOrderPK id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ordine_prodotto WHERE numero_ordine = ?"
					+ " and asin = ? and p_iva = ?");
			
			stmt.setInt(1, id.getNumeroOrdine());
			stmt.setString(2, id.getAsin());
			stmt.setString(3, id.getpIva());
			ResultSet rs = stmt.executeQuery();
			return new ProductOrderRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ProductOrderPK insert(ProductOrder obj) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ordine_prodotto "
					+ "(numero_ordine, asin, p_iva, quantita, prezzo_acquisto, sconto, nome_profilo_spedizione) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, obj.getId().getNumeroOrdine());
			stmt.setString(2, obj.getId().getAsin());
			stmt.setString(3, obj.getId().getpIva());
			stmt.setInt(4, obj.getQuantita());
			stmt.setDouble(5, obj.getPrezzoAcquisto());			
			if (obj.getSconto() != null) {
				stmt.setInt(6, obj.getSconto());
				} else {
					stmt.setInt(6, Types.INTEGER);
				}
			stmt.setString(7, obj.getNomeProfiloSpedizione());			
			int result = stmt.executeUpdate();
			return obj.getId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(ProductOrder obj) {
		try (Connection conn = ds.getConnection()) {			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE ordine_prodotto SET quantita = ?, prezzo_acquisto = ?, sconto = ?, nome_profilo_spedizione = ?"
					+ "WHERE numero_ordine = ? and asin = ? and p_iva = ?");
			stmt.setInt(1, obj.getQuantita());
			stmt.setDouble(2, obj.getPrezzoAcquisto());			
			if (obj.getSconto() != null) {
				stmt.setInt(3, obj.getSconto());
				} else {
					stmt.setInt(3, Types.INTEGER);
				}
			stmt.setString(4, obj.getNomeProfiloSpedizione());
			stmt.setInt(5, obj.getId().getNumeroOrdine());
			stmt.setString(6, obj.getId().getAsin());
			stmt.setString(7, obj.getId().getpIva());
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

