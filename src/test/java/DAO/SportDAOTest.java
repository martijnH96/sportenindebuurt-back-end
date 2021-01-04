package DAO;

import DTO.SportDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportDAOTest {
	SportDAOImpl sportDAO;
	public final ExpectedException exception = ExpectedException.none();

	@BeforeEach
	public void setup(){
		//komt nog wel
		sportDAO = new SportDAOImpl();
	}

	@AfterEach
	public void close(){
		//komt nog wel
	}

	@Test
	public void selectAllTest(){
		//arrange
		SportDTO[] sports = null;

		//act
		try {
			sports = sportDAO.selectAll();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertTrue(sports.length >= 1);
	}

	@Test
	public void selectWhereTest(){
		//arrange
		SportDTO[] sports = null;
		String[] wheres = {"naam = "};
		String[] name = {"Tennis"};

		//act
		try {
			sports = sportDAO.selectWhere(wheres, name);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}


		//assert
		Assertions.assertEquals(name[0], sports[0].getName());
	}

	@Test
	public void selectWhereTestNull(){
		//arrange
		SportDTO[] sports = null;
		String[] wheres = {"naam = "};
		String[] name = {"bestaat niet"};

		//act
		try {
			sports = sportDAO.selectWhere(wheres, name);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		//assert
		Assertions.assertEquals(0, sports.length);
	}

	@Test
	public void selectWhereError(){
		//arrange
		SportDTO[] sports = null;
		String[] wheres = {"naam = "};
		String[] name = {"0"};

		//act
		try {
			sports = sportDAO.selectWhere(wheres, name);
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
		SportDTO sport = new SportDTO("test", false, 2, 2);

		//act
		try {
			sportDAO.update(sport);
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
		SportDTO sport = new SportDTO("testSport", false, 2, 2);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try{
			numUsers = sportDAO.selectAll().length;
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try {
			sportDAO.insert(sport);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		try{
			newNumUsers = sportDAO.selectAll().length;
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		Assertions.assertEquals(numUsers + 1, newNumUsers);
	}

	@Test
	public void insertTestDuplicate(){
		//arrange
		Date date = new Date(0);
		SportDTO sport = new SportDTO("Tennis", false, 2, 2);
		int numUsers = 0;
		int newNumUsers = 0;

		//act
		try {
			sportDAO.insert(sport);
		} catch (SQLException sql){
			sql.printStackTrace();
		}

		//assert
		exception.expect(SQLException.class);
	}
}
