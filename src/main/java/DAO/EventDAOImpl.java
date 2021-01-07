package dao;

//TODO: fix SQLinjection

import DTO.EventDTO;
import DTO.UserDTO;
import database.Database;

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
			var sport = rows.getString(2);
			var field = rows.getInt(3);
			var creator = rows.getInt(4);
			var date = rows.getDate(5);

			EventDTO tempEvent = new EventDTO(id, sport, field, creator, date);

			events.add(tempEvent);
		}

		data.closeConnection(conn);

		EventDTO[] returnValues = events.toArray(new EventDTO[events.size()]);

		return returnValues;
	}

	@Override
	public EventDTO selectId(int id) throws SQLException {
		Connection conn = data.verbind();

		EventDTO event = null;
		ResultSet rows;
		String table = "Event";
		String columns = "*";

		rows = data.select(table, columns, new String[0], new String[0], conn);

		while (rows.next()){
			var idValue = rows.getInt(1);
			var sport = rows.getString(2);
			var field = rows.getInt(3);
			var creator = rows.getInt(4);
			var date = rows.getDate(5);

			event = new EventDTO(idValue, sport, field, creator, date);
		}

		data.closeConnection(conn);

		return event;
	}

	@Override
	public EventDTO[] selectWhere(String[] statements, String[] values) throws SQLException {
		Connection conn = data.verbind();

		ArrayList<EventDTO> events = new ArrayList<>();
		ResultSet rows;
		String table = "Event";
		String columns = "*";

		rows = data.select(table, columns, statements, values, conn);

		while (rows.next()){
			var id = rows.getInt(1);
			var sport = rows.getString(2);
			var field = rows.getInt(3);
			var creator = rows.getInt(4);
			var date = rows.getDate(5);

			EventDTO tempEvent = new EventDTO(id, sport, field, creator, date);

			events.add(tempEvent);
		}

		data.closeConnection(conn);

		EventDTO[] returnValues = events.toArray(new EventDTO[events.size()]);

		return returnValues;
	}

	@Override
	public void update(EventDTO event) throws SQLException {
		Connection conn = data.verbind();

		String table = "Event";
		String[] columns = {"Sport_naam", "Veld_veldId", "Sporter_SporterId", "datum"};
		String[] dataValues = {event.getSport(), event.getField() + "", event.getCreator() + "", event.getDate() + ""};
		String[] where = {"id = ", "" + event.getId()};

		data.update(table, columns, dataValues, where, conn);

		data.closeConnection(conn);
	}

	@Override
	public void insert(EventDTO event) throws SQLException {
		Connection conn = data.verbind();

		String table = "Sporter";
		String columns = "";
		String[] dataValues = {event.getSport(), event.getField() + "", event.getCreator() + "", event.getDate() + ""};

		data.insert(table, columns, dataValues, conn);

		data.closeConnection(conn);
	}
}
