package clek.model;

import java.util.HashMap;

public class Room {
	private int capacity;
	private String roomName;
	private HashMap<ClassTime, StudentsClass> classes;
	
	public Room (){
		
	}
	
	public Room (int capacity, String name){
		this.capacity = capacity;
		this.roomName = name;
		this.classes = new HashMap<ClassTime, StudentsClass>();
	}
	
	public String getRoomName(){
		return roomName;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	
	public StudentsClass addClass(ClassTime key, StudentsClass value){
		return classes.put(key, value);
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	
	public HashMap<ClassTime, StudentsClass> geClasses(){
		return this.classes;
	}
	
	public void reset(){
		this.classes = new HashMap<ClassTime, StudentsClass>();
	}
	/*
	public String toString(){
		return new StringBuffer(" Room Name : ").append(this.roomName)
				.append(" Capacity : ").append(this.capacity)
				.append(" Classes : ").append(this.classes.toString()).toString();
	}*/
	
}
