package org.gumtree.office.addressbook.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.gumtree.office.addressbook.utilities.PersonAgeComparator;

/**
 * This is the Address Book class. It provides functionality for loading a file and saving the contents in a 
 * Collection of ddressBookEntry records and provides various search and select methods.  
 * 
 * @author Jonathan Lees
 *
 */
public class AddressBook {

	Logger logger = LogManager.getLogManager().getLogger(AddressBook.class.getName());	

	/**
	 * load the file specified in the Path variable into a List off Strings
	 * 
	 * @param file
	 * @return List of Strings from the file
	 * 
	 */
	public List<AddressBookEntry> load(Path file) {
		List<String> fileData = null;
		List<AddressBookEntry> addressBookDataList = new ArrayList<AddressBookEntry>();  
		try {
			fileData = java.nio.file.Files.readAllLines(file, Charset.defaultCharset());
			AddressBookEntry addressBookEntry = null;
			for (String row: fileData) {
				String[] fields = row.split(",");
				addressBookEntry = new AddressBookEntry(fields[0], fields[1], fields[2]);
				addressBookDataList.add(addressBookEntry);
			}
			
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	    return addressBookDataList;
	}
	
	
	/**
	 * Count up the number of records that are Male
	 * 
	 * @param allData - the full list of AddressBook data
	 * @return - the count of the number of males
	 */
	public int getNumberOfMaleRecords(List<AddressBookEntry> allData) {
		int numMales = 0;
		for (AddressBookEntry rec : allData) {
			if (rec.isMale()) {
				numMales++;
			}
		}
		return numMales;
	}

	/**
	 * Determine the Oldest Person in the AddressBook using DateOfBirth 
	 * 
	 * @param allData - the AddressBook to search
	 * @return - the full AddressBookEntry for the oldest person
	 */
	public AddressBookEntry getOldestPerson(List<AddressBookEntry> allData) {
		Collections.sort(allData, new PersonAgeComparator());
		return allData.get(0);
	}

	/**
	 * Find the first person in the list whose name matches the name supplied
	 * 
	 * @param allData - the address book to search in
	 * @param name - the name to search for
	 * @return - the AddressBookEntry record of the person found 
	 */
	public AddressBookEntry getPersonByName(List<AddressBookEntry> allData, String name) {
		AddressBookEntry personFound = null;
		for (AddressBookEntry rec : allData) {
			if (rec.getName().equals(name)) {
				personFound = rec;
				break;
			}
		}
		return personFound;
	}
	
	public int getAgeDifferenceBetweenTwoNames(List<AddressBookEntry> allData, String name1, String name2) {
		AddressBookEntry person1 = getPersonByName(allData, name1);
		AddressBookEntry person2 = getPersonByName(allData, name2);
		LocalDate today = LocalDate.now();

		return Math.abs(person1.getAge(today) - person2.getAge(today));
	}

}
