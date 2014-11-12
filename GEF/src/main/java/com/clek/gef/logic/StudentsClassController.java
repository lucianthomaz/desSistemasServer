package com.clek.gef.logic;

import java.sql.SQLException;
import java.util.List;

import com.clek.gef.model.StudentsClass;
import com.clek.gef.persistence.DBException;
import com.clek.gef.persistence.PersistenceFacade;

public class StudentsClassController {
	private static StudentsClassController instance;
	private PersistenceFacade persistence;
	private StudentsClassController() throws DBException{
		persistence = PersistenceFacade.getInstance();
	}
	
	public static synchronized StudentsClassController getInstance() throws DBException{
		if (instance == null){
			instance = new StudentsClassController();
		}
		return instance;
	}
	
	public void addStudentsClass(StudentsClass sc) throws SQLException, DBException{
		persistence.persistStudentsClass(sc);
	}
	
	public void addStudentsClass(List<StudentsClass> lstsc) throws SQLException, DBException{
		for (StudentsClass sc : lstsc){
			this.addStudentsClass(sc);
		}
	}

	public List<StudentsClass> getAllStudentsClasses() throws SQLException, DBException {
		return persistence.getAllStudentsClasses();
	}
}
