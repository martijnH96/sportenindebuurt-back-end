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
		Connection conn = data.verbind();

		String table = "Sporter";
		String[] columns = {"postcode", "huisnummer", "straatnaame"};
		String[] dataValues = {location.getPostalcode(), location.getHousenumber() + "", location.getStreetname()};
		String[] where = {"id = ", "" + location.getId()};

		data.update(table, columns, dataValues, where, conn);

		data.closeConnection(conn);
	}

	@Override
	public void insert(LocationDTO location) throws SQLException {
		Connection conn = data.verbind();

		String table = "Sporter";
		String columns = "";
		String[] dataValues = {location.getPostalcode(), location.getHousenumber() + "", location.getStreetname() + ""};

		data.insert(table, columns, dataValues, conn);

		data.closeConnection(conn);
	}
}
