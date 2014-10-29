package com.clek.gef.model;


import java.util.HashSet;

public class Room {
	private int id = 500;
	private int capacity;
	private String roomName;
	private String building;
	
	public Room (){
		
	}
	
	public Room (int capacity, String name, String building){
		this.capacity = capacity;
		this.roomName = name;
		this.building = building;
	}
	
	public int gId(){
		return id;
	}
	
	public String getBuilding(){
		return building;
	}
	
	public void setBuilding(String building){
		this.building = building;
	}
	
	public String getRoomName(){
		return roomName;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
}
