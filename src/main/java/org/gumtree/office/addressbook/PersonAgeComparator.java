package org.gumtree.office.addressbook;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<AddressBookEntry> 
{

	/** 
	 * Comparator to provide a list that sorts into oldest first
	 */
	@Override
	public int compare(AddressBookEntry object1, AddressBookEntry object2) 
	{
		//Compare The AddressBookEntry date of birth, returning -1 if older, 1 if younger
		if (object1.getDateOfBirth().isBefore(object2.getDateOfBirth())) {
			return -1;
		} else if (object1.getDateOfBirth().isAfter(object2.getDateOfBirth())) {
			return 1;
		} else {
			return 0;
		}
	}
}
