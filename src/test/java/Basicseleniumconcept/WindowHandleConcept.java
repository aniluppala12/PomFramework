package Basicseleniumconcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseClass.browserSetUp;
import ObjectRepository.LoginPage;

public class WindowHandleConcept {
	
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
		driver = browserSetUp.StartBrowser(prop.getProperty("browername"),"http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//a/button[contains(text(),'click')]")).click();
		
		Set<String> set  =driver.getWindowHandles();
		
		Iterator<String> it = set.iterator();
		
		String parentwindowid = it.next();
		System.out.println("parent window session id : " + parentwindowid);
		
		String childwindowid = it.next();
		System.out.println("child window session id : " + childwindowid);
		
		driver.switchTo().window(childwindowid);
		System.out.println("child window title : " + driver.getTitle());
		
		driver.close();
		driver.switchTo().window(parentwindowid);
		System.out.println("parent window title : " + driver.getTitle());
		
		Thread.sleep(10000);
		driver.close();
		
	}

}
