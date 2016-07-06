package org.gumtree.office.addressbook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import junit.framework.Assert;

public class AddressBookEntryTest {

	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AddressBookEntry.STR_DATE_FORMAT);

	/**
	 * Test that the current age of someone born on 10/03/84 is 32.
	 * 
	 * Note that in order to future proof this test, (as the actual age will increment each year)
	 * So the DateNow value is passed in to the function ...
	 */
	@Test
	public void testGetAgeReturnsCorrectValue() {
		AddressBookEntry person = new AddressBookEntry("Tommy", "Male", "10/03/84");

		LocalDate today = LocalDate.parse("06/07/16", formatter);
		
		Assert.assertEquals(32, person.getAge(today));
	}
}
