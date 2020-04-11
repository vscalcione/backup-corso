package esercitazioneSegreteriaUniversitaria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RowMapper<T> {
	
	T mapRow(ResultSet rs, int rowNum) throws SQLException ;
	
	default List<T> toList(ResultSet rs) throws SQLException {
		List<T> resultList = new ArrayList<>();
		while(rs.next()) {
			resultList.add(this.mapRow(rs, rs.getRow()));
		}
		return resultList;
	}
	
	default T toObject(ResultSet rs) throws SQLException {
		if(rs.next()) {
			return this.mapRow(rs, rs.getRow());
		} else {
			return null;
		}
	}
}
