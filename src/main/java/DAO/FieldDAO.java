package DAO;

import DTO.FieldDTO;

public interface FieldDAO {
	//select all
	public FieldDTO[] selectAll();

	//select specific
	public FieldDTO selectId(int id);

	//select on category
	public FieldDTO[] selectWhere (String[] statements, String[] values);

	//update
	public void update(String[] tables, String[] values);

	//insert
	public void insert(int sportingGround, String sport);//nog steeds kut t-mobile
}
