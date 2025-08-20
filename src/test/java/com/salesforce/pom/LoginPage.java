package com.salesforce.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.baseclass.Salesforce_baseclass;

public class LoginPage extends Salesforce_baseclass {
	
	
	
	public LoginPage() {
        PageFactory.initElements(getDriver(), this);  // getDriver() from baseclass
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Login")
    private WebElement login;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogin() {
        return login;
    }
	

}
