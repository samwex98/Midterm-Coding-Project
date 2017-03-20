package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eTitle2;

public class Staff_Test {
	static Staff staff1;
	static Staff staff2;
	static Staff staff3;
	static Staff staff4;
	static Staff staff5;
	static Staff staff6;
	static Staff staff7;
	static ArrayList<Staff> staffTest = new ArrayList<Staff>();
	@BeforeClass
	public static void setup() throws PersonException, ParseException{
		String date = "07-04-2012";
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		Date Date = format.parse(date);
		
			staff1 = new Staff("Nicolas", "Danger", "Cage", Date, "Memorial", "(551)-123-1234","nicCage@udel.com", "11-2", 42, 10000, Date, eTitle2.Dean);
			staff2 = new Staff("Paul", "Danger", "Blart", Date, "Kirkbride", "(551)-123-1234","pBlart@udel.com", "11-2", 41, 11000, Date, eTitle2.Professor);
			staff3 = new Staff("Christopher", "Danger", "Walken", Date, "Smith", "(551)-123-1234","cWalken@udel.edu", "11-2", 40, 12000, Date, eTitle2.TA);
			staff4 = new Staff("Jeff", "Danger", "Goldblum", Date, "Smith", "(551)-123-1234","jGoldblum@udel.edu", "11-2", 39, 13000, Date, eTitle2.TA);
			staff5 = new Staff("Tommy", "Danger", "Wiseau", Date, "Smith", "(551)-123-1234","tWiseau@udel.edu", "11-2", 38, 14000, Date, eTitle2.TA);
			
			staffTest.add(staff1);
			staffTest.add(staff2);
			staffTest.add(staff3);
			staffTest.add(staff4);
			staffTest.add(staff5);
			
	}
	@Test
	public void StaffSalaryTest(){
		double Sum = 0;
		for(Staff S : staffTest){
			Sum += S.getSalary();
		}
		double Average = Sum / staffTest.size();
		assertEquals(Average, 12000);
	}	
	
	@Test
	public void StaffDOBErrorTest() throws ParseException{
		boolean bool = false;
		String dates = "07-04-1776";
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		Date Dates = format.parse(dates);
		try{
			staff6 = new Staff("Nicolas", "Danger", "Cage", Dates , "Memorial", "551","nicCage@udel.com", "11-2", 42, 10000, new Date(), eTitle2.Dean);
			if (2017 - (staff6.getDOB().getYear() + 1900) <= 100){
				bool = true;
			}
		}catch (PersonException PE){
			System.out.println("Error thrown");
		}catch (Exception e){
			e.printStackTrace();
		}
		assertEquals(bool, false);
	}
	@Test
	public void StaffNUMErrorTest() throws ParseException{
		boolean bool = false;
		String dates = "07-04-2012";
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		Date Dates = format.parse(dates);
		try{
			staff6 = new Staff("Nicolas", "Danger", "Cage", Dates , "Memorial", "551","nicCage@udel.com", "11-2", 42, 10000, new Date(), eTitle2.Dean);
			Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
			Matcher matcher = pattern.matcher(staff6.getPhone());
			if(matcher.matches()){
				bool = true;
			}
		}catch (PersonException PE){
			System.out.println("Error thrown");
		}catch (Exception e){
			e.printStackTrace();
		}
		assertEquals(bool, false);
	}
}
