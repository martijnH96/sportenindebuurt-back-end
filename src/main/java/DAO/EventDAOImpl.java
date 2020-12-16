package DAO;

import DTO.EventDTO;
import Database.Database;

import java.util.ArrayList;

public class EventDAOImpl implements EventDAO{
	private ArrayList<EventDTO> events;
	private Database data;

	public EventDAOImpl(ArrayList<EventDTO> events) {
		this.events = events;
		data = new Database();
	}

	@Override
	public EventDTO[] selectAll() {
		return new EventDTO[0];
	}

	@Override
	public EventDTO selectId(int id) {
		return null;
	}

	@Override
	public EventDTO[] selectWhere(String[] statements, String[] values) {
		return new EventDTO[0];
	}

	@Override
	public void update(String[] tables, String[] values) {

	}

	@Override
	public void insert() {

	}
}
