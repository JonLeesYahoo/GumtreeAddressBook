package org.gumtree.office.addressbook.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * The AddressBookEntry is a class containing all the data for a specific entry in the AddressBook. It also
 * contains various functions for returning data not contained within the class, such as isMale and getAge.
 * 
 * The constructor takes 3 Strings as parameters and handles the task of converting the date of birth to a Date class
 * in order to remove that burden from any calling code. However, the supplied date string must always be in the specified 
 * Date format. 
 * 
 * There is a complication using the DateTimeFormatter with 2 digit year values (such as 88), which is that the year 
 * is assumed to be 2088 and not 1988. This means that we have to check if the date has been created in the future, and if
 * so then we can simply subtract 100 years. There may be a setting somewhere within the DateTimeFormatter or LocalDate to
 * handle this, but time constraints have prevented me from looking further. 
 * 
 * So this is a "pragmatic" solution for the time being. 
 * 
 * @author Jonathan Lees
 *
 */
public class AddressBookEntry {

	private String name;
	private String gender;
	private LocalDate dateOfBirth;

	protected final static String STR_DATE_FORMAT = "dd/MM/yy";
	private final static String STR_MALE = "Male";
	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(STR_DATE_FORMAT);

	
	/**
	 * Constructor to create an AddressBookEntry for a Person
	 * 
	 * @param name - the persons names, first and last
	 * @param gender - the persons gender, Male or Female
	 * @param dateOfBirth - the persons date of birth in the format dd/MM/yy
	 * 
	 */
	public AddressBookEntry(String name, String gender, String dateOfBirth) {
		this.name = name.trim();
		this.gender = gender.trim();
		this.dateOfBirth  = LocalDate.parse(dateOfBirth.trim(), formatter);
		
		//check that the birth date isn't in the future.
		//This is highly likely given we are forced to use 2 digit years!
		//In which case the DateTimeFormatter will have assumed a future date instead of past, so -100 years
		//This is a perhps a bit smelly, but I haven't as yet found a setting to deal with this future/past concept.
		LocalDate today = LocalDate.now();
		if (this.dateOfBirth.isAfter(today)) {
			this.dateOfBirth = this.dateOfBirth.plusYears(-100);
		}
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public boolean isMale() {
		return STR_MALE.equalsIgnoreCase(gender);
	}
	
	/**
	 * Get the age of the person as of today's date.
	 * 
	 * @param dateToday - the Date Today is passed in to facilitate testing.
	 * @return - int the persons age as of today
	 */
	public int getAge(LocalDate dateToday) {
		Period p = Period.between(dateOfBirth, dateToday);
		return p.getYears();
	}
}
