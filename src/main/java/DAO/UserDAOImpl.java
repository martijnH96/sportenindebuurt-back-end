package DAO;

import DTO.UserDTO;
import Database.Database;

import java.util.ArrayList;

public class UserDAOImpl implements UserDAO{
	private ArrayList<UserDTO> users;
	private Database data;

	public UserDAOImpl(ArrayList<UserDTO> users) {
		this.users = users;
		this.data = new Database();
	}

	@Override
	public UserDTO[] selectAll() {
		return new UserDTO[0];
	}

	@Override
	public UserDTO selectId(int id) {
		return null;
	}

	@Override
	public UserDTO[] selectWhere(String[] statements, String[] variables) {
		return new UserDTO[0];
	}

	@Override
	public void updateUser(String[] tables, String[] newValues, int id) {

	}

	@Override
	public void updateAdres(String postcode, String street, int housenumber) {

	}

	@Override
	public void newUser(String name, String lastname, String mail, String DOB, int adres) {

	}
}
