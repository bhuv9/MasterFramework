package com.salesforce.runnerclass;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.salesforce.baseclass.Salesforce_baseclass;
import com.salesforce.configuration.File_Reader_Manager;

import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/salesforce/feature/Salesforce.feature"
,glue ="com/salesforce/stepDefinition", publish = true, dryRun = false, monochrome = true)
public class Salesforce_Runner extends Salesforce_baseclass {


	@BeforeClass
	public  void set_Up() throws IOException {
    String browser = File_Reader_Manager.getInstance().getConfigReader().browser();
    getBrowser(browser);
	}
	
	@AfterClass
	public  void quitDriver() {
		getDriver().quit();
	}

}
