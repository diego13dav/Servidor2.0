package jdbc;

import java.sql.*;

public class ConnectionFactory {
	
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost/pedidos2";
	private String user = "root";
	private String password = "";
	
	public Connection getConnection(){
		System.out.println("Conectando ao banco de dados do web service...");
		try{
			Class.forName(dbDriver);
			return DriverManager.getConnection(dbUrl,user,password);
		} catch(SQLException e){
			throw new RuntimeException(e);
		} catch(ClassNotFoundException e1){
			throw new RuntimeException(e1);
		}
	}

}