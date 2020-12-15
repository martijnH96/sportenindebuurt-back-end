package DTO;

public class UserDTO {
	private String name;
	private String email;
	private String adres;

	public UserDTO(String name, String email, String adres) {
		this.name = name;
		this.email = email;
		this.adres = adres;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAdres() {
		return adres;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
}
