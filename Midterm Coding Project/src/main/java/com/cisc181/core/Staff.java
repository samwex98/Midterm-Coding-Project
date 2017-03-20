package com.cisc181.core;

import java.util.Date;

import com.cisc181.eNums.eTitle2;

public class Staff extends Employee {

	 private eTitle2 Title;

	   public Staff(eTitle2 title){
	        this.Title = title;
	    }

	    public void setTitle(eTitle2 title){
	        this.Title = title;
	    }
	    public eTitle2 getTitle(){
	        return this.Title;
	    }
	    
    

    
	public Staff(String FirstName, String MiddleName, String LastName,
			Date DOB, String Address, String Phone_number, String Email,
			String officeHours, int rank, double salary, Date hireDate,
			eTitle2 Title) throws PersonException 
	
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, 
				Email, officeHours, salary, hireDate);
		
		this.Title = Title;
	}
}