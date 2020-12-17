package DAO;

import DTO.UserDTO;

import java.sql.SQLException;

public interface UserDAO {
	//select all users
	public UserDTO[] selectAll() throws SQLException;

	//select singular user (id)
	public UserDTO selectId(int id);

	//select user using where
	public UserDTO[] selectWhere(String[] statements, String[] variables);

	//update user
	public void updateUser(String[] tables, String[] newValues, int id);

	//update user addres
	public void updateAdres(String postcode, String street, int housenumber);

	//insert new user
	public void newUser(String name, String lastname, String mail, String DOB, int adres);
}
