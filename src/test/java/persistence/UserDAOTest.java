package persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	//hier komen de tests
	@Test
	public void selectAllTest() throws sportenInDeBuurtPersistenceException {
		var actualAccounts = sut.selectAll();
	}
}
