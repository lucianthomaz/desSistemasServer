package clek.model;

import java.util.HashSet;


public class Course {
	private String code;
	private int credit;
	private String name;
	private int module;
	private HashSet<StudentsClass> classes;
	
	public Course(){
		
	}
	
	public Course(String code, int credit, String name, int module){
		this.code = code;
		this.credit = credit;
		this.name = name;
		this.module = module;
		this.classes = new HashSet<StudentsClass>();
	}
	
	public String getCode(){
		return this.code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	public int getCredit(){
		return this.credit;
	}
	
	public void setCredit(int credit){
		this.credit = credit;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getModule(){
		return this.module;
	}
	
	public void setModule(int module){
		this.module = module;
	}
	
	public boolean addClass(StudentsClass c){
		return this.classes.add(c);
	}
	
	public HashSet<StudentsClass> getClasses(){
		return this.classes;
	}
	
	public void setClasses(HashSet<StudentsClass> classes){
		this.classes = classes;
	}
	/*
	public String toString(){
		return new StringBuffer(" Code : ").append(this.code)
				.append(" Credit : ").append(this.credit)
				.append(" Name : ").append(this.name)
				.append(" Module : ").append(this.module).toString();
	}*/
}
