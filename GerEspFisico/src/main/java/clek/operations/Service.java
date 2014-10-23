package clek.operations;

import java.util.ArrayList;

import javax.ws.rs.*;

import clek.model.*;
import clek.persistence.BD;

@Path("GEF")
public class Service {
	@GET
	@Path("consult/rooms")
	@Produces("application/jason")
	public ArrayList<Room> distributedRooms(){
		BD bd = BD.getInstance();
		
		Room r = new Room(60, "201");
		
		Course c = new Course("3424", 4, "Desenv Sis", 60);
		
		StudentsClass sc = new StudentsClass(c);
		
		ClassTime ct1 = new ClassTime(DayOfWeek.MONDAY, Time.J);
		ClassTime ct2 = new ClassTime(DayOfWeek.MONDAY, Time.K);
		ClassTime ct3 = new ClassTime(DayOfWeek.MONDAY, Time.L);
		ClassTime ct4 = new ClassTime(DayOfWeek.MONDAY, Time.M);
		
		sc.addClassTime(ct1);
		sc.addClassTime(ct2);
		sc.addClassTime(ct3);
		sc.addClassTime(ct4);
		
		r.addClass(ct1, sc);
		r.addClass(ct2, sc);
		r.addClass(ct3, sc);
		r.addClass(ct4, sc);
		
		bd.listCourse.add(c);
		bd.listRooms.add(r);
		bd.listStudentsClass.add(sc);
		
		return bd.listRooms;
	}
}
