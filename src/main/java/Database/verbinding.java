package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface verbinding {
	public default Connection maakVerbinding(String db, String user, String password) throws SQLException { //dit moet worden afgevangen

		//link naar de DB
		//String JDBCURL="jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";
		Connection con = null;

		//maak verbinding
		con = DriverManager.getConnection(db,user,password);
		System.out.println("connection is established");

		return con;
	}
}
