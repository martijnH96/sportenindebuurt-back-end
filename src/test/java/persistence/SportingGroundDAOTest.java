package persistence;

import DTO.SportingGroundDTO;
import DTO.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Date;
import java.sql.SQLException;

public class SportingGroundDAOTest {
	SportingGroundDAOImpl sportingGroundDAO;
	public final ExpectedException exception = ExpectedException.none();

	@BeforeEach
	public void setup(){
		//komt nog wel
		sportingGroundDAO = new SportingGroundDAOImpl();
	}

	@AfterEach
	public void close(){
		//komt nog wel
	}

	@Test
	public void selectAllTest(){
		//arrange
		SportingGroundDTO[] sportingGround = null;

		//act
		try {
			sportingGround = sportingGroundDAO.selectAll();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertTrue(sportingGround.length >= 1);
	}

	@Test
	public void selectIdTest(){
		//arrange
		SportingGroundDTO sportingGround = null;

		//act
		try {
			sportingGround = sportingGroundDAO.selectID(1);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		Assertions.assertEquals(1, sportingGround.getID());
	}

	@Test
	public void selectIdTestNull(){
		//arrange
		SportingGroundDTO sportingGround = null;

		//act
		try {
			sportingGround = sportingGroundDAO.selectID(0);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		Assertions.assertNull(sportingGround);
	}

	@Test
	public void selectWhereTest(){
		//arrange
		SportingGroundDTO[] sportingGround = null;
		String[] wheres = {"naam = "};
		String[] naam = {"Park Presikhaaf"};

		//act
		try {
			sportingGround = sportingGroundDAO.selectWhere(wheres, naam); //hoe is selectWhereTest static?
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertEquals(naam[0], sportingGround[0].getName());
	}

	@Test
	public void selectWhereTestNull(){
		//arrange
		SportingGroundDTO[] sportingGround = null;
		String[] wheres = {"GelegenheidId = "};
		String[] email = {"0"};

		//act
		try {
			sportingGround = sportingGroundDAO.selectWhere(wheres, email);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertEquals(0, sportingGround.length);
	}

	@Test
	public void selectWhereError(){
		//arrange
		SportingGroundDTO[] sportingGround;// = null;
		String[] wheres = {"Id = "};
		String[] email = {"0"};

		//act
		try {
			sportingGround = sportingGroundDAO.selectWhere(wheres, email);
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
		SportingGroundDTO sportingGround = new SportingGroundDTO(2, "een test locatie", 1);

		//act
		try {
			sportingGroundDAO.update(sportingGround);
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
		SportingGroundDTO sportingGround = new SportingGroundDTO(0, "een test locatie", 1);

		//act
		try {
			sportingGroundDAO.update(sportingGround);
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
		SportingGroundDTO sportingGround = new SportingGroundDTO(0, "een test locatie", 1);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try{
			numUsers = sportingGroundDAO.selectAll().length;
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try {
			sportingGroundDAO.insert(sportingGround);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try{
			newNumUsers = sportingGroundDAO.selectAll().length;
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
		SportingGroundDTO sportingGround = new SportingGroundDTO(0, "testing Location", 1);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try {
			sportingGroundDAO.insert(sportingGround);
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
		SportingGroundDTO sportingGround = new SportingGroundDTO(0, "een test locatie", 0);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try {
			sportingGroundDAO.insert(sportingGround);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}
}
