package DAO;

import DTO.SportDTO;

import java.sql.SQLException;

public interface SportDAO {
	//select all
	public SportDTO[] selectAll() throws SQLException;

	//select on category
	public SportDTO[] selectWhere(String[] statements, String[] variables) throws SQLException;

	//insert
	public void insert(SportDTO sport) throws SQLException; //zelfde probleem als met sportingground

	//update
	public void update(SportDTO sport) throws SQLException;
}
