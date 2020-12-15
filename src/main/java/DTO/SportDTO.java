package DTO;

public class SportDTO {
	private String name;
	private boolean isTeamSport;
	private int maxPlayers;
	private int minPlayers;

	public SportDTO(String name, boolean isTeamSport, int maxPlayers, int minPlayers) {
		this.name = name;
		this.isTeamSport = isTeamSport;
		this.maxPlayers = maxPlayers;
		this.minPlayers = minPlayers;
	}

	public String getName() {
		return name;
	}

	public boolean isTeamSport() {
		return isTeamSport;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeamSport(boolean teamSport) {
		isTeamSport = teamSport;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
}
