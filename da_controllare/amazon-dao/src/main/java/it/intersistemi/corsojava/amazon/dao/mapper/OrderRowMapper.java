package it.intersistemi.corsojava.amazon.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.intersistemi.corsojava.amazon.dao.model.Order;
import it.intersistemi.corsojava.amazon.jdbc.util.ResultSetUtil;

public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order obj = new Order();
		obj.setIndirizzoSpedizione(rs.getString("indirizzo_spedizione"));
		obj.setModalitaPagamento(rs.getString("modalita_pagamento"));
		obj.setnOrdine(ResultSetUtil.getInt(rs,"numero_ordine"));
		obj.setSconto(ResultSetUtil.getInt(rs,"sconto"));
		obj.setStatoPagamento(rs.getString("Stato_pagamento"));
		obj.setUsername(rs.getString("username"));
		return obj;
	}

}
