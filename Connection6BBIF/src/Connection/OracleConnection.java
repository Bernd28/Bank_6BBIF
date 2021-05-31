package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Domain.BankAccountException;

public class OracleConnection {
	
	private Connection con;
	
	public OracleConnection() throws BankAccountException {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} 
		catch (ClassNotFoundException e) {
			throw new BankAccountException("Could not find Database Driver");
		}
		
	}
			public void open() throws BankAccountException
			{
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL","DEMO", "oracle");
				} catch (SQLException e) {
					throw new BankAccountException("Could not open Database Connection");
				}
			}
			
			public void close() throws BankAccountException
			{
				try {
					con.close();
				} catch (SQLException e) {
				
					throw new BankAccountException("Could not close Database Connection");
				
				}
			}
			public Connection getConnection()
			{
				return con;
			}
}
