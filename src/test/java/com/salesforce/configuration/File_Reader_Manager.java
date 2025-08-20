package com.salesforce.configuration;

import java.io.IOException;

public class File_Reader_Manager {
	
	private static ConfigFileReader cr;
	private File_Reader_Manager() {
	}

	 public static File_Reader_Manager getInstance( ) {
		 File_Reader_Manager frm = new File_Reader_Manager();
		return frm;
	 }

	 public ConfigFileReader getConfigReader() throws IOException {
		cr = new ConfigFileReader();
		 return cr;
	 }

}
