package com.clek.gef.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clek.gef.model.Room;

public class RoomDAO {
	private Connection conn;
	
	private void openConn() throws SQLException{
		conn = DriverManager.getConnection("jdbc:derby:MyDB;create=true");
	}
	
	private void closeConn() throws SQLException{
		conn.commit();
		conn.close();
	}
	
	public void persist(Room r) throws SQLException{
		openConn();

		String str = "INSERT INTO GEFDATABASE.ROOM VALUES (?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(str);
		
		stmt.setString(1, r.getRoomName());
		stmt.setString(2, r.getBuilding());
		stmt.setInt(3, r.getCapacity());
		
		stmt.execute();
		
		closeConn();
	}

	public void persist(List<Room> rs) throws SQLException{
		openConn();

		for (Room r : rs){
			String str = "INSERT INTO GEFDATABASE.ROOM VALUES (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(str);

			stmt.setString(1, r.getRoomName());
			stmt.setString(2, r.getBuilding());
			stmt.setInt(3, r.getCapacity());

			stmt.execute();
		}
		closeConn();
	}
	
	public List<Room> getAllRooms() throws SQLException{
		openConn();
		
		String str = "SELECT * FROM GEFDATABASE.ROOM";
		PreparedStatement stmt = conn.prepareStatement(str);
		ResultSet rs = stmt.executeQuery();
		
		List<Room> lstRoom = new ArrayList<Room>();
		while (rs.next()){
			Room r = new Room();
			r.setBuilding(rs.getString("BUILDING"));
			r.setRoomName(rs.getString("CODE_ROOM"));
			r.setCapacity(rs.getInt("CAPACITY"));
			lstRoom.add(r);
		}
		
		closeConn();
		
		return lstRoom;
	}
}
