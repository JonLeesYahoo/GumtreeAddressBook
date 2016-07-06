package org.gumtree.office.addressbook;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
		
		//perform a sanity check that the birth date isn't in the future.
		//This is highly likely given we are forced to use 2 digit years!
		//In which case the DateTimeFormatter will have assumed this century instead of last, so -100 years
		//This is a bit smelly, but we would need to update the input dates otherwise.
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
