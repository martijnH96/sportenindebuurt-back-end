package dao;

import dto.EventDTO;

import java.sql.Date;
import java.sql.SQLException;

public interface EventDAO {
	//select all
	public EventDTO[] selectAll() throws SQLException;

	//select specific
	public EventDTO selectId(int id) throws SQLException;

	//select on category
	public EventDTO[] selectWhere(String[] statements, String[] values) throws SQLException;

	//update
	public void update(EventDTO event) throws SQLException;

	//insert
	public void insert(EventDTO event) throws SQLException;
}
