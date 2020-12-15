package DTO;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class UserDTO {
	private String name; //sporter
	private String lastname; //sporter
	private String mail; //sporter
	private SimpleDateFormat dateOfBirth; //sporter
	private String postalcode; //locatie
	private int houseNumber; //locatie
	private String streetName; //locatie

	public UserDTO(String name, String lastname, String mail, SimpleDateFormat dateOfBirth,
				   String postalcode, int houseNumber, String streetName) {
		this.name = name;
		this.lastname = lastname;
		this.mail = mail;
		this.dateOfBirth = dateOfBirth;
		this.postalcode = postalcode;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMail() {
		return mail;
	}

	public SimpleDateFormat getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setDateOfBirth(SimpleDateFormat dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
}
