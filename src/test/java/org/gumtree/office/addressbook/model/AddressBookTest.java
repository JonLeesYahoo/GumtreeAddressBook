package org.gumtree.office.addressbook.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.gumtree.office.addressbook.data.AddressBookData;
import org.gumtree.office.addressbook.model.AddressBook;
import org.gumtree.office.addressbook.model.AddressBookEntry;
import org.junit.Assert;
import org.junit.Test;

/**
 * Various test cases specific to the AddressBook class, as described by the test method names.
 *  
 * @author Jonathan Lees
 *
 */
public class AddressBookTest 
{

	private Path file = Paths.get("AddressBook").toAbsolutePath();
	private AddressBook addressBook = new AddressBook();
	
	@Test
	public void testLoadFromFile() {
		List<AddressBookEntry> fileData = addressBook.load(file);
		Assert.assertEquals(5, fileData.size());
	}
	
	@Test 
	public void testCountNumberOfMales() {
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		int maleCount = addressBook.getNumberOfMaleRecords(testData);

		Assert.assertEquals(3, maleCount);
	}
	
	@Test
	public void testGetOldestPerson() {
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		AddressBookEntry oldestPerson = addressBook.getOldestPerson(testData);

		Assert.assertEquals("Wes Jackson", oldestPerson.getName());
	}
	
	@Test
	public void testGetPersonByName() {
		String name = "Sarah Stone";
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		AddressBookEntry sarah = addressBook.getPersonByName(testData, name);
		Assert.assertEquals(name, sarah.getName());
	}

	@Test
	public void testGetAgeDiffereneBetweenTwoPersons() {
		String name1 = "Bill McKnight";
		String name2 = "Paul Robinson";
		
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		int ageDifference = addressBook.getAgeDifferenceBetweenTwoNames(testData, name1, name2);
		Assert.assertEquals(8, ageDifference);
	}
		
}
