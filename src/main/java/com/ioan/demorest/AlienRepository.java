package com.ioan.demorest;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

public class AlienRepository {
	
	private final String url = "jdbc:postgresql://localhost:5432/aliens";
	private Connection connection = null;
	
	public AlienRepository() {
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "ioan");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		
		try {
			connection = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Alien> getAliens() {
		System.out.println("Fetch aliens from DB");
	
		List<Alien> aliens = new ArrayList<Alien>();
		String sql = "SELECT * FROM aliens";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);	
			
			while(resultSet.next()) {
				Alien tempAlien = new Alien();
				tempAlien.setId(resultSet.getInt(1));
				tempAlien.setName(resultSet.getString(2));
				tempAlien.setPoints(resultSet.getInt(3));
				
				aliens.add(tempAlien);
			}
		} catch(Exception e) {
			System.out.println("Statement error GET ALL, " + e);
		}
		
		return aliens;
	}

	public Alien getAlien(int id) {
		System.out.println("Fetch an alien by ID from DB");
		
		String sql = "SELECT * FROM aliens WHERE id=" + id;
		Alien tempAlien = new Alien();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);	
			
			if(resultSet.next()) {
				tempAlien.setId(resultSet.getInt(1));
				tempAlien.setName(resultSet.getString(2));
				tempAlien.setPoints(resultSet.getInt(3));
			}
		} catch(Exception e) {
			System.out.println("Statement error GET by ID, " + e);
		}
		
		return tempAlien;
	}
	
	public void create(Alien newAlien) {
		String sql = "INSERT INTO aliens values (?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, newAlien.getId());
			statement.setString(2, newAlien.getName());
			statement.setInt(3, newAlien.getPoints());
			
			statement.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("Statement error for CREATE, " + e);
		}
	}
	
	public void update(Alien newAlien) {
		String sql = "UPDATE aliens set name=?, points=? where id=?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, newAlien.getName());
			statement.setInt(2, newAlien.getPoints());
			statement.setInt(3, newAlien.getId());
			
			statement.executeUpdate();
		} catch(Exception e) {
			System.out.println("Statement error for UPDATE, " + e);
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM aliens WHERE id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Statement error for DELETE, " + e);
		}
	}
}
