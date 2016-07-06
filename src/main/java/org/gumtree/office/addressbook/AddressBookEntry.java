package org.gumtree.office.addressbook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddressBookEntry {

	private String name;
	private String gender;
	private LocalDate dateOfBirth;

	private final static String STR_DATE_FORMAT = "dd/MM/yy";
	private final static String STR_MALE = "Male";
	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(STR_DATE_FORMAT);
	
	public AddressBookEntry(String name, String gender, LocalDate dateOfBirth) {
		this.name = name.trim();
		this.gender = gender.trim();
		this.dateOfBirth = dateOfBirth;
	}
	
	public AddressBookEntry(String name, String gender, String dateOfBirth) {
		this.name = name.trim();
		this.gender = gender.trim();
		this.dateOfBirth  = LocalDate.parse(dateOfBirth.trim(), formatter);
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
}
