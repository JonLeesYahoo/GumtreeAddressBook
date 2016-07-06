package org.gumtree.office.addressbook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.gumtree.office.addressbook.data.AddressBookData;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookAppTest 
{

	private Path file = Paths.get("AddressBook").toAbsolutePath();
	private AddressBookApp addressBookApp = new AddressBookApp();
	
	@Test
	public void testLoadFromFile() {
		List<AddressBookEntry> fileData = addressBookApp.load(file);
		Assert.assertEquals(5, fileData.size());
	}
	
	@Test 
	public void testCountNumberOfMales() {
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		int maleCount = addressBookApp.getNumberOfMaleRecords(testData);

		Assert.assertEquals(3, maleCount);
	}
	
	@Test
	public void testGetOldestPerson() {
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		AddressBookEntry oldestPerson = addressBookApp.getOldestPerson(testData);

		Assert.assertEquals("Wes Jackson", oldestPerson.getName());
	}
	
	@Test
	public void testGetPersonByName() {
		String name = "Sarah Stone";
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		AddressBookEntry sarah = addressBookApp.getPersonByName(testData, name);
		Assert.assertEquals(name, sarah.getName());
	}

	@Test
	public void testGetAgeDiffereneBetweenTwoPersons() {
		String name1 = "Bill McKnight";
		String name2 = "Paul Robinson";
		
		List<AddressBookEntry> testData = AddressBookData.getAddressBookDataList();
		int ageDifference = addressBookApp.getAgeDifferenceBetweenTwoNames(testData, name1, name2);
		Assert.assertEquals(8, ageDifference);
	}
		
}
