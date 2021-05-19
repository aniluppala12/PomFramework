package TestCaseExecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseClass.browserSetUp;
import ObjectRepository.LoginPage;

public class dependsonmethodsconcept {

	WebDriver driver;
	LoginPage loginpage;
	FileInputStream fs;
	Properties prop;

	String filename = System.getProperty("user.dir") + "\\config\\Input.properties";

	@Test
	public void SignIn() throws InterruptedException, IOException {
		fs = new FileInputStream(filename);
		prop = new Properties();
		prop.load(fs);
		driver = browserSetUp.StartBrowser(prop.getProperty("browername"), prop.getProperty("Url"));
		
		
	}
	
	@Test(dependsOnMethods= {"SignIn"})
	public void LoginFunctionality_One() throws InterruptedException, IOException {
		
		loginpage = new LoginPage(driver);
		browserSetUp.waitTime(1000);
		loginpage.UserName(prop.getProperty("UserName"));
		browserSetUp.waitTime(1000);
		loginpage.Password(prop.getProperty("Password"));
		browserSetUp.waitTime(1000);
		loginpage.LoginButton();
		browserSetUp.waitTime(1000);
	}
	
	@Test
	public void LoginFunctionality_Two() throws InterruptedException, IOException {
		
		loginpage = new LoginPage(driver);
		browserSetUp.waitTime(1000);
		loginpage.UserName(prop.getProperty("UserName"));
		browserSetUp.waitTime(1000);
		loginpage.Password(prop.getProperty("Password"));
		browserSetUp.waitTime(1000);
		loginpage.LoginButton();
		browserSetUp.waitTime(1000);
	}
}
