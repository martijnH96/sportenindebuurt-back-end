package DAO;

import DTO.LocationDTO;

import Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocationDAOImpl implements LocationDAO{
	Database data = new Database();

	public LocationDAOImpl() {
	}

	@Override
	public LocationDTO[] selectAll() throws SQLException {
		Connection conn = data.verbind();

		ArrayList<LocationDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Locatie";
		String columns = "*";

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var id = rows.getInt(1);
			var postal = rows.getString(2);
			var housenumber = rows.getInt(3);
			var streetname = rows.getString(4);

			LocationDTO templocation = new LocationDTO(id, postal, housenumber, streetname);

			users.add(templocation);
		}

		data.closeConnection(conn);

		LocationDTO[] returnValues = users.toArray(new LocationDTO[users.size()]);

		return returnValues;
	}

	@Override
	public LocationDTO selectId(int id) throws SQLException {
		Connection conn = data.verbind();

		LocationDTO location = null;
		ResultSet rows;
		String table = "Locatie";
		String columns = "*";
		String[] where = {"adresNr = "};
		String[] value = {"1"};

		rows = data.select(table, columns, where, value, conn);

		while (rows.next()){
			var idValue = rows.getInt(1);
			var postal = rows.getString(2);
			var housenumber = rows.getInt(3);
			var streetname = rows.getString(4);

			location = new LocationDTO(idValue, postal, housenumber, streetname);
		}

		data.closeConnection(conn);

		return location;
	}

	@Override
	public LocationDTO[] selectWhere(String[] statements, String[] variables) throws SQLException {
		Connection conn = data.verbind();

		ArrayList<LocationDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Locatie";
		String columns = "*";

		rows = data.select(table, columns, statements, variables, conn);

		while (rows.next()){
			var id = rows.getInt(1);
			var postal = rows.getString(2);
			var housenumber = rows.getInt(3);
			var streetname = rows.getString(4);

			LocationDTO templocation = new LocationDTO(id, postal, housenumber, streetname);

			users.add(templocation);
		}

		data.closeConnection(conn);

		LocationDTO[] returnValues = users.toArray(new LocationDTO[users.size()]);

		return returnValues;
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
