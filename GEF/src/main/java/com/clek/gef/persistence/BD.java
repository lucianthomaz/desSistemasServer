package com.clek.gef.persistence;

import java.util.ArrayList;

import com.clek.gef.model.*;

public class BD {
	public ArrayList<Room> listRooms;
	public ArrayList<StudentsClass> listStudentsClass;
	public ArrayList<Course> listCourse;
	
	private static BD instance;
	
	private BD(){
		listRooms = new ArrayList<Room>();
		listStudentsClass = new ArrayList<StudentsClass>();
		listCourse = new ArrayList<Course>();
	}
	
	public static synchronized BD getInstance(){
		if (instance == null){
			instance = new BD();
		}
		return instance;
	}
	
	public static synchronized void setInstance(BD inst){
		instance = inst;
	}
	
	public void populate(BD bd){
		this.listCourse = bd.listCourse;
		this.listRooms = bd.listRooms;
		this.listStudentsClass = bd.listStudentsClass;
	}
	
	public void populate(){
		Room r = new Room(60, "201", "32");
		
		Course c = new Course("3424", 4, "Desenv Sis", 60);
		
		StudentsClass sc = new StudentsClass("128",c);
		
		ClassTime ct1 = new ClassTime(DayOfWeek.MONDAY, Time.J);
		ClassTime ct2 = new ClassTime(DayOfWeek.MONDAY, Time.K);
		ClassTime ct3 = new ClassTime(DayOfWeek.MONDAY, Time.L);
		ClassTime ct4 = new ClassTime(DayOfWeek.MONDAY, Time.M);
		
		sc.addClassTime(ct1);
		sc.addClassTime(ct2);
		sc.addClassTime(ct3);
		sc.addClassTime(ct4);
		
		listCourse.add(c);
		listRooms.add(r);
		listStudentsClass.add(sc);
	}
}
