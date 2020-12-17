package DAO;

import DTO.SportingGroundDTO;

import java.sql.SQLException;

public interface SportingGroundDAO {
	//select all
	public SportingGroundDTO[] selectAll() throws SQLException;

	//select specific
	public SportingGroundDTO selectID(int id) throws SQLException;

	//select on category
	public SportingGroundDTO[] selectWhere(String[] statements, String[] variables) throws SQLException;

	//update
	public void update(SportingGroundDTO sportingGround);

	//insert new
	public void insert(SportingGroundDTO sportingGround);
	//dit moet nog worden aangepast maar kan nu niets ccontroleren
	//omdat t-mobile er weer uitligt
}
