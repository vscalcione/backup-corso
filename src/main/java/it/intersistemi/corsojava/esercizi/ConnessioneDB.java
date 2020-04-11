package it.intersistemi.corsojava.esercizi;
import java.sql.*;

public class ConnessioneDB {

	public static void main(String[] args) throws SQLException {
		String jdbcUrl="jdbc:mysql://localhost:3306/mydb";
		String user="user";
		String password="pass";
		try( 
			Connection connessione=DriverManager.getConnection(jdbcUrl,user,password);
			Statement s=connessione.createStatement();
			){
			String query="SELECT * FROM users";
			ResultSet risultati=s.executeQuery(query);
			int id;
			String username;
			String pass;
			boolean enabled;
			while(risultati.next()){
				id=risultati.getInt("id");
				username=risultati.getString("username");
				pass=risultati.getString("password");
				enabled=risultati.getBoolean("enabled");
				
				String valore="utente";
				String sql="SELECT * FROM users WHERE username=";
				sql=sql+"'"+valore+"'";
				System.out.println(sql);
				s.executeQuery(sql);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
