package DAO;

import DTO.EventDTO;
import DTO.UserDTO;
import Database.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDAOImpl implements EventDAO{
	private ArrayList<EventDTO> events;
	private Database data;

	public EventDAOImpl(ArrayList<EventDTO> events) {
		this.events = events;
		data = new Database();
	}

	@Override
	public EventDTO[] selectAll() throws SQLException {
		Connection conn = data.verbind();

		ArrayList<EventDTO> events = new ArrayList<>();
		ResultSet rows;
		String table = "Event";
		String columns = "*";

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var id = rows.getInt(1);
			var name = rows.getString(2);
			var DOB = rows.getDate(3);
			var lastname = rows.getString(4);
			var email = rows.getString(5);
			var pass = rows.getString(6);
			var adres = rows.getInt(7);

			UserDTO tempuser = new UserDTO(id, name, lastname, email, DOB, pass, adres);

			users.add(tempuser);
		}

		data.closeConnection(conn);

		UserDTO[] returnValues = users.toArray(new UserDTO[users.size()]);

		return returnValues;
	}

	@Override
	public EventDTO selectId(int id) throws SQLException {
		return null;
	}

	@Override
	public EventDTO[] selectWhere(String[] statements, String[] values) throws SQLException {
		return new EventDTO[0];
	}

	@Override
	public void update(String[] tables, String[] values) throws SQLException {

	}

	@Override
	public void insert(String sport, int field, int creator, Date date) throws SQLException {

	}
}
