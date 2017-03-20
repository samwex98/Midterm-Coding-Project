package com.cisc181.core;

import java.util.Date;

public class PersonException extends Exception{

	private Date DOB;
	private Person per;
	private String Phone_number;
	public PersonException(Person per, Date dob, String phone_number){
		super();
		this.per = per;
		DOB = dob;
		Phone_number = phone_number;
	}
	public Person getPer(){
		return per;
	}
	public Date getDOB(){
		return DOB;
	}
	public String getPhone_number(){
		return Phone_number;
	}
}
