package br.com.devti.abs.core.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	private static final String urlD = "jdbc:mysql://localhost:3306/abs_db";
	private static final String userDb = "root";
	private static final String passDb = "Italomdf1998";
	
	private static Connection conn;
	
	public static Connection getConexao() {
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(urlD, userDb, passDb);
				return conn;
			}else {
				return conn;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
		
	//public static void main(String[] args) {
		
	//	try {
	//		Connection con = DriverManager.getConnection(urlD, userDb, passDb);
	//		Statement stmt = con.createStatement();
		//	ResultSet rs = stmt.executeQuery("SELECT NOME_USU FROM usuario");
			//while(rs.next()) {
				//System.out.println(rs.getString("NOME_USU"));
			//}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
	//}

}
