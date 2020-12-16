package DAO;

import DTO.SportingGroundDTO;
import Database.Database;

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
	public SportingGroundDTO[] selectWhere(String where) {
		return new SportingGroundDTO[0];
	}

	@Override
	public void update(String[] tables, String[] values) {

	}

	@Override
	public void newSportingGround() {

	}
}
