package DTO;

public class FieldDTO {
	private int ID;
	private String sport;
	private int Capacity;

	public FieldDTO(int ID, String sport, int capacity) {
		this.ID = ID;
		this.sport = sport;
		Capacity = capacity;
	}

	public int getID() {
		return ID;
	}

	public String getSport() {
		return sport;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
}
