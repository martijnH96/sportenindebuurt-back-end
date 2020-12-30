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
		try {
			user = userDAO.selectId(2);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		System.out.println(user.getName());

		//assert
		Assertions.assertTrue(user.getID() == 2);
	}

	@Test
	public void selectIdTestNull(){
		//arrange
		UserDTO user = null;

		//act
		try {
			user = userDAO.selectId(0);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		Assertions.assertTrue(user == null);
	}

	@Test
	public void selectWhereTest(){
		//arrange
		UserDTO[] users = null;
		String[] wheres = {"email = "};
		String[] email = {"testertest@gmail.com"};

		//act
		try {
			users = userDAO.selectWhere(wheres, email);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		System.out.println(users[0].getEmail());

		//assert
		Assertions.assertTrue(email[0] == users[0].getEmail());
	}

	@Test
	public void selectWhereTestError(){
		//arrange

		//act

		//assert
	}
}
