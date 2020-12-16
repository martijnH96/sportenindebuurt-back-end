package DTO;

import java.util.ArrayList;

public class SportingGroundDTO {
	private String name;
	private ArrayList<Integer> fields;
	private String postalcode;
	private int houseNumber;

	public SportingGroundDTO(String name, ArrayList<Integer> fields, String postalcode, int houseNumber) {
		this.name = name;
		this.fields = fields;
		this.postalcode = postalcode;
		this.houseNumber = houseNumber;
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
