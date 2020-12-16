package DAO;

import DTO.FieldDTO;
import Database.Database;

import java.util.ArrayList;

public class FieldDAOImpl implements FieldDAO{
	private ArrayList<FieldDTO> Fields;
	private Database data;

	public FieldDAOImpl(ArrayList<FieldDTO> fields) {
		Fields = fields;
		data = new Database();
	}

	@Override
	public FieldDTO[] selectAll() {
		return new FieldDTO[0];
	}

	@Override
	public FieldDTO selectId(int id) {
		return null;
	}

	@Override
	public FieldDTO[] selectWhere(String[] statements, String[] values) {
		return new FieldDTO[0];
	}

	@Override
	public void update(String[] tables, String[] values) {

	}

	@Override
	public void insert() {

	}
}
