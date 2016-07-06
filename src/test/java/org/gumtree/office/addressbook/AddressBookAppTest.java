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
	
}
