package DAO;

import DTO.SportDTO;

public interface SportDAO {
	//select all
	public SportDTO[] selectAll();

	//select specific
	public SportDTO selectId(int id);

	//select on category
	public SportDTO[] selectWhere()

	//insert

	//update
}
