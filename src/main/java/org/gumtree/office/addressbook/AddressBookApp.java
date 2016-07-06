package org.gumtree.office.addressbook;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * The AddressBook coding Exercise for GumTree
 *
 */
public class AddressBookApp 
{
	Logger logger = LogManager.getLogManager().getLogger(AddressBookApp.class.getName());	

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
	
	public static void main (String [] args) {
		String fileName = "";

		if (args.length == 1) {
			//If a file argument is provided, then use it
			fileName = args[0];
		} else {
			//Otherwise, show usage and defaulting messages
			System.out.println("Usage: AddressBookApp fileToLoadName");
			System.out.println("Defaulting to AddressBook");
			fileName = "AddressBook";
		}		

		Path file = Paths.get(fileName).toAbsolutePath();

		AddressBookApp addressBookApp = new AddressBookApp();
		List<AddressBookEntry> fileData = addressBookApp.load(file);
		int maleCount = addressBookApp.getNumberOfMaleRecords(fileData);
		System.out.println("The number of males is: "+maleCount);
	}

}
