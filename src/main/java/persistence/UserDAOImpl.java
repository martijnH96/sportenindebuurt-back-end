package persistence;

//TODO: fix SQLinjection

import dto.UserDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl{
	ConnectionFactory factory = new ConnectionFactory();

	public UserDTO[] selectAll(){
		return new UserDTO[0];
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
