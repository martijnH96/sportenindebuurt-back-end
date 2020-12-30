package DAO;

import DTO.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOTest {
	UserDAOImpl userDAO;
	public final ExpectedException exception = ExpectedException.none();

	@BeforeEach
	public void setup(){
		//komt nog wel
		userDAO = new UserDAOImpl();
	}

	@AfterEach
	public void close(){
		//komt nog wel
	}

	@Test
	public void selectAllTest(){
		//arrange
		UserDTO[] users = null;

		//act
		try {
			users = userDAO.selectAll();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertTrue(users.length >= 1);
	}

	@Test
	public void selectIdTest(){
		//arrange
		UserDTO user = null;

		//act
		

		//assert
	}

	@Test
	public void selectIdTestNull(){
		//arrange

		//act

		//assert
	}
}
