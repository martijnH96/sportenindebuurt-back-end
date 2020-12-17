package DAO;

import DTO.SportDTO;

public interface SportDAO {
	//select all
	public SportDTO[] selectAll();

	//select specific
	public SportDTO selectId(int id);

	//select on category
	public SportDTO[] selectWhere(String[] statements, String[] variables);

	//insert
	public void newSport(SportDTO sport); //zelfde probleem als met sportingground

	//update
	public void update(SportDTO sport);
}
