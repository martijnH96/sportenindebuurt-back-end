package Database;

//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerbindingTest {
	Connection conn;
	public final ExpectedException exception = ExpectedException.none();

	// ----------------- //
	// verbinding testen //
	// ----------------- //

	@Test
	void maakVerbindingTestCorrect(){
		//test de verbinding juist

	}

	@Test
	void maakVerbindingTestWrongAddres(){
		//test verbinding met verkeerde adres link
	}

	@Test
	void maakVerbindingTestWrongDB(){
		//test verbinding met verkeerde DB
	}

	@Test
	void maakVerbindingTestWrongUser(){
		//test verbinding verkeerde user
	}

	@Test
	void maakVerbindingTestWrongPassword(){
		//test verbinding met verkeerde wachtwoord
	}
}
