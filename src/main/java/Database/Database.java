package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database implements verbinding{
	private Connection conn;

	public Database(){
		try {
			conn = maakVerbinding();
		} catch (SQLException sql){
			System.out.println("dit gaat fout");
			sql.printStackTrace();
		}
	}

	public ResultSet select(String table, String columns, String where) throws SQLException {
		String sql = "SELECT " + columns + " FROM " + table;

		PreparedStatement stmt = conn.prepareStatement(sql);

		//stmt.setString(1, "*");
		//stmt.setString(1, "Sport");

		ResultSet results = stmt.executeQuery();

		/* tijdens het testen in een andere app heb ik dit gebruikt
		while (results.next()){
			System.out.println(results.getString(1) + " ");
		}*/

		return results;
	}

	public void insert(String table, String columns, String data) throws SQLException {

	}

	public void update(String table, String columns, String data, String where) throws SQLException {

	}

	public void execute(String procedure, String[] values) throws SQLException {

	}
}
