package com.cisc181.core;

import java.util.UUID;
import com.cisc181.core.Course;
public class Section {
	Course c = new Course();
	Semester s = new Semester();
	
	public UUID getSectionID() {
		return SectionID;
	}
	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public UUID getCourseID() {
		return CourseID;
	}
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	public UUID getSemesterID() {
		return SemesterID;
	}
	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}
	
	UUID SectionID;
	int RoomID;
	UUID CourseID = c.CourseID;
	UUID SemesterID = s.SemesterID;
	
	public Section(){}
	
	public Section(UUID CourseID, UUID SemesterID, UUID SectionID, int RoomID){
		this.SectionID = SectionID;
		this.CourseID = CourseID;
		this.SemesterID = SemesterID;
		this.RoomID = RoomID;
	}

}
