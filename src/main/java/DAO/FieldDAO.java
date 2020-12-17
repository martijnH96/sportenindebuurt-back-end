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
	public void update(FieldDTO field);

	//insert
	public void insert(FieldDTO field);//nog steeds kut t-mobile
}
