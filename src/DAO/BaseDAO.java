package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {

	/**
	 * Classe base para todos os dao's
	 */
	protected PreparedStatement pstmt;
	protected Statement stmt;
	protected ResultSet rs;
	protected Connection connection;
	
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
	
	public void finalize(){
		try {
			closeResources(connection, rs, pstmt, stmt);
		} catch (SQLException e) {
			System.out.print("BaseDAO:finalize " + e);
			
		}
	}
	
	public void finalizaNaoConn(){
		try {
			closeResources(rs, pstmt, stmt);
		} catch (SQLException e) {
			System.out.print("BaseDAO:finalize " + e);
			
		}
	}
	
	private void closeResources(Connection conn, ResultSet r, PreparedStatement ps, Statement s) throws SQLException{
		if(r != null){
			r.close();
		}
		if(ps != null){
			ps.close();
		}
		if(s != null){
			s.close();
		}
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
	}
	
	private void closeResources(ResultSet r, PreparedStatement ps, Statement s) throws SQLException{
		if(r != null){
			r.close();
		}
		if(ps != null){
			ps.close();
		}
		if(s != null){
			s.close();
		}
		
	}

}
//teste3