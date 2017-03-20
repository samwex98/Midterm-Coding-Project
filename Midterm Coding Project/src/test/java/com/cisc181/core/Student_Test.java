package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	public double determineGPA(double d){
		if(d >= 97){
			return 4;
		}
		else if(d >= 95){
			return 3.7;
		}
		else if(d >= 90){
			return 3.5;
		}
		else if(d >= 87){
			return 3.3;
		}
		else if(d >= 85){
			return 3;
		}
		else if(d >= 80){
			return 2.7;
		}
		else if(d >= 77){
			return 2.5;
		}
		else if(d >= 75){
			return 2.2;
		}
		else{
			return 2;
		}
	}
	
	

	static ArrayList<Course> course = new ArrayList<Course>();
	static ArrayList<Semester> semester = new ArrayList<Semester>();
	static ArrayList<Section> section = new ArrayList<Section>();
	static ArrayList<Student> student = new ArrayList<Student>();
	static ArrayList<Enrollment> enrolled = new ArrayList<Enrollment>();
	static ArrayList<Double> course1GPA = new ArrayList<Double>();
	static ArrayList<Double> course2GPA = new ArrayList<Double>();
	static ArrayList<Double> course3GPA = new ArrayList<Double>();
	
	
	static Course course1, course2, course3;
	static Section section1, section2, section3, section4, section5, section6;
	static Semester fall, spring;
	static Student stud1, stud2, stud3, stud4, stud5, stud6, stud7, stud8, stud9, stud10;
	static Enrollment stud;
	
	@BeforeClass
	public static void setup() throws ParseException, PersonException {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date sDate1 = format.parse("08/27/2014");
		Date eDate1 = format.parse("12/21/2015");
		Date sDate2 = format.parse("02/06/2016");
		Date eDate2 = format.parse("05/22/2016");
		Date DOB = format.parse("03/17/1998");
		Date DOB2 = format.parse("03/18/1998");
		Date DOB3 = format.parse("03/19/1998");
		Date DOB4 = format.parse("03/20/1998");
		Date DOB5 = format.parse("03/21/1998");
		Date DOB6 = format.parse("03/22/1998");
		Date DOB7 = format.parse("03/23/1998");
		Date DOB8 = format.parse("03/24/1998");
		Date DOB9 = format.parse("03/25/1998");
		Date DOB10 = format.parse("03/26/1998");
		
		course1 = new Course(course1.getCourseID(), "ECON 110", 4, eMajor.BUSINESS);
		course2 = new Course(course2.getCourseID(), "CISC 181", 3, eMajor.COMPSI);
		course3 = new Course(course3.getCourseID(), "MATH 242", 4, eMajor.PHYSICS);
		
		course.add(course1);
		course.add(course2);
		course.add(course3);
		
		fall = new Semester(fall.getSemesterID(), sDate1, eDate1);
		spring = new Semester(spring.getSemesterID(), sDate2, eDate2);
		
		semester.add(fall);
		semester.add(spring);
		
		section1 = new Section(course1.getCourseID(), fall.getSemesterID(), section1.getSectionID(), 1337);
		section2 = new Section(course1.getCourseID(), spring.getSemesterID(), section2.getSectionID(), 1337);
		section3 = new Section(course2.getCourseID(), fall.getSemesterID(), section3.getSectionID(), 420);
		section4 = new Section(course2.getCourseID(), spring.getSemesterID(), section4.getSectionID(), 420);
		section5 = new Section(course3.getCourseID(), fall.getSemesterID(), section5.getSectionID(), 696);
		section6 = new Section(course3.getCourseID(), spring.getSemesterID(), section6.getSectionID(), 696);
		
		section.add(section1);
		section.add(section2);
		section.add(section3);
		section.add(section4);
		section.add(section5);
		section.add(section6);
		
		stud1 = new Student("Bill", "Bill", "Bill", DOB, eMajor.COMPSI, "123 Street Street", "(123)-456-789", "billl@udel.edu");
		stud2 = new Student("Issaic", "Issaic", "Issaic", DOB2, eMajor.COMPSI, "124 Street Street", "(123)-456-788", "billl@udel.edu");
		stud3 = new Student("Larry", "Larry", "Larry", DOB3, eMajor.COMPSI, "125 Street Street", "(123)-456-787", "billl@udel.edu");
		stud4 = new Student("Lamar", "Lamar", "Lamar", DOB4, eMajor.COMPSI, "126 Street Street", "(123)-456-786", "billl@udel.edu");
		stud5 = new Student("Carl", "Carl", "Carl", DOB5, eMajor.COMPSI, "127 Street Street", "(123)-456-785", "billl@udel.edu");
		stud6 = new Student("Orion", "Orion", "Orion", DOB6, eMajor.COMPSI, "128 Street Street", "(123)-456-784", "billl@udel.edu");
		stud7 = new Student("Stewart", "Stewart", "Stewart", DOB7, eMajor.COMPSI, "129 Street Street", "(123)-456-783", "billl@udel.edu");
		stud8 = new Student("Brandon", "Brandon", "Brandon", DOB8, eMajor.COMPSI, "130 Street Street", "(123)-456-782", "billl@udel.edu");
		stud9 = new Student("Yelvis", "Yelvis", "Yelvis", DOB9, eMajor.COMPSI, "131 Street Street", "(123)-456-781", "billl@udel.edu");
		stud10 = new Student("Harold", "Harold", "Harold", DOB10, eMajor.COMPSI, "132 Street Street", "(123)-456-780", "billl@udel.edu");
		
		student.add(stud1);
		student.add(stud2);
		student.add(stud3);
		student.add(stud4);
		student.add(stud5);
		student.add(stud6);
		student.add(stud7);
		student.add(stud8);
		student.add(stud9);
		student.add(stud10);
		
		
	}

	@Test
	public void enrollmentTest() {
		for(Student S: student){
			for(Section Sec: section){
				stud = new Enrollment(Sec.getSectionID(), S.getStudentID());
				if(S == stud1){
					stud.setGrade(90);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S == stud2){
					stud.setGrade(85);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S == stud3){
					stud.setGrade(84);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S==stud4){
					stud.setGrade(83);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S==stud5){
					stud.setGrade(82);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if (S==stud6){
					stud.setGrade(81);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S == stud7){
					stud.setGrade(80);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S == stud8){
					stud.setGrade(79);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S == stud9){
					stud.setGrade(78);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				if(S == stud10){
					stud.setGrade(99);
					course1GPA.add(stud.getGrade());
					course2GPA.add(stud.getGrade());
					course3GPA.add(stud.getGrade());
				}
				enrolled.add(stud);
			}		
		}
	}
	
	@Test
	public void GPATest(){
		double GPA = 0;
		
		//Student 1 GPA
		GPA = determineGPA(enrolled.get(0).getGrade());
		assertEquals(GPA, 3.5);
		
		//Student 2 GPA
		GPA = determineGPA(enrolled.get(1).getGrade());
		assertEquals(GPA, 3);
		
		// Student 3 GPA
		GPA = determineGPA(enrolled.get(2).getGrade());
		assertEquals(GPA, 2.7);
		
		//Student 4 GPA
		GPA = determineGPA(enrolled.get(3).getGrade());
		assertEquals(GPA, 2.7);
		
		//Student 5 GPA
		GPA = determineGPA(enrolled.get(4).getGrade());
		assertEquals(GPA, 2.7);
		
		//Student 6 GPA
		GPA = determineGPA(enrolled.get(5).getGrade());
		assertEquals(GPA, 2.7);
		
		//Student 7 GPA
		GPA = determineGPA(enrolled.get(6).getGrade());
		assertEquals(GPA, 2.7);
		
		//Student 8 GPA
		GPA = determineGPA(enrolled.get(7).getGrade());
		assertEquals(GPA, 2.5);
		
		//Student 9 GPA
		GPA = determineGPA(enrolled.get(8).getGrade());
		assertEquals(GPA, 2.5);
		
		//Student 10 GPA
		GPA = determineGPA(enrolled.get(9).getGrade());
		assertEquals(GPA, 4);
	}
	
	@Test
	public void CourseAvgGPA(){
		double avg = 0;
		
		//ECON avg
		avg = course1GPA.stream().mapToDouble(Double::doubleValue).sum()/ course1GPA.size();
		assertEquals(avg, 84.1);
		
		//CISC avg
		avg = course2GPA.stream().mapToDouble(Double::doubleValue).sum() / course2GPA.size();
		assertEquals(avg, 84.1);
		
		//MATH avg
		avg = course3GPA.stream().mapToDouble(Double::doubleValue).sum() / course3GPA.size(); 	
	}
	
	@Test
	public void MajorChangeTest(){
		student.get(0).setMajor(eMajor.CHEM);
	}
	
	
	
	
}