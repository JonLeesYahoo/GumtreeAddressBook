package org.gumtree.office.addressbook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookAppTest 
{

	private Path file = Paths.get("AddressBook").toAbsolutePath();
	
	@Test
	public void testLoad() {

	    AddressBookApp app = new AddressBookApp();
	    List<String> data = app.load(file);

	    Assert.assertEquals(5, data.size());
	}
}
