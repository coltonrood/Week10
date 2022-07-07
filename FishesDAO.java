package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Fishes;

public class FishesDAO {
	
	private Connection connection;
	
	private final String GET_FISHES_QUERY = "SELECT * FROM fishes";
	
	private final String CREATE_NEW_FISH_QUERY = "INSERT INTO fishes(name) VALUES (?)";
	
	private final String DELETE_FISH_BY_ID_QUERY = "DELETE FROM fishes WHERE id = ?";
	
	
	public FishesDAO() {
		connection = DBConnection.getConnection();	
	}

	public List<Fishes> getFish() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_FISHES_QUERY).executeQuery();
		List<Fishes> fish = new ArrayList<Fishes>();
	
		while (rs.next()) {
			fish.add(populateFishes(rs.getInt(1), rs.getString(2)));
		}
	return fish;
	}
	
	private Fishes populateFishes(int id, String name) {
		return new Fishes(id, name);
	}
	
	public void createFish(String fishName) throws SQLException {
	PreparedStatement ps = connection.prepareStatement(CREATE_NEW_FISH_QUERY);
	ps.setString(1, fishName);
	ps.executeUpdate();
	}
	
	public void deleteFish(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_FISH_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	
}
}