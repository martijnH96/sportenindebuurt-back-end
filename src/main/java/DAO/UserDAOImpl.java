package DAO;

import DTO.UserDTO;
import Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO{
	private ArrayList<UserDTO> users;
	private Database data;

	public UserDAOImpl() {
		this.users = new ArrayList<>();
		this.data = new Database();
	}

	@Override
	public UserDTO[] selectAll() throws SQLException {
		Connection conn = data.verbind();

		ArrayList<UserDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Sporter";
		String columns = "*";

		rows = data.select(table, columns, null, conn);

		while (rows.next()){
			var id = rows.getInt(1);
			var name = rows.getString(2);
			var DOB = rows.getDate(3);
			var lastname = rows.getString(4);
			var email = rows.getString(5);
			var pass = rows.getString(6);
			var adres = rows.getInt(7);

			UserDTO tempuser = new UserDTO(id, name, lastname, email, DOB, pass, adres);

			users.add(tempuser);
		}

		data.closeConnection(conn);

		UserDTO[] returnValues = users.toArray(new UserDTO[users.size()]);

		return returnValues;
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
