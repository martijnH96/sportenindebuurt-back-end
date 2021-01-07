package dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class UserDTO {
	private int ID;
	private String name;
	private String lastname;
	private String email;
	private Date DateOfBirth;
	private String password; //ik weet niet of dit handig is om mee te geven
	private int adres;

	public UserDTO(int ID, String name, String lastname, String email, Date dateOfBirth, String password, int adres) {
		this.ID = ID;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		DateOfBirth = dateOfBirth;
		this.password = password;
		this.adres = adres;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public String getPassword() {
		return password;
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

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdres(int adres) {
		this.adres = adres;
	}
}
