package dto;

import java.util.ArrayList;

public class SportingGroundDTO {
	private int ID;
	private String name;
	//private ArrayList<Integer> fields;
	private int adres;

	public SportingGroundDTO(int ID, String name, int adres) {
		this.ID = ID;
		this.name = name;
		//this.fields = fields;
		this.adres = adres;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public int getAdres() {
		return adres;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdres(int adres) {
		this.adres = adres;
	}
}
