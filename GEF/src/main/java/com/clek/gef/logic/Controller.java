package com.clek.gef.logic;

import java.sql.SQLException;

import com.clek.gef.model.Bulk;
import com.clek.gef.model.Room;
import com.clek.gef.persistence.DBException;
import com.clek.gef.persistence.PersistenceFacade;

public class Controller {
	private static Controller instance;
	
	private PersistenceFacade persistence;
	private RoomController roomController;
	private StudentsClassController studentsClassController;
	private CourseController courseController;
	
	private Controller() throws DBException{
		persistence = PersistenceFacade.getInstance();
		roomController = RoomController.getInstance();
		studentsClassController = StudentsClassController.getInstance();
		courseController = CourseController.getInstance();
	}
	
	public static synchronized Controller getInstance() throws DBException{
		if (instance == null){
			instance = new Controller();
		}
		return instance;
	}
	
	public void addRoom(Room r) throws SQLException{
		roomController.addRoom(r);
	}
	
	public void resetDataBase(Bulk bulk) throws SQLException, DBException{
		persistence.cleanTables();
		
		roomController.addRoom(bulk.getLstRoom());
		courseController.addCourse(bulk.getLstCourse());
		studentsClassController.addStudentsClass(bulk.getLstStudentsClass());
	}
	
	public Bulk getAllData() throws SQLException, DBException{
		Bulk bulk = new Bulk();
		
		bulk.setLstCourse(courseController.getAllCourses());
		bulk.setLstRoom(roomController.getAllRooms());
		bulk.setLstStudentsClass(studentsClassController.getAllStudentsClasses());
		
		return bulk;
	}
}