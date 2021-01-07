package dao;

import dto.LocationDTO;

import java.sql.SQLException;

public interface LocationDAO {
	public LocationDTO[] selectAll() throws SQLException;

	public LocationDTO selectId(int id) throws SQLException;

	public LocationDTO[] selectWhere(String[] statements, String[] variables) throws SQLException;

	public void update(LocationDTO location) throws SQLException;

	public void insert(LocationDTO location) throws SQLException;
}
