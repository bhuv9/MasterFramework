package com.salesforce.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class Salesforce_baseclass extends AbstractTestNGCucumberTests {
	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	public static WebDriverWait wait;

	public void setDriver(String browser) {
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			options.addArguments("guest");
			remoteWebdriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			remoteWebdriver.set(new FirefoxDriver());
			break;
		case "edge":
			remoteWebdriver.set(new EdgeDriver());
			break;
		case "ie":
			remoteWebdriver.set(new InternetExplorerDriver());
		default:
			break;
		}
	}

	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}

	public void getBrowser(String browsername) {

		try {
			setDriver(browsername);
			getDriver();

		} catch (Exception e) {
			e.printStackTrace();
		}

		getDriver().manage().window().maximize();

	}

	public void getUrl(String url) {

		try {
			getDriver().get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendKeys(WebElement element, String value) {

		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void takesSnap() throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) getDriver();
			File srcfile = ts.getScreenshotAs(OutputType.FILE);
			File target = new File("./SnapShot/certificate.png");
			FileUtils.copyFile(srcfile, target);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void click(WebElement ele) {
		try {
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void exitBrowser() {

		getDriver().quit();
	}

	public void alert() {
		Alert alert = getDriver().switchTo().alert();
		alert.dismiss();

	}

	public void actions(WebElement ele) {

		Actions ac = new Actions(getDriver());
		ac.moveToElement(ele).perform();
	}

	public void scrollUp(WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("argument[0].scrollIntoView();", ele);
	}

	public void implicitWaits() {

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void explicitWaits(WebElement ele) {

		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void Actionsclass(WebElement ele) {

		Actions ac = new Actions(getDriver());
		ac.moveToElement(ele).build().perform();

	}

	public void dragAndDrop(WebElement source, WebElement target) {

		Actions ac = new Actions(getDriver());
		ac.dragAndDrop(source, target).build().perform();
		;
	}

	public void dragAndDrop2(WebElement source, int from, int to) {

		Actions ac = new Actions(getDriver());
		ac.dragAndDropBy(source, from, to).build().perform();
	}

	public void locateFrame(WebElement ele) {

		getDriver().switchTo().frame(ele);
	}

	public void locateFrame(int num) {
		getDriver().switchTo().frame(num);

	}

	public void locateFrame(String s) {

		getDriver().switchTo().frame(s);
	}

	public void windowHandler(int num) {

		Set<String> sname = getDriver().getWindowHandles();
		List<String> lstname = new ArrayList<String>(sname);
		getDriver().switchTo().window(lstname.get(num));
	}
}
