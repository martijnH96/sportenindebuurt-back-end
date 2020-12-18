package DAO;

import DTO.EventDTO;
import Database.Database;

import java.sql.Date;
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
		return new EventDTO[0];
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
