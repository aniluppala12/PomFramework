package Basicseleniumconcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.browserSetUp;
import ObjectRepository.LoginPage;

public class IframeConcept {
	
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
		driver = browserSetUp.StartBrowser(prop.getProperty("browername"),"https://jqueryui.com/autocomplete/");
		
		List<WebElement> iframehandle = driver.findElements(By.tagName("iframe"));
		int count = iframehandle.size();  //4  : 0,1,2,3
		System.out.println("Iframe count : " + count);
		
		for(int i=0;i<count;i++) {
			driver.switchTo().frame(i);
			driver.findElement(By.id("tags")).sendKeys("Selenium");
			break;
		}
		
		
		Thread.sleep(1000);
		driver.close();
		
	}

}
