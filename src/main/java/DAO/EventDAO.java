package DAO;

import DTO.EventDTO;

import java.sql.Date;

public interface EventDAO {
	//select all
	public EventDTO[] selectAll();

	//select specific
	public EventDTO selectId(int id);

	//select on category
	public EventDTO[] selectWhere(String[] statements, String[] values);

	//update
	public void update(EventDTO event);

	//insert
	public void insert(EventDTO event);
}
