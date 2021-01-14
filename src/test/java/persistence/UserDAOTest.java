package persistence;

import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
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
	}
}
