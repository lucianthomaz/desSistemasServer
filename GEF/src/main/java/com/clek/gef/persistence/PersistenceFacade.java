package com.clek.gef.persistence;

import java.sql.SQLException;
import java.util.List;

import com.clek.gef.model.ClassTime;
import com.clek.gef.model.Course;
import com.clek.gef.model.Room;
import com.clek.gef.model.StudentsClass;

public class PersistenceFacade {
	private static PersistenceFacade instance;
	
	public static synchronized PersistenceFacade getInstance() throws DBException{
		if (instance == null){
			instance = new PersistenceFacade();
		}
		return instance;
	}
	
	private RoomDAO roomDao;
	private CourseDAO courseDao;
	private ClassTimeDAO classTimeDao;
	private StudentsClassDAO studentsClassDao;
	
	private PersistenceFacade() throws DBException{
		roomDao = new RoomDAO();
		courseDao = new CourseDAO();
		classTimeDao = new ClassTimeDAO();
		studentsClassDao = new StudentsClassDAO();
	}
	
	public void persistRoom(Room r) throws SQLException{
		roomDao.persist(r);
	}
	
	public void persistRoom(List<Room> rs) throws SQLException{
		roomDao.persist(rs);
	}
	
	public List<Room> getAllRooms() throws SQLException{
		return roomDao.getAllRooms();
	}

	public Room getRoom(String building, String roomName) throws SQLException{
		return roomDao.getRoom(building, roomName);
	}
	
	public void persistCourse(Course c) throws SQLException{
		courseDao.persist(c);
	}
	
	public void persistCouse(List<Course> lstCourse) throws SQLException{
		courseDao.persist(lstCourse);
	}
	
	public List<Course> getAllCourses() throws SQLException{
		return courseDao.getAllCourses();
	}
	
	public Course getCourse(String code) throws SQLException{
		return courseDao.getCourse(code);
	}
	
	public void persistStudentsClass(StudentsClass sc) throws SQLException, DBException{
		studentsClassDao.persist(sc);
	}
	
	public void persistStudentsClasses(List<StudentsClass> lstsc) throws SQLException, DBException{
		studentsClassDao.persist(lstsc);
	}
	
	public List<StudentsClass> getAllStudentsClasses() throws SQLException, DBException{
		return studentsClassDao.getAllStudentsClasses();
	}
	
	public StudentsClass getStudentsClass(String code, Course c) throws SQLException, DBException{
		return studentsClassDao.getStudentsClass(code, c);
	}
	
	public void allocRoom(ClassTime ct, StudentsClass sc) throws DBException, SQLException{
		classTimeDao.allocRoom(ct, sc);
	}
}
