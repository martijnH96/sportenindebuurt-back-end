package persistence;

//TODO: fix SQLinjection

import DTO.FieldDTO;
import DTO.UserDTO;
import database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FieldDAOImpl implements FieldDAO{
	private Database data = new Database();

	public FieldDAOImpl() {}

	@Override
	public FieldDTO[] selectAll() throws SQLException {
		Connection conn = data.verbind();

		ArrayList<FieldDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Veld";
		String columns = "*";

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var gelegenheid = rows.getInt(1);
			var sport = rows.getString(2);
			var veldId = rows.getInt(7);

			FieldDTO tempField = new FieldDTO(gelegenheid, sport, veldId);

			users.add(tempField);
		}

		data.closeConnection(conn);

		FieldDTO[] returnValues = users.toArray(new FieldDTO[users.size()]);

		return returnValues;
	}

	@Override
	public FieldDTO selectId(int id) throws SQLException {
		Connection conn = data.verbind();

		FieldDTO field = null;
		ResultSet rows;
		String table = "Veld";
		String columns = "*";
		String[] where = {"VeldId = ", id + ""};

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var gelegenheid = rows.getInt(1);
			var sport = rows.getString(2);
			var veldId = rows.getInt(7);

			field = new FieldDTO(gelegenheid, sport, veldId);
		}

		data.closeConnection(conn);

		return field;
	}

	@Override
	public FieldDTO[] selectWhere(String[] statements, String[] values) throws SQLException {
		Connection conn = data.verbind();

		ArrayList<FieldDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Veld";
		String columns = "*";

		rows = data.select(table, columns, statements, values, conn);

		while (rows.next()){
			var gelegenheid = rows.getInt(1);
			var sport = rows.getString(2);
			var veldId = rows.getInt(7);

			FieldDTO tempField = new FieldDTO(gelegenheid, sport, veldId);

			users.add(tempField);
		}

		data.closeConnection(conn);

		FieldDTO[] returnValues = users.toArray(new FieldDTO[users.size()]);

		return returnValues;
	}

	@Override
	public void update(FieldDTO field) throws SQLException {
		Connection conn = data.verbind();

		String table = "Veld";
		String[] columns = {"SportGelegenheid_GelegenheidId", "Sport_naam"};
		String[] dataValues = {field.getGround() + "", field.getSport()};
		String[] where = {"veldId = ", "" + field.getID()};

		data.update(table, columns, dataValues, where, conn);

		data.closeConnection(conn);
	}

	@Override
	public void insert(FieldDTO field) throws SQLException {
		Connection conn = data.verbind();

		String table = "Veld";
		String columns = "";
		String[] dataValues = {field.getGround() + "", field.getSport()};

		data.insert(table, columns, dataValues, conn);

		data.closeConnection(conn);
	}
}
