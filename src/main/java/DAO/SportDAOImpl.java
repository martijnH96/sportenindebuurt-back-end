package DAO;

import DTO.SportDTO;
import Database.Database;

import java.util.ArrayList;

public class SportDAOImpl implements SportDAO{
	private ArrayList<SportDTO> sports;
	private Database data;

	public SportDAOImpl(ArrayList<SportDTO> sports) {
		this.sports = sports;
		this.data = new Database();
	}

	@Override
	public SportDTO[] selectAll() {
		return new SportDTO[0];
	}

	@Override
	public SportDTO selectId(int id) {
		return null;
	}

	@Override
	public SportDTO[] selectWhere(String[] statements, String[] variables) {
		return new SportDTO[0];
	}

	@Override
	public void newSport() {

	}

	@Override
	public void update(String[] tables, String[] values) {

	}
}
