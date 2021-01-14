package persistence;

//TODO: fix SQLinjection

import dto.UserDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl{
	ConnectionFactory factory = new ConnectionFactory();

	public List<UserDTO> selectAll() throws sportenInDeBuurtPersistenceException {
		ArrayList<UserDTO> users = new ArrayList<>();

		try (
				var con = factory.getConnection();
				var stmt = con.prepareStatement("SELECT * FROM Sporter")
		) {
			var resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				users.add(new UserDTO(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getDate(3),
						resultSet.getString(6),
						resultSet.getInt(7)
				));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new sportenInDeBuurtPersistenceException(e);
		}

		return users;
	}

	public UserDTO selectOnId(){
		UserDTO stop = null;
		return stop;
	}

	public UserDTO selectOnEmail(){
		UserDTO stop = null;
		return stop;
	}

	public int update(UserDTO user){
		return 0;
	}

	public int delete(UserDTO user){
		return 0;
	}
}
