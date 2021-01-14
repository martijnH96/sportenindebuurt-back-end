package persistence;

import dto.UserDTO;
import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

public class UserDAOTest {
	private UserDAOImpl sut; //system under test

	@BeforeEach
	public void before(){
		//mss ooit
		sut = new UserDAOImpl();
	}

	@AfterEach
	public void after(){
		//mss ooit
	}

	private void loadDatabaseFixture(String filename) throws SQLException, sportenInDeBuurtPersistenceException {
		RunScript.execute(new ConnectionFactory().getConnection(),
				new InputStreamReader(this.getClass().getResourceAsStream("/fixtures/" + filename)));
	}

	//hier komen de tests
	@Test
	public void selectAllTest() throws Exception {
		loadDatabaseFixture("UserBaseData.sql");
		var actualUsers = sut.selectAll();
		Assertions.assertEquals(2, actualUsers.size());
		Assertions.assertEquals("martijn", actualUsers.get(0).getUser());
		Assertions.assertEquals("tester", actualUsers.get(1).getUser());
	}

	@Test
	public void selectOnEmailTest() throws Exception {
		loadDatabaseFixture("UserBaseData.sql");
		var actualUser = sut.selectOnEmail("testertest@gmail.com");
		var wanetedUser = new UserDTO(2, "tester", "test", "testertest@gmail.com", Date.valueOf("1970-01-01"), "test", 1);
		Assertions.assertEquals(wanetedUser, actualUser);
	}

	@Test
	public void selectOnId() throws Exception {
		loadDatabaseFixture("UserBaseData.sql");
		var actualUser = sut.selectOnId(2);
		var wanetedUser = new UserDTO(2, "tester", "test", "testertest@gmail.com", Date.valueOf("1970-01-01"), "test", 1);
		Assertions.assertEquals(wanetedUser, actualUser);
	}

	@Test
	public void updateTest() throws Exception {
		loadDatabaseFixture("UserBaseData.sql");
		var useerBeforeUpdate = new UserDTO(2, "tester", "test", "testertest@gmail.com", Date.valueOf("1970-01-01"), "test", 1);
		var userToUpdate = new UserDTO(2, "testers", "test", "testertest@gmail.com", Date.valueOf("1970-01-01"), "test", 1);
		sut.update(userToUpdate);
		var userAfterUpdate = sut.selectAll();
		Assertions.assertTrue(userAfterUpdate.contains(userToUpdate));

	}

	@Test
	public void updatedUserDoesNoteExit() throws Exception {
		loadDatabaseFixture("UserBaseData.sql");
	}

	@Test
	public void deleteTest() throws Exception {
		loadDatabaseFixture("UserBaseData.sql");
	}

	@Test
	public void deletedUserDoesNotExist() throws Exception {
		loadDatabaseFixture("UserBaseData.sql");
	}
}
