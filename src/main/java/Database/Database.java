package database;

import database.Verbinding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

// voorbeeldcode: https://www.javatpoint.com/PreparedStatement-interface

/*
* uitleg voor gebruik van deze class
*
* 1. maak de Database aan, constructor heeft niks nodig
*
* 2. maak een verbinding --> functie verbind
* 	2.1. geeft een Connection terug
*
* 3. voer query uit --> select, insert of update mss komt execute later nog
* 	3.1. select geeft result set terug
* 		3.1.1. zet je result set in een arrayList/array voordat je doorgaat met de met deze handleiding
* 			tip: maak er direct JSON objecten van en zet deze in de arrayList
*
* 4. sluit de verbinding --> twee mogelijkheden
* 	4.1 de functie close Connection geef je de verbinding aan mee
* 	4.2 doe <Connection>.close()
* */

public class Database implements Verbinding {
	//private Connection conn;

	public Database(){
		//niets te doen
	}

	public Connection verbind() throws SQLException {
		return maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt", "application", "cM1l:Qze");
	}

	public void closeConnection(Connection conn) throws SQLException{
		conn.close();
	}

	public ResultSet select(String table, String columns, String[] whereStat, String[] whereValues, Connection conn) throws SQLException {
		//conn = conn = maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt", "application", "cM1l:Qze");

		String sql = "SELECT " + columns + " FROM " + table;

		if(whereStat.length != 0){
			System.out.println("where");
			sql = sql + " WHERE " + whereStat[0] + "?";
			System.out.println(sql);
		}

		PreparedStatement stmt = conn.prepareStatement(sql);

		if(whereValues.length != 0) {

			for (int i = 0; i < whereValues.length; i++){

				//System.out.println("wat gaan we doen?"); //werd geskipt
				if(isInt(whereValues[i])) {
					int inputInt = Integer.parseInt(whereValues[i]);
					stmt.setInt(i + 1, inputInt);
					//System.out.println("ik word geskipt"); //werd geskipt
				} else {
					stmt.setString(i + 1, whereValues[i]);
					//System.out.println("ik word geskipt"); //werd geskipt
				}
			}
			//stmt.setString(1, "*");
			//stmt.setString(1, "Sport");
		}

		System.out.println(sql);

		ResultSet resultSet = stmt.executeQuery();

		return resultSet;
	}

	public int insert(String table, String columns, String[] data, Connection conn) throws SQLException {
		conn = conn = maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt", "application", "cM1l:Qze");

		String sql;
		if(columns.isEmpty()){
			sql = "INSERT INTO " + table + " VALUES (";
		} else {
			sql = "INSERT INTO " + table + " (" + columns + " ) VALUES (";
		}

		for(int i = 0; i < data.length; i++){
			if(i == 0){
				sql = sql + "?";
			} else {
				sql = sql + ", ?";
			}
		}

		sql = sql + ")";

		PreparedStatement stmt = conn.prepareStatement(sql);
		//System.out.println("perpared");

		for(int i = 0; i < data.length; i++){
			stmt.setString(i + 1, data[i]);
		}

		System.out.println(sql);

		int i = stmt.executeUpdate();

		conn.close();

		return i;
	}

	public int update(String table, String[] columns, String[] data, String[] where, Connection conn) throws SQLException {
		conn = conn = maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt", "application", "cM1l:Qze");

		String sql = "UPDATE " + table + " SET ";

		for (int i = 0; i < data.length; i++){
			if (i == 0){
				sql = sql + columns[i] + " = ?";
			} else {
				sql = sql + ", " + columns[i] + " = ?";
			}
		}

		if(where.length != 0){
			sql = sql + (" WHERE " + where[0] + "?");
		}

		PreparedStatement stmt = conn.prepareStatement(sql);

		/* voorbeeld
		stmt.setString(1,"tennis");
		stmt.setInt(2, 2);
		stmt.setString(3,"niets");
		 */

		System.out.println(sql);

		for (int i = 0; i < data.length; i++){
			stmt.setString(i + 1, data[i]);
		}

		if(where.length != 0){
			//System.out.println();
			stmt.setString(data.length + 1, where[1]);
		}



		int i = stmt.executeUpdate();

		conn.close();

		return 0;//i;
	}

	private static boolean isInt(String input) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);

		return pattern.matcher(input).matches();
	}

	/*
	public void execute(String procedure, String[] values, Connection conn) throws SQLException {
		//komt mischien later
	}
	*/
}
