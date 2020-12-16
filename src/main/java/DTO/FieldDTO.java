package DTO;

public class FieldDTO {
	private String sport;
	private int Capacity;

	public FieldDTO(String sport, int capacity) {
		this.sport = sport;
		Capacity = capacity;
	}

	public String getSport() {
		return sport;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
}
