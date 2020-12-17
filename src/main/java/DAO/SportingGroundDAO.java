package DAO;

import DTO.SportingGroundDTO;

public interface SportingGroundDAO {
	//select all
	public SportingGroundDTO[] selectAll();

	//select specific
	public SportingGroundDTO selectID(int id);

	//select on category
	public SportingGroundDTO[] selectWhere(String[] statements, String[] variables);

	//update
	public void update(SportingGroundDTO sportingGround);

	//insert new
	public void newSportingGround(SportingGroundDTO sportingGround);
	//dit moet nog worden aangepast maar kan nu niets ccontroleren
	//omdat t-mobile er weer uitligt
}
