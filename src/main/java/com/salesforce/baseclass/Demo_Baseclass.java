package com.salesforce.baseclass;

import java.io.IOException;

import org.apache.commons.io.output.DemuxOutputStream;
import org.openqa.selenium.By;

public class Demo_Baseclass  extends Salesforce_baseclass{
	
	private void executeSteps() throws IOException {
		getBrowser("chrome");
		getUrl("https://login.salesforce.com/?locale=in");
		sendKeys(getDriver().findElement(By.id("username")), "bhuvanesh.moorthy@testleaf.com");
		sendKeys(getDriver().findElement(By.id("password")), "Test@2025");
		click(getDriver().findElement(By.id("Login")));
		takesSnap();
		exitBrowser();
	}

	public static void main(String[] args) throws IOException {
		Demo_Baseclass sales = new Demo_Baseclass();
		sales.executeSteps();
	}
	

}
