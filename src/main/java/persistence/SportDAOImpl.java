package persistence;

//TODO: fix SQLinjection

import dto.SportDTO;
import persistence.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportDAOImpl{
	ConnectionFactory factory = new ConnectionFactory();

	public SportDTO[] selectAll(){
		return new SportDTO[0];
	}

	public SportDTO selectOnName(){
		SportDTO stop = null;
		return stop;
	}

	public SportDTO selectOnEmail(){
		SportDTO stop = null;
		return stop;
	}

	public int update(SportDTO sport){
		return 0;
	}

	public int delete(SportDTO sport){
		return 0;
	}
}
