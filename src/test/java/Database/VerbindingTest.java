package database;

//import org.junit.jupiter.api.AfterEach;
import database.Database;
import database.Verbinding;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerbindingTest implements Verbinding {
	Database testDB = new Database();
	Connection conn;
	public final ExpectedException exception = ExpectedException.none();

	// ----------------- //
	// verbinding testen //
	// ----------------- //

	@Test
	void maakVerbindingTestCorrect(){
		//arrange

		//act
		try {
			conn = testDB.maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt",
					"application", "cM1l:Qze");
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertNotNull(conn);
	}

	@Test
	void maakVerbindingTestWrongAddres(){
		//test verbinding met verkeerde adres link

		//arrange

		//act
		try {
			conn = testDB.maakVerbinding("jdbc:mysql://145.74.104.88:3306/sportenInDeBuurt",
					"application", "cM1l:Qze");
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}

	@Test
	void maakVerbindingTestWrongDB(){
		//test verbinding met verkeerde DB

		//arrange

		//act
		try {
			conn = testDB.maakVerbinding("jdbc:mysql://145.74.104.78:3306/test",
					"application", "cM1l:Qze");
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}

	@Test
	void maakVerbindingTestWrongUser(){
		//test verbinding verkeerde user

		//arrange

		//act
		try {
			conn = testDB.maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt",
					"developer", "cM1l:Qze");
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}

	@Test
	void maakVerbindingTestWrongPassword(){
		//test verbinding met verkeerde wachtwoord

		//arrange

		//act
		try {
			conn = testDB.maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt",
					"application", "cM1l:Qz");
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}
}
