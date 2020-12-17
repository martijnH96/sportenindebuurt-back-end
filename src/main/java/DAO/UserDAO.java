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
	public void updateUser(String[] tables, String[] newValues, int id);

	//insert new user
	public void newUser(String name, String lastname, String mail, String DOB, int adres);
}
