package TestCaseExecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.browserSetUp;
import ObjectRepository.AdminPage;
import ObjectRepository.LoginPage;

public class AdminTest {
	
	WebDriver driver;
	LoginPage loginpage;
	AdminPage adminpage;
	FileInputStream fs;
	Properties prop;
	
	String filename=System.getProperty("user.dir")+"\\config\\Input.properties";
	
	@BeforeMethod
	public void HomeVigation() throws IOException, InterruptedException {
		
		fs=new FileInputStream(filename);
		prop=new Properties();
		prop.load(fs);
		driver = browserSetUp.StartBrowser(prop.getProperty("browername"),prop.getProperty("Url"));
	}
	
	@Test
	public void LoginFunctionality() throws InterruptedException {
	  loginpage = new LoginPage(driver);
	  adminpage = new AdminPage(driver);
	  browserSetUp.waitTime(1000);
	  loginpage.UserName(prop.getProperty("UserName"));
	  browserSetUp.waitTime(1000);
	  loginpage.Password(prop.getProperty("Password"));
	  browserSetUp.waitTime(1000);
	  loginpage.LoginButton();
	  browserSetUp.waitTime(1000);
	  adminpage.AdminTab();
	  adminpage.UserNameTextBox("Admin");
	  browserSetUp.waitTime(1000);
	  adminpage.SearchBtn();
	  browserSetUp.waitTime(1000);
	  adminpage.VerifyEnabled();
	  browserSetUp.waitTime(1000);
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}
