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

	public ResultSet select(String table, String columns, String[] where) throws SQLException {
		String sql = "SELECT " + columns + " FROM " + table;

		if(where.length != 0){
			sql.concat(" WHERE " + where[0]);
		}

		PreparedStatement stmt = conn.prepareStatement(sql);

		if(where.length != 0) {

			for (int i = 1; i < where.length; i++){
				stmt.setString(i, where[i]);
			}
			//stmt.setString(1, "*");
			//stmt.setString(1, "Sport");
		}

		ResultSet results = stmt.executeQuery();

		/* tijdens het testen in een andere app heb ik dit gebruikt
		while (results.next()){
			System.out.println(results.getString(1) + " ");
		}*/

		return results;
	}

	public void insert(String table, String columns, String[] data) throws SQLException {
		String sql;
		if(columns.isEmpty()){
			sql = "INSERT INTO " + table + " VALUES (";
		} else {
			sql = "INSERT INTO " + table + " (" + columns + " ) VALUES (";
		}

		for(int i = 0; i < data.length; i++){
			if(i == 0){
				sql.concat("?");
			} else {
				sql.concat(", ?");
			}
		}

		sql.concat(")");

		//String sql = "INSERT INTO" + table
	}

	public void update(String table, String columns, String data, String where) throws SQLException {

	}

	public void execute(String procedure, String[] values) throws SQLException {

	}
}
