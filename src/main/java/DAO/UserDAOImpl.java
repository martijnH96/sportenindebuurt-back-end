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

		rows = data.select(table, columns, null, null, conn);

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
	public UserDTO selectId(int id) throws SQLException {
		Connection conn = data.verbind();

		UserDTO user = null;
		ResultSet rows;
		String table = "Sporter";
		String columns = "*";
		String[] where = {"id = "};
		String[] idValues = {"" + id};

		rows = data.select(table, columns, where, idValues, conn);

		while (rows.next()){
			//var id = rows.getInt(1);
			var name = rows.getString(2);
			var DOB = rows.getDate(3);
			var lastname = rows.getString(4);
			var email = rows.getString(5);
			var pass = rows.getString(6);
			var adres = rows.getInt(7);

			user = new UserDTO(id, name, lastname, email, DOB, pass, adres);
		}

		data.closeConnection(conn);

		if(user == null) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public UserDTO[] selectWhere(String[] statements, String[] variables) throws SQLException {
		Connection conn = data.verbind();

		ArrayList<UserDTO> users = new ArrayList<>();
		ResultSet rows;
		String table = "Sporter";
		String columns = "*";

		rows = data.select(table, columns, statements, variables, conn);

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
	public void updateUser(UserDTO user) throws SQLException {
		Connection conn = data.verbind();

		String table = "Sporter";
		String[] tables = {"naam", "DateOdBirth", "achternaam", "email", "wachtwoord", "Locatie_adresNr"};
		String[] dataValues = {user.getName(), user.getDateOfBirth() + "", user.getLastname(), user.getEmail(),
				user.getPassword(), user.getAdres() + ""};
		String[] where = {"id = ", "" + user.getID()};

		data.closeConnection(conn);
	}

	@Override
	public void newUser(UserDTO user) {

	}
}
