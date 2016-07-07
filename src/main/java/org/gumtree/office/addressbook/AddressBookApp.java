package org.gumtree.office.addressbook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.gumtree.office.addressbook.model.AddressBook;
import org.gumtree.office.addressbook.model.AddressBookEntry;

/**
 * The AddressBook coding Exercise for GumTree.
 * 
 * The exercise is to read the AddressBook file and then determine ;
 * 
 * 1. How many males are in the address book?
 * 2. Who is the oldest person in the address book?
 * 3. How many days older is Bill than Paul?
 * 
 * The functionality is contained mostly in the AddressBook class, with associated classes and test classes.
 * 
 */
public class AddressBookApp 
{
	
	public static void main (String [] args) {
		String fileName = "";

		if (args.length == 1) {
			//If a file argument is provided, then use it
			fileName = args[0];
		} else {
			//Otherwise, show usage and defaulting messages
			System.out.println("Usage: AddressBookApp fileToLoadName");
			System.out.println("Defaulting fileToLoadName to AddressBook");
			System.out.println("");
			fileName = "AddressBook";
		}		

		Path file = Paths.get(fileName).toAbsolutePath();

		AddressBook addressBook = new AddressBook();
		List<AddressBookEntry> fileData = addressBook.load(file);		

		//1. Count the number of males
		int maleCount = addressBook.getNumberOfMaleRecords(fileData);
		System.out.println("The number of males is: "+maleCount);

		//2. Find the oldest person
		String oldestPerson = addressBook.getOldestPerson(fileData).getName();
		System.out.println("The oldest person is: "+oldestPerson);

		//3. Determine the age difference between Bill & Paul
		String name1 = "Bill McKnight";
		String name2 = "Paul Robinson";
		int ageDifference = addressBook.getAgeDifferenceBetweenTwoNames(fileData, name1, name2);
		System.out.println("The age difference between "+name1+" and "+name2+" is: "+ageDifference + " years");
	}

}
