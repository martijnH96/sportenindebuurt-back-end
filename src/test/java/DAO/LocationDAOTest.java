package DAO;

import DTO.LocationDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocationDAOTest {
	LocationDAOImpl locationDAO;
	public final ExpectedException exception = ExpectedException.none();

	@BeforeEach
	public void setup(){
		//komt nog wel
		locationDAO = new LocationDAOImpl();
	}

	@AfterEach
	public void close(){
		//komt nog wel
	}

	@Test
	public void selectAllTest(){
		//arrange
		LocationDTO[] locations = null;

		//act
		try {
			locations = locationDAO.selectAll();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertTrue(locations.length >= 1);
	}

	@Test
	public void selectIdTest(){
		//arrange
		LocationDTO location = null;

		//act
		try {
			location = locationDAO.selectId(2);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		Assertions.assertEquals(2, location.getId());
	}

	@Test
	public void selectIdTestNull(){
		//arrange
		LocationDTO location = null;

		//act
		try {
			location = locationDAO.selectId(0);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		Assertions.assertNull(location);
	}

	@Test
	public void selectWhereTest(){
		//arrange
		LocationDTO[] locations = null;
		String[] wheres = {"postcode = "};
		String[] email = {"6826CC"};

		//act
		try {
			locations = locationDAO.selectWhere(wheres, email);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertEquals(email[0], locations[0].getPostalcode());
	}

	@Test
	public void selectWhereTestNull(){
		//arrange
		LocationDTO[] locations = null;
		String[] wheres = {"postcode = "};
		String[] email = {"test"};

		//act
		try {
			locations = locationDAO.selectWhere(wheres, email);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertEquals(0, locations.length);
	}

	@Test
	public void selectWhereError(){
		//arrange
		LocationDTO[] locations = null;
		String[] wheres = {"id = "};
		String[] email = {"0"};

		//act
		try {
			locations = locationDAO.selectWhere(wheres, email);
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
		LocationDTO location = new LocationDTO(3, "tests", 69, "testStraat");

		//act
		try {
			locationDAO.update(location);
		} catch (SQLException sql){
			sql.printStackTrace();
			Assertions.fail();
		}

		//assert
		//heb geen assert die ik hier kan gebruiken
	}

	@Test
	public void insertTest(){
		//arrange
		Date date = new Date(0);
		LocationDTO location = new LocationDTO(0, "tests", 420, "Teststraat");
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try{
			numUsers = locationDAO.selectAll().length;
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try {
			locationDAO.insert(location);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try{
			newNumUsers = locationDAO.selectAll().length;
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
		LocationDTO location = new LocationDTO(3, "tests", 69, "testStraat");
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try {
			locationDAO.insert(location);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}
}
