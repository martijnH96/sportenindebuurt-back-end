package DTO;

import java.sql.Date;
import java.util.ArrayList;

public class EventDTO {
	private int Id;
	private String sport;
	private int field;
	private int numberOfParticipants;
	private Date date;
	private ArrayList<String> participants;
	private String postalcode;
	private int housenumber;

	public EventDTO(int id, String sport, int field, int numberOfParticipants, Date date,
					ArrayList<String> participants, String postalcode, int housenumber) {
		Id = id;
		this.sport = sport;
		this.field = field;
		this.numberOfParticipants = numberOfParticipants;
		this.date = date;
		this.participants = participants;
		this.postalcode = postalcode;
		this.housenumber = housenumber;
	}

	public int getId() {
		return Id;
	}

	public String getSport() {
		return sport;
	}

	public int getField() {
		return field;
	}

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public Date getDate() {
		return date;
	}

	public ArrayList<String> getParticipants() {
		return participants;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public int getHousenumber() {
		return housenumber;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setField(int field) {
		this.field = field;
	}

	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public void setParticipants(ArrayList<String> participants) {
		this.participants = participants;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}
}
