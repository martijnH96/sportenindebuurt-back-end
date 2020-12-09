package Database;

import java.sql.Connection;
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

	public void select(String table, String columns, String where){

	}

	public void insert(String table, String columns, String data){

	}

	public void update(String table, String columns, String data, String where){

	}

	public void execute(String procedure, String[] values){
		
	}
}
