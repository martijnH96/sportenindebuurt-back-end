package persistence;

//TODO: fix SQLinjection

import dto.SportingGroundDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SportingGroundDAOImpl{
	ConnectionFactory factory = new ConnectionFactory();

	public SportingGroundDTO[] selectAll(){
		return new SportingGroundDTO[0];
	}

	public SportingGroundDTO selectOnId(){
		SportingGroundDTO stop = null;
		return stop;
	}

	public SportingGroundDTO selectOnName(){
		SportingGroundDTO stop = null;
		return stop;
	}

	public int update(SportingGroundDTO sportingGround){
		return 0;
	}

	public int delete(SportingGroundDTO sportingGround){
		return 0;
	}
}
