package Database;

import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

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

		//act

		//assert
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