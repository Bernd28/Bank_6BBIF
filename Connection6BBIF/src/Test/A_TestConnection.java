package Test;

import java.sql.Connection;
import java.sql.SQLException;

import Connection.OracleConnection;
import Domain.BankAccountException;

public class A_TestConnection {

	public static void main(String[] args) {
		
		try {
			OracleConnection oracon = new OracleConnection();
			oracon.open();
			Connection con = oracon.getConnection();
			System.out.println(con.getMetaData().getDatabaseMajorVersion());
			oracon.close();
			
		} catch (BankAccountException | SQLException e) {
			// TODO Auto-generated catch block
		
			System.out.println(e.getMessage());
		}

	}

}
	 