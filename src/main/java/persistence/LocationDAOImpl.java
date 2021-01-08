package persistence;

//TODO: fix SQLinjection

import dto.LocationDTO;

public class LocationDAOImpl{
	ConnectionFactory factory = new ConnectionFactory();

	public LocationDTO[] selectAll(){
		return new LocationDTO[0];
	}

	public LocationDTO selectOnId(){
		LocationDTO stop = null;
		return stop;
	}

	public LocationDTO selectOnPostalcode(){
		LocationDTO stop = null;
		return stop;
	}

	public int update(LocationDTO location){
		return 0;
	}

	public int delete(LocationDTO location){
		return 0;
	}
}
