package DTO;

public class LocationDTO {
	private int id;
	private String postalcode;
	private int housenumber;
	private int streetname;

	public LocationDTO(int id, String postalcode, int housenumber, int streetname) {
		this.id = id;
		this.postalcode = postalcode;
		this.housenumber = housenumber;
		this.streetname = streetname;
	}

	public int getId() {
		return id;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public int getHousenumber() {
		return housenumber;
	}

	public int getStreetname() {
		return streetname;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}

	public void setStreetname(int streetname) {
		this.streetname = streetname;
	}
}
