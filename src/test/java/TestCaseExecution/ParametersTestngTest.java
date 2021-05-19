package TestCaseExecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.browserSetUp;
import ObjectRepository.LoginPage;

public class ParametersTestngTest {

	WebDriver driver;
	LoginPage loginpage;
	FileInputStream fs;
	Properties prop;

	String filename = System.getProperty("user.dir") + "\\config\\Input.properties";

	@Parameters({ "browername", "Url" })
	@BeforeMethod
	public void HomeVigation(String browername, String Url) throws IOException, InterruptedException {
		driver = browserSetUp.StartBrowser(browername, Url);
	}

	
	@Test(priority =0 , enabled = true)
	public void LoginFunctionality_One() throws InterruptedException, IOException {
		fs = new FileInputStream(filename);
		prop = new Properties();
		prop.load(fs);
		loginpage = new LoginPage(driver);
		browserSetUp.waitTime(1000);
		loginpage.UserName(prop.getProperty("UserName"));
		browserSetUp.waitTime(1000);
		loginpage.Password(prop.getProperty("Password"));
		browserSetUp.waitTime(1000);
		loginpage.LoginButton();
		browserSetUp.waitTime(1000);
	}
	
	@Test(priority=1, enabled = false)
	public void LoginFunctionality_Two() throws InterruptedException, IOException {
		fs = new FileInputStream(filename);
		prop = new Properties();
		prop.load(fs);
		loginpage = new LoginPage(driver);
		browserSetUp.waitTime(1000);
		loginpage.UserName(prop.getProperty("UserName"));
		browserSetUp.waitTime(1000);
		loginpage.Password(prop.getProperty("Password"));
		browserSetUp.waitTime(1000);
		loginpage.LoginButton();
		browserSetUp.waitTime(1000);
	}

	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}
