package DAO;

import DTO.UserDTO;

import java.sql.SQLException;

public interface UserDAO {
	//select all users
	public UserDTO[] selectAll() throws SQLException;

	//select singular user (id)
	public UserDTO selectId(int id) throws SQLException;

	//select user using where
	public UserDTO[] selectWhere(String[] statements, String[] variables) throws SQLException;

	//update user
	public void updateUser(UserDTO user);

	//insert new user
	public void newUser(UserDTO user);
}
