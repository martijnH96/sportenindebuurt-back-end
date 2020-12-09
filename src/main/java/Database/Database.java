package Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Database implements verbinding{
	private Connection conn;

	private Database(){
		try {
			conn = maakVerbinding();
		} catch (SQLException sql){
			System.out.println("dit gaat fout");
			sql.printStackTrace();
		}
	}
}
