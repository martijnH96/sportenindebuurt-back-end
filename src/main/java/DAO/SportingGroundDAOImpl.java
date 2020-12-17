package DAO;

import DTO.SportingGroundDTO;
import Database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportingGroundDAOImpl implements SportingGroundDAO{
	//private ArrayList<SportingGroundDTO> sportingGounds;
	private Database data = new Database();

	public SportingGroundDAOImpl() {
	}

	@Override
	public SportingGroundDTO[] selectAll() throws SQLException {
		Connection conn = data.verbind();

		data.closeConnection(conn);

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

	}
}
