package DAO;

import DTO.FieldDTO;
import DTO.UserDTO;
import Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FieldDAOImpl implements FieldDAO{
	private ArrayList<FieldDTO> Fields;
	private Database data;

	public FieldDAOImpl(ArrayList<FieldDTO> fields) {
		Fields = fields;
		data = new Database();
	}

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
	public void update(FieldDTO field) {

	}

	@Override
	public void insert(FieldDTO field) {

	}
}
