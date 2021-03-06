package com.clek.gef.logic;

import java.sql.SQLException;
import java.util.List;

import com.clek.gef.model.Course;
import com.clek.gef.persistence.DBException;
import com.clek.gef.persistence.PersistenceFacade;

public class CourseController {
	private static CourseController instance;
	private PersistenceFacade persistence;
	private CourseController() throws DBException{
		persistence = PersistenceFacade.getInstance();
	}
	
	public static synchronized CourseController getInstance() throws DBException{
		if (instance == null){
			instance = new CourseController();
		}
		return instance;
	}
	
	public void addCourse(Course c) throws SQLException{
		persistence.persistCourse(c);
	}
	
	public void addCourse(List<Course> lstc) throws SQLException{
		for (Course c : lstc){
			this.addCourse(c);
		}
	}
	
	public List<Course> getAllCourses() throws SQLException{
		return persistence.getAllCourses();
	}
	
	public Course getCourse(String code) throws SQLException{
		return persistence.getCourse(code);
	}
}
