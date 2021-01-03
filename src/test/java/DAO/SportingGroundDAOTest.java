package DAO;

import DTO.SportingGroundDTO;
import DTO.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportingGroundDAOTest {
	SportingGroundDAOTest sportingGround;
	public final ExpectedException exception = ExpectedException.none();

	@BeforeEach
	public void setup(){
		//komt nog wel
		sportingGround = new SportingGroundDAOTest();
	}

	@AfterEach
	public void close(){
		//komt nog wel
	}
}
