package com.clek.gef.model;


import java.util.HashSet;

public class Room {
	private int capacity;
	private String roomName;
	private HashSet<StudentsClass> classes;
	
	public Room (){
		
	}
	
	public boolean isFreeTime(ClassTime ct){
		for (StudentsClass st : classes){
			if (st.getClassTime().contains(ct)){
				return false;
			}
		}
		return true;
	}
	
	public Room (int capacity, String name){
		this.capacity = capacity;
		this.roomName = name;
		this.classes = new HashSet<StudentsClass>();
	}
	
	public String getRoomName(){
		return roomName;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	
	public boolean addClass(StudentsClass value){
		return classes.add(value);
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	
	public HashSet<StudentsClass> getClasses(){
		return this.classes;
	}
	
	public void reset(){
		this.classes = new HashSet<StudentsClass>();
	}
	/*
	public String toString(){
		return new StringBuffer(" Room Name : ").append(this.roomName)
				.append(" Capacity : ").append(this.capacity)
				.append(" Classes : ").append(this.classes.toString()).toString();
	}*/
	
}
