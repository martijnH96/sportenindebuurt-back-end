package DTO;

import java.util.ArrayList;

public class EventDTO {
	private String sport;
	private int field;
	private int numberOfParticipants;
	private ArrayList<String> participants;
	private String postalcode;
	private int housenumber;

	public EventDTO(String sport, int field, int numberOfParticipants,
					ArrayList<String> participants, String postalcode, int housenumber) {
		this.sport = sport;
		this.field = field;
		this.numberOfParticipants = numberOfParticipants;
		this.participants = participants;
		this.postalcode = postalcode;
		this.housenumber = housenumber;
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

	public void setField(int field) {
		this.field = field;
	}

	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public void setParticipants(ArrayList<String> participants) {
		this.participants = participants;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}
}
