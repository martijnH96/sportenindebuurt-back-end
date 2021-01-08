package persistence;

//TODO: fix SQLinjection

import dto.FieldDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FieldDAOImpl{
	ConnectionFactory factory = new ConnectionFactory();

	public FieldDTO[] selectAll(){
		return new FieldDTO[0];
	}

	public FieldDTO selectOnId(){
		FieldDTO stop = null;
		return stop;
	}

	public FieldDTO[] selectOnSport(){
		return new FieldDTO[0];
	}

	public FieldDTO[] selectOnCapacity(){
		return new FieldDTO[0];
	}

	public int update(FieldDTO field){
		return 0;
	}

	public int delete(FieldDTO field){
		return 0;
	}
}
