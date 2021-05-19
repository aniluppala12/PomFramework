package Basicseleniumconcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.browserSetUp;
import ObjectRepository.LoginPage;

public class dropdownconcepts {
	
	WebDriver driver;
	LoginPage loginpage;
	FileInputStream fs;
	Properties prop;
	String filename=System.getProperty("user.dir")+"\\config\\Input.properties";
	
	
	@Test
	public void handlewindow()throws IOException, InterruptedException {
		
		fs=new FileInputStream(filename);
		prop=new Properties();
		prop.load(fs);
		driver = browserSetUp.StartBrowser(prop.getProperty("browername"),"http://the-internet.herokuapp.com/dropdown");
		
	    Select dropdown =  new Select(driver.findElement(By.id("dropdown")));
	    Thread.sleep(1000);
	    dropdown.selectByIndex(1);
	    dropdown.selectByValue("2");
	    dropdown.selectByVisibleText("Option 1");
	    
		
		Thread.sleep(1000);
		driver.close();
		
	}

}
