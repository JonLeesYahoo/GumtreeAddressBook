package org.gumtree.office.addressbook;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
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
	public List<String> load(Path file) {
		List<String> data = null;
		try {
			data = java.nio.file.Files.readAllLines(file, Charset.defaultCharset());
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	    return data;
	}

}
