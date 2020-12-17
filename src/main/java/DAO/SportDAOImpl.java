package DAO;

import DTO.LocationDTO;
import DTO.SportDTO;
import Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportDAOImpl implements SportDAO{
	private ArrayList<SportDTO> sports;
	private Database data;

	public SportDAOImpl(ArrayList<SportDTO> sports) {
		this.sports = sports;
		this.data = new Database();
	}

	@Override
	public SportDTO[] selectAll() throws SQLException {
		Connection conn = data.verbind();

		ArrayList<SportDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Locatie";
		String columns = "*";

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var name = rows.getString(1);
			var isTeam = rows.getBoolean(2);
			var maxSpelers = rows.getInt(3);
			var minSpelers = rows.getInt(4);

			SportDTO tempSport = new SportDTO(name, isTeam, maxSpelers, minSpelers);

			users.add(tempSport);
		}

		data.closeConnection(conn);

		SportDTO[] returnValues = users.toArray(new SportDTO[users.size()]);

		return returnValues;
	}

	@Override
	public SportDTO selectId(int id) throws SQLException {
		Connection conn = data.verbind();

		SportDTO sport = null;
		ResultSet rows;
		String table = "Locatie";
		String columns = "*";

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var name = rows.getString(1);
			var isTeam = rows.getBoolean(2);
			var maxSpelers = rows.getInt(3);
			var minSpelers = rows.getInt(4);

			sport = new SportDTO(name, isTeam, maxSpelers, minSpelers);
		}

		data.closeConnection(conn);

		return sport;
	}

	@Override
	public SportDTO[] selectWhere(String[] statements, String[] variables) throws SQLException {
		Connection conn = data.verbind();

		ArrayList<SportDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Locatie";
		String columns = "*";

		rows = data.select(table, columns, statements, variables, conn);

		while (rows.next()){
			var name = rows.getString(1);
			var isTeam = rows.getBoolean(2);
			var maxSpelers = rows.getInt(3);
			var minSpelers = rows.getInt(4);

			SportDTO tempSport = new SportDTO(name, isTeam, maxSpelers, minSpelers);

			users.add(tempSport);
		}

		data.closeConnection(conn);

		SportDTO[] returnValues = users.toArray(new SportDTO[users.size()]);

		return returnValues;
	}

	@Override
	public void newSport() throws SQLException {

	}

	@Override
	public void update(String[] tables, String[] values) throws SQLException{

	}
}
