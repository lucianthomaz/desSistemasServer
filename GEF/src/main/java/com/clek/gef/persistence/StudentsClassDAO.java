package com.clek.gef.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clek.gef.model.Course;
import com.clek.gef.model.StudentsClass;

public class StudentsClassDAO {
private Connection conn;
	
	public StudentsClassDAO() throws DBException{
		try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new DBException("Erro ao se conectar com o Banco de Dados, não foi encontrado o Driver.");
        }
	}
	
	private void openConn() throws SQLException{
		
		conn = DriverManager.getConnection(ConnectionString.connStr, "admin", "admin");
	}
	
	private void closeConn() throws SQLException{
		conn.commit();
		conn.close();
	}
	
	public void persist(StudentsClass sc) throws SQLException, DBException{
		
		
		CourseDAO cd = new CourseDAO();
		int id = cd.getId(sc.gCourse());
		openConn();
		String str = "INSERT INTO GEFDATABASE.STUDENTS_CLASS (NUMBER_STUDENTS_CLASS, ID_COURSE) VALUES (?,?)";
		PreparedStatement stmt = conn.prepareStatement(str);
		
		stmt.setString(1, sc.getCode());
		stmt.setInt(2, id);
		
		stmt.execute();
		
		closeConn();
		
		ClassTimeDAO ctd = new ClassTimeDAO();
		ctd.persist(sc.getClassTime(), sc);
	}

	public void persist(List<StudentsClass> lsc) throws SQLException, DBException{
		for (StudentsClass sc : lsc){
			this.persist(sc);
		}
	}
	
	public List<StudentsClass> getAllStudentsClasses() throws SQLException, DBException{
		openConn();
		
		String str = "SELECT * FROM GEFDATABASE.STUDENTS_CLASS";
		PreparedStatement stmt = conn.prepareStatement(str);
		ResultSet rs = stmt.executeQuery();

		closeConn();
		
		List<StudentsClass> lstStudentsClass = new ArrayList<StudentsClass>();
		CourseDAO cd = new CourseDAO();
		ClassTimeDAO ctd = new ClassTimeDAO();
		while (rs.next()){
			StudentsClass sc = new StudentsClass();
			sc.setCode(rs.getString("NUMBER_STUDENTS_CLASS"));
			sc.sCourse(cd.getCourse(rs.getInt("ID_COURSE")));
			
			sc.setClassTime(ctd.getAllClassTime(sc));
			
			lstStudentsClass.add(sc);
		}
		
		return lstStudentsClass;
	}
	
	protected StudentsClass getStudentsClass(int id) throws SQLException, DBException{
		openConn();
		
		String str = "SELECT * FROM GEFDATABASE.STUDENTS_CLASS WHERE GEFDATABASE.STUDENTS_CLASS.ID_STUDENTS_CLASS = ?";
		PreparedStatement stmt = conn.prepareStatement(str);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		closeConn();
		
		CourseDAO cd = new CourseDAO();
		ClassTimeDAO ctd = new ClassTimeDAO();
		StudentsClass sc = null;
		if (rs.next()){
			sc = new StudentsClass();
			sc.setCode(rs.getString("NUMBER_STUDENTS_CLASS"));
			sc.sCourse(cd.getCourse(rs.getInt("ID_COURSE")));
			sc.setClassTime(ctd.getAllClassTime(sc));
		}
		
		return sc;
	}
	
	public StudentsClass getStudentsClass(String code, Course c) throws SQLException, DBException{
		CourseDAO cd = new CourseDAO();
		int idC = cd.getId(c);
		
		openConn();
		
		String str = "SELECT * FROM GEFDATABASE.STUDENTS_CLASS WHERE GEFDATABASE.STUDENTS_CLASS.NUMBER_STUDENTS_CLASS = ? AND GEFDATABASE.STUDENTS_CLASS.ID_COURSE = ?";
		PreparedStatement stmt = conn.prepareStatement(str);
		stmt.setString(1, code);
		stmt.setInt(2, idC);
		ResultSet rs = stmt.executeQuery();
		closeConn();

		ClassTimeDAO ctd = new ClassTimeDAO();
		StudentsClass sc = null;
		if (rs.next()){
			sc = new StudentsClass();
			sc.setCode(rs.getString("NUMBER_STUDENTS_CLASS"));
			sc.sCourse(c);
			sc.setClassTime(ctd.getAllClassTime(sc));
		}
		
		return sc;
	}
	
	protected int getId(StudentsClass sc) throws SQLException, DBException{
		CourseDAO cd = new CourseDAO();
		int idC = cd.getId(sc.gCourse());
		
		openConn();
		
		String str = "SELECT * FROM GEFDATABASE.STUDENTS_CLASS WHERE GEFDATABASE.STUDENTS_CLASS.NUMBER_STUDENTS_CLASS = ? AND GEFDATABASE.STUDENTS_CLASS.ID_COURSE = ?";
		PreparedStatement stmt = conn.prepareStatement(str);
		stmt.setString(1, sc.getCode());
		stmt.setInt(2, idC);
		ResultSet rs = stmt.executeQuery();
		
		closeConn();
		
		int id = 0;
		
		if (rs.next()){
			id = rs.getInt("ID_COURSE");
		} else {
			id = -1;
		}
		
		return id;
	}
}
