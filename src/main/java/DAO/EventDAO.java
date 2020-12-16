package DAO;

import DTO.EventDTO;

public interface EventDAO {
	//select all
	public EventDTO[] selectAll();

	//select specific
	public EventDTO selectId(int id);

	//select on category
	public EventDTO[] selectWhere(String[] statements, String[] values);

	//update
	public void update(String[] tables, String[] values);

	//insert
	public void insert(); //kut t-mobile
}
