package DAO;

import DTO.LocationDTO;
import Database.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class LocationDAOImpl implements LocationDAO{
	Database data = new Database();

	public LocationDAOImpl() {
	}

	@Override
	public LocationDTO[] selectAll() throws SQLException {
		return new LocationDTO[0];
	}

	@Override
	public LocationDTO selectId(int id) throws SQLException {
		return null;
	}

	@Override
	public LocationDTO[] selectWhere(String[] statements, String[] variables) throws SQLException {
		return new LocationDTO[0];
	}

	@Override
	public void update(LocationDTO location) throws SQLException {

	}

	@Override
	public void insert(LocationDTO location) throws SQLException {
		Connection conn = data.verbind();

		String table = "Sporter";
		String columns = "";
		String[] dataValues = {user.getName(), user.getDateOfBirth() + "", user.getLastname(), user.getEmail(),
				user.getPassword(), user.getAdres() + ""};
		String[] where = {"id = ", "" + user.getID()};

		data.insert(table, columns, dataValues, conn);

		data.closeConnection(conn);
	}
}
