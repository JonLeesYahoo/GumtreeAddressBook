package org.gumtree.office.addressbook.data;

import java.util.ArrayList;
import java.util.List;

import org.gumtree.office.addressbook.AddressBookEntry;

public class AddressBookData {

	/**
	 * This provides an alternative source of valid data, such that if the provided file cannot be loaded, or if
	 * the loading breaks for some reason, then testing other parts of the system is still possible ...
	 * 
	 * @return a list of valid AddressBookEntries
	 */
	public static List<AddressBookEntry> getAddressBookDataList() {
		List<AddressBookEntry> addressBookDataList = new ArrayList<AddressBookEntry>();  

		addressBookDataList.add(new AddressBookEntry("Bill McKnight", "Male", "16/03/77"));
		addressBookDataList.add(new AddressBookEntry("Paul Robinson", "Male", "15/01/85"));
		addressBookDataList.add(new AddressBookEntry("Gemma Lane", "Female", "20/11/91"));
		addressBookDataList.add(new AddressBookEntry("Sarah Stone", "Female", "20/09/80"));
		addressBookDataList.add(new AddressBookEntry("Wes Jackson", "Male", "14/08/74"));
		
		return addressBookDataList;
	}

}
