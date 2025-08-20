package com.salesforce.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.salesforce.baseclass.Salesforce_baseclass;
import com.salesforce.configuration.File_Reader_Manager;
import com.salesforce.configuration.PageObjectManager;
import com.salesforce.runnerclass.Salesforce_Runner;

import io.cucumber.java.en.*;

public class Salesforce_Stepdefiniton extends Salesforce_baseclass {

	//public static WebDriver driver = Salesforce_Runner.driver;
	PageObjectManager pom = new PageObjectManager();

	@Given("user wants to login the crm application")
	public void user_wants_to_login_the_Salesforce_application() throws Throwable {
		getUrl(File_Reader_Manager.getInstance().getConfigReader().siteAddress());
	}

	@When("user want to enter {string} the valid username")
	public void user_want_to_enter_the_valid_username(String string) {
		sendKeys(pom.getInstanceLogin().getUsername(), string);
	}

	@When("user want to enter {string} the valid password")
	public void user_want_to_enter_the_valid_password(String string) {
		sendKeys(pom.getInstanceLogin().getPassword(), string);
	}

	@Then("^user verify the valid username and password$")
	public void user_verify_the_valid_username_and_password() throws Throwable {
		click(pom.getInstanceLogin().getLogin());
		takesSnap();
	}

}
