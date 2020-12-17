package DAO;

import DTO.SportingGroundDTO;
import Database.Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class SportingGroundDAOImpl implements SportingGroundDAO{
	private ArrayList<SportingGroundDTO> sportingGounds;
	private Database data;

	@Override
	public SportingGroundDTO[] selectAll() {
		return new SportingGroundDTO[0];
	}

	@Override
	public SportingGroundDTO selectID(int id) {
		return null;
	}

	@Override
	public SportingGroundDTO[] selectWhere(String[] statements, String[] variables) {
		return new SportingGroundDTO[0];
	}

	@Override
	public void update(SportingGroundDTO sportingGround) {

	}

	@Override
	public void insert(SportingGroundDTO sportingGround) {
		//komt straks wel
	}
}
