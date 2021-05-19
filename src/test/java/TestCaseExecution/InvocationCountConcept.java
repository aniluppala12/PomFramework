package TestCaseExecution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseClass.browserSetUp;
import ObjectRepository.LoginPage;

public class InvocationCountConcept {
	WebDriver driver;
	LoginPage loginpage;
	FileInputStream fs;
	Properties prop;
	
	String filename=System.getProperty("user.dir")+"\\config\\Input.properties";
	
	@Test(invocationCount = 2)
	public void add() throws IOException, InterruptedException {
		
		fs=new FileInputStream(filename);
		prop=new Properties();
		prop.load(fs);
		driver = browserSetUp.StartBrowser(prop.getProperty("browername"),prop.getProperty("Url"));
		 loginpage = new LoginPage(driver);
		  browserSetUp.waitTime(1000);
		  loginpage.UserName(prop.getProperty("UserName"));
		  browserSetUp.waitTime(1000);
		  loginpage.Password(prop.getProperty("Password"));
		  browserSetUp.waitTime(1000);
		  loginpage.LoginButton();
		  browserSetUp.waitTime(1000);
		  driver.close();
	}

}
