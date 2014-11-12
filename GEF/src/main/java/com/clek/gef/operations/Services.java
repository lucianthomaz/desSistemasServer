package com.clek.gef.operations;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.*;

import com.clek.gef.logic.Distributor;
import com.clek.gef.logic.Controller;
import com.clek.gef.model.*;
import com.clek.gef.persistence.BD;
import com.clek.gef.persistence.DBException;

@Path("/")
public class Services {
	@PUT
	@Path("room")
	@Consumes("application/json")
	public void insertRoom(Room r) throws Exception{
		Controller rc = Controller.getInstance();
		rc.addRoom(r);
	}
	/*
	@GET
	@Path("room")
	@Produces("application/json")
	public Room getRooms() throws DBException, SQLException{
		Room r = new Room();
		
		r.setBuilding("P32");
		r.setCapacity(30);
		r.setRoomName("LabCG");
		
		return r;
	}*/
	/*
	@GET
	@Path("allocation")
	@Produces("application/json")
	public Collection<StudentsClass> distributedRooms(){
		BD bd = BD.getInstance();
		
		
		Collection<StudentsClass> col = bd.listStudentsClass;
		
		return col;
	}
	*/
	/*
	@GET
	@Path("all")
	@Produces("application/json")
	public BD getAllBD(){
		BD bd = BD.getInstance();
		
		if (bd.listRooms.isEmpty()){
			bd.populate();
		}
		Distributor d = Distributor.getInstance();
		d.distrubute();
		
		Collection<Room> col = bd.listRooms;
		
		return bd;
	}*/
	
	@PUT
	@Path("bulk")
	@Consumes("application/json")
	public void importFile(Bulk bulk) throws SQLException, DBException{
		Controller.getInstance().resetDataBase(bulk);
	}
	
	@GET
	@Path("bulk")
	@Produces("application/json")
	public Bulk getAllData() throws SQLException, DBException{
		//return Controller.getInstance().getAllData();
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
		
		Bulk bulk = new Bulk();
		
		bulk.getLstRoom().add(r);
		bulk.getLstCourse().add(c);
		bulk.getLstStudentsClass().add(sc);
		
		return bulk;
	}
	
	/*
	@POST
	@Path("rooms")
	@Produces("application/json")
	public String distribute() throws DBException, SQLException {
		BD bd = BD.getInstance();
		
		if (bd.listRooms.isEmpty()){
			bd.populate();
		}
		Distributor d = Distributor.getInstance();
		d.distrubute();
		
		return "sucesso";
	}*/
	
}

