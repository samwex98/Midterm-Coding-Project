package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.expression.ParseException;

/*
 * comment
 */


public abstract class Person implements java.io.Serializable {

	private Date DOB;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String address;
	private String phone_number;
	private String email_address;
	private String regax = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
	//private Date CurrentDate;
	
	public Date getCurrentDate() throws java.text.ParseException{
		SimpleDateFormat FORMAT = new SimpleDateFormat("MM-dd-yyyy");
		String CurrentDate = "03-20-2017";
		Date today = FORMAT.parse(CurrentDate);
		return today;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB){
		this.DOB = DOB;
		
		
	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setPhone(String newPhone_number) {
		phone_number = newPhone_number;
	
	}

	public String getPhone() {
		return phone_number;
	}

	public void setEmail(String newEmail) {
		email_address = newEmail;
	}

	public String getEmail() {
		return email_address;
	}

	/*
	 * Constructors No Arg Constructor
	 */
	public Person() {

	}

	/*
	 * Constructors Constructor with arguments
	 */

	public Person(String FirstName, String MiddleName, String LastName,
			Date DOB, String Address, String Phone_number, String Email) throws PersonException
	{
		try{
		char a = '(';
		char b = ')';
		char c = '-';
		Pattern pattern = Pattern.compile(regax);
		Matcher matcher = pattern.matcher(Phone_number);
		if(matcher.matches()){
			if ((getCurrentDate().getYear() + 1900)- (DOB.getYear() + 1900) <= 100 ){
				this.FirstName = FirstName;
				this.MiddleName = MiddleName;
				this.LastName = LastName;
				this.setDOB(DOB);
				this.address = Address;
				this.setPhone(Phone_number);
				this.email_address = Email;
			}
		}throw new PersonException(this, DOB, Phone_number);
		}
		catch(PersonException PE) {
			throw PE;
		}catch(Exception e){
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void PrintName() {
		System.out.println(this.FirstName + ' ' + this.MiddleName + ' '
				+ this.LastName);
	}

	public void PrintDOB() {
		System.out.println(this.DOB);
	}

	public int PrintAge() {
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;
		birthDate.setTime(this.DOB);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// If birth date is greater than todays date (after 2 days adjustment of
		// leap year) then decrement age one year
		if ((birthDate.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;

			// If birth date and todays date are of same month and birth day of
			// month is greater than todays day of month then decrement age
		} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today
						.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}

		System.out.println("age is " + age);

		return age;

	}
}