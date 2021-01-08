package persistence;

//TODO: fix SQLinjection

import dto.EventDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDAOImpl{
	ConnectionFactory factory = new ConnectionFactory();

	public EventDTO[] selectAll(){
		return new EventDTO[0];
	}

	public EventDTO selectOnId(){
		EventDTO stop = null;
		return stop;
	}

	public EventDTO[] selectOnCreator(){
		return new EventDTO[0];
	}

	public EventDTO[] selectOnSport(){
		return new EventDTO[0];
	}

	public int update(EventDTO event){
		return 0;
	}

	public int delete(EventDTO event){
		return 0;
	}
}
