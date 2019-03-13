package edu.snappydata.offset.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.snappydata.offset.model.StarModel;

@Service
public class SnappyOffsetService {
	private final Connection connection;
	
	public SnappyOffsetService(Connection connection) {
		this.connection = connection;
	}
	
	public List<StarModel> getAll() throws SQLException {
		List<StarModel> listStar = new ArrayList<>();
		String query = "SELECT id, visible_magnitude AS vm, bayer_naming AS bn, distance, name, link"
				+ "FROM EDU.STAR;";
		
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			StarModel star = new StarModel();
			star.setId(resultSet.getString("id"));
			star.setVisibleMagnitude(resultSet.getString("vm"));
			star.setBayerNaming(resultSet.getString("bn"));
			star.setDistance(resultSet.getLong("distance"));
			star.setName(resultSet.getString("name"));
			star.setLink(resultSet.getString("link"));
			listStar.add(star);
		}
		
//		this will return all data found. begin from row number 0 until cursor has no more data
		return listStar;
	}

	public List<StarModel> getByOffset(int skip, int limit) throws SQLException {
		List<StarModel> listStar = new ArrayList<>();
		String query = String.format(""
				+ "SELECT id, visible_magnitude AS vm, bayer_naming AS bn, distance, name, link"
				+ "FROM EDU.STAR "
				+ "OFFSET %s ROWS "
				+ "FETCH NEXT %s ROWS ONLY;", skip, limit);
		
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			StarModel star = new StarModel();
			star.setId(resultSet.getString("id"));
			star.setVisibleMagnitude(resultSet.getString("vm"));
			star.setBayerNaming(resultSet.getString("bn"));
			star.setDistance(resultSet.getLong("distance"));
			star.setName(resultSet.getString("name"));
			star.setLink(resultSet.getString("link"));
			listStar.add(star);
		}
		
//		this will return all data found. begin from row number skip until total row by limit
		return listStar;
	}

}
