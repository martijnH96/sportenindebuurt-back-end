package Database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTest {
	Database testDB;
	Connection conn;
	public final ExpectedException exception = ExpectedException.none();

	@BeforeEach
	public void setup(){
		testDB = new Database();
		try {
			conn = testDB.maakVerbinding("jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt",
					"application", "cM1l:Qze");
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
	}

	@AfterEach
	public void end(){
		try {
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	//tijd om een test te schrijven
	@Test
	void selectTestRight(){
		//arrange
		String test = "test";
		String columns = "*";
		String[] where = new String[0];
		ResultSet result = null;
		var lines = 0;

		//act
		//voer query uit en krij resultaat
		try {
			result = testDB.select(test, columns, where, conn);

			while (!result.next()) {
				lines++;
				result.getString(2);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		//assert
		//check resultaat met verwachte resultaat
		Assertions.assertEquals(1, lines);
	}

	void selectTestRightWhere(){
		//arrange

		//act

		//assert
	}

	@Test
	void selectTestNoResult(){
		//arrange

		//act

		//assert
	}

	@Test
	void selectTestWrongTable(){
		//arrange

		//act

		//assert
	}

	@Test
	void insertTestRight(){
		//arrange

		//act

		//assert
	}

	@Test
	void insertTestWrongTable(){
		//arrange

		//act

		//assert
	}

	@Test
	void insertTestIllegalInput(){
		//arrange

		//act

		//assert
	}

	@Test
	void insertTestExistingInput(){
		//arrange

		//act

		//assert
	}

	@Test
	void updateTestRight(){
		//arrange

		//act

		//assert
	}

	@Test
	void updateTestRightWhere(){
		//arrange

		//act

		//assert
	}

	@Test
	void updateTestWrongTable(){
		//arrange

		//act

		//assert
	}

	@Test
	void updateTestIllegalInput(){
		//arrange

		//act

		//assert
	}
}