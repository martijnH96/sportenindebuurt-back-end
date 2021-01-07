package dao;

import dto.FieldDTO;

import java.sql.SQLException;

public interface FieldDAO {
	//select all
	public FieldDTO[] selectAll() throws SQLException;

	//select specific
	public FieldDTO selectId(int id) throws SQLException;

	//select on category
	public FieldDTO[] selectWhere (String[] statements, String[] values) throws SQLException;

	//update
	public void update(FieldDTO field) throws SQLException;

	//insert
	public void insert(FieldDTO field) throws SQLException;
}
