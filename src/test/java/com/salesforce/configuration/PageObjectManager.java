package com.salesforce.configuration;

import org.openqa.selenium.WebDriver;

import com.salesforce.pom.LoginPage;

public class PageObjectManager  {
	 private LoginPage lp;

	    // No need to pass driver anymore
	    public PageObjectManager() {
	    }

	    public LoginPage getInstanceLogin() {
	        if (lp == null) {
	            lp = new LoginPage(); // no driver argument
	        }
	        return lp;
	    }
	
	

}
