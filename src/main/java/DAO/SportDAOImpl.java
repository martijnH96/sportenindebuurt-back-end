package DAO;

//TODO: fix SQLinjection

import DTO.LocationDTO;
import DTO.SportDTO;
import Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportDAOImpl implements SportDAO{
	//private ArrayList<SportDTO> sports;
	private Database data = new Database();

	public SportDAOImpl() {}

	@Override
	public SportDTO[] selectAll() throws SQLException {
		Connection conn = data.verbind();

		ArrayList<SportDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Sport";
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
	public SportDTO[] selectWhere(String[] statements, String[] variables) throws SQLException {
		Connection conn = data.verbind();

		ArrayList<SportDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Sport";
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
	public void update(SportDTO sport) throws SQLException{
		Connection conn = data.verbind();

		String table = "Sport";
		String[] columns = {"naam", "isTeamSport", "minSpelers", "maxSpelers"};
		String[] dataValues = {sport.getName(), sport.isTeamSport() + "", "" + sport.getMinPlayers(), "" + sport.getMaxPlayers()};
		String[] where = {"naam = ", sport.getName()};

		data.update(table, columns, dataValues, where, conn);

		data.closeConnection(conn);
	}

	@Override
	public void insert(SportDTO sport) throws SQLException {
		Connection conn = data.verbind();

		String table = "Sport";
		String columns = "";
		String[] dataValues = {sport.getName(), sport.isTeamSport() + "", sport.getMinPlayers() + "", "" + sport.getMaxPlayers()};

		data.insert(table, columns, dataValues, conn);

		data.closeConnection(conn);
	}
}
