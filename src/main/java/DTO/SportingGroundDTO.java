package DTO;

import java.util.ArrayList;

public class SportingGroundDTO {
	private int ID;
	private String name;
	private ArrayList<Integer> fields;
	private String postalcode;
	private int houseNumber;

	public SportingGroundDTO(int ID, String name, ArrayList<Integer> fields, String postalcode, int houseNumber) {
		this.ID = ID;
		this.name = name;
		this.fields = fields;
		this.postalcode = postalcode;
		this.houseNumber = houseNumber;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Integer> getFields() {
		return fields;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFields(ArrayList<Integer> fields) {
		this.fields = fields;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
}
