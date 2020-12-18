package DTO;

import java.sql.Date;
import java.util.ArrayList;

public class EventDTO {
	private int id;
	private String sport;
	private int field;
	private int creator;
	private Date date;

	public EventDTO(int id, String sport, int field, int creator, Date date) {
		this.id = id;
		this.sport = sport;
		this.field = field;
		this.creator = creator;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public String getSport() {
		return sport;
	}

	public int getField() {
		return field;
	}

	public int getCreator() {
		return creator;
	}

	public Date getDate() {
		return date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setField(int field) {
		this.field = field;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
