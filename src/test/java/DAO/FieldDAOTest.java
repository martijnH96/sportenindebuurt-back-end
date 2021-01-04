package DAO;

import DTO.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class FieldDAOTest {
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
		Assertions.assertEquals(2, user.getID());
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
		Assertions.assertNull(user);
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
		Assertions.assertEquals(email[0], users[0].getEmail());
	}

	@Test
	public void selectWhereTestNull(){
		//arrange
		UserDTO[] users = null;
		String[] wheres = {"SporterId = "};
		String[] email = {"0"};

		//act
		try {
			users = userDAO.selectWhere(wheres, email);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertEquals(0, users.length);
	}

	@Test
	public void selectWhereError(){
		//arrange
		UserDTO[] users;// = null;
		String[] wheres = {"id = "};
		String[] email = {"0"};

		//act
		try {
			users = userDAO.selectWhere(wheres, email);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}

	@Test
	public void updateTest(){
		//arrange
		Date date = new Date(0);
		UserDTO user = new UserDTO(2, "tester", "test", "testertest@gmail.com", date, "test", 1);

		//act
		try {
			userDAO.update(user);
		} catch (SQLException sql){
			sql.printStackTrace();
			Assertions.fail();
		}

		//assert
		//heb geen assert die ik hier kan gebruiken
	}

	@Test
	public void updateTestWrongData(){
		//arrange
		Date date = new Date(0);
		UserDTO user = new UserDTO(2, "tester", "test", "testertest@gmail.com", date, "test", 0);

		//act
		try {
			userDAO.update(user);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}

	@Test
	public void insertTest(){
		//arrange
		Date date = new Date(0);
		UserDTO user = new UserDTO(0, "tester", "test", "testerstests@gmail.com", date, "test", 1);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try{
			numUsers = userDAO.selectAll().length;
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try {
			userDAO.insert(user);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try{
			newNumUsers = userDAO.selectAll().length;
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		Assertions.assertEquals(numUsers + 1, newNumUsers);
	}

	@Test
	public void insetTestDuplicate(){
		//arrange
		Date date = new Date(0);
		UserDTO user = new UserDTO(0, "tester", "test", "testerstests@gmail.com", date, "test", 1);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try {
			userDAO.insert(user);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}

	@Test
	public void insertTestInvalidData(){
		//arrange
		Date date = new Date(0);
		UserDTO user = new UserDTO(0, "tester", "test", "testertest@gmail.com", date, "test", 0);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try {
			userDAO.insert(user);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}
}
