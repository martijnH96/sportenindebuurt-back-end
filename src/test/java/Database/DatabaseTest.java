package Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTest {
	Database testDB;
	public final ExpectedException exception = ExpectedException.none();

	public void setup(){
		testDB = new Database();
	}

	//tijd om een test te schrijven
	@Test
	void selectTestRight(){
		//arrange
		//maak db aan
		setup();
		String table = "test";
		String columns = "*";
		String[] where = new String[0];
		ResultSet result = null;
		int lines = 0;

		//act
		//voer query uit en krij resultaat
		try {
			result = testDB.select("test", "*", where);

			while (!result.next()) {
				lines++;
				result.getString(2);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		//assert
		//check resultaat met verwachte resultaat
		Assertions.assertTrue(lines > 1);
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