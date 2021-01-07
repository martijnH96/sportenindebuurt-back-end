package dto;

public class FieldDTO {
	private int ID;
	private String sport;
	private int ground;

	public FieldDTO(int ID, String sport, int ground) {
		this.ID = ID;
		this.sport = sport;
		this.ground = ground;
	}

	public int getID() {
		return ID;
	}

	public String getSport() {
		return sport;
	}

	public int getGround() {
		return ground;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setGround(int capacity) {
		this.ground = ground;
	}
}
