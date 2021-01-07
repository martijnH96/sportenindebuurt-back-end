package dao;

//TODO: fix SQLinjection

import dto.SportingGroundDTO;
import database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
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

		ArrayList<SportingGroundDTO> results = new ArrayList<>();
		ResultSet rows;
		String table = "SportGelegenheid";
		String columns = "*";

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var id = rows.getInt(1);
			var name = rows.getString(2);
			var capacity = rows.getInt(3);
			var adres = rows.getInt(4);

			SportingGroundDTO tempRow = new SportingGroundDTO(id, name, adres);

			results.add(tempRow);
		}

		data.closeConnection(conn);

		SportingGroundDTO[] grounds = results.toArray(new SportingGroundDTO[results.size()]);

		return grounds;
	}

	@Override
	public SportingGroundDTO selectID(int id) throws SQLException {
		Connection conn = data.verbind();

		SportingGroundDTO results = null;
		ResultSet rows;
		String table = "SportGelegenheid";
		String columns = "*";
		String[] whereStat = {"GelegenheidId = "};
		String[] whereValues = {"" + id};

		rows = data.select(table, columns, whereStat, whereValues, conn);

		while (rows.next()){
			//var id = rows.getInt(1);
			var name = rows.getString(2);
			var capacity = rows.getInt(3);
			var adres = rows.getInt(4);

			results = new SportingGroundDTO(id, name, adres);

		}

		data.closeConnection(conn);

		return results;
	}

	@Override
	public SportingGroundDTO[] selectWhere(String[] statements, String[] variables) throws SQLException {
		Connection conn = data.verbind();

		ArrayList<SportingGroundDTO> results = new ArrayList<>();
		ResultSet rows;
		String table = "SportGelegenheid";
		String columns = "*";

		rows = data.select(table, columns, statements, variables, conn);

		while (rows.next()){
			var id = rows.getInt(1);
			var name = rows.getString(2);
			var capacity = rows.getInt(3);
			var adres = rows.getInt(4);

			SportingGroundDTO tempRow = new SportingGroundDTO(id, name, adres);

			results.add(tempRow);
		}

		data.closeConnection(conn);

		SportingGroundDTO[] grounds = results.toArray(new SportingGroundDTO[results.size()]);

		return grounds;
	}

	@Override
	public void update(SportingGroundDTO sportingGround) throws SQLException {
		Connection conn = data.verbind();

		String table = "SportGelegenheid";
		String[] columns = {"naam", "Locatie_adresNr"};
		String[] dataValues = {sportingGround.getName(), "" + sportingGround.getAdres()};
		String[] where = {"GelegenheidId = ", "" + sportingGround.getID()};

		data.update(table, columns, dataValues, where, conn);

		data.closeConnection(conn);
	}

	@Override
	public void insert(SportingGroundDTO sportingGround) throws SQLException {
		Connection conn = data.verbind();

		String table = "SportGelegenheid";
		String columns = "naam, maxPersonen, Locatie_adresNr";
		String[] dataValues = {sportingGround.getName(), "0", sportingGround.getAdres() + ""};
		String[] where = {"id = ", "" + sportingGround.getID()};

		data.insert(table, columns, dataValues, conn);

		data.closeConnection(conn);
	}
}
