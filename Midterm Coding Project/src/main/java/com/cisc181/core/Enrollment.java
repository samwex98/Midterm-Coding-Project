package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	Section s = new Section();
	Student stud = new Student();
	
	UUID SectionID = s.SectionID;
	UUID StudentID = stud.getStudentID();
	
	UUID EnrollmentID;
	double Grade;
	
	private Enrollment(){}
	public Enrollment(UUID SectionID, UUID StudentID){
		EnrollmentID = UUID.randomUUID();
	}
	public double getGrade(){
		return Grade;
	}
	public void setGrade(double Grade){
		this.Grade = Grade;
	}
}
