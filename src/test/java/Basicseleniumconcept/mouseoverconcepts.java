package Basicseleniumconcept;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mouseoverconcepts {
	WebDriver driver;
	
	String screnshotpath = System.getProperty("user.dir") + "\\screenshot\\test.png";
	
	@Test
	public void mouseover() throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		
		//Launching sample website
		driver.get("https://artoftesting.com/samplesiteforselenium");
		driver.manage().window().maximize();
		
		//Mouseover on submit button
		Actions action = new Actions(driver);
		WebElement ManualTab = driver.findElement(By.xpath("//ul[@id='menu-artoftestingmenu']/li[2]/a[1]"));
		WebElement manualTestingtab = driver.findElement(By.xpath("//ul[@id='menu-artoftestingmenu']/li[2]/ul/li[2]/a"));
		
		action.moveToElement(ManualTab).moveToElement(manualTestingtab).click().build().perform();
		
		//Thread.sleep just for user to notice the event
				Thread.sleep(3000);
				
				
				
		TakesScreenshot screenshot= (TakesScreenshot)driver;
		File scrfile =screenshot.getScreenshotAs(OutputType.FILE) ;
		File destfile = new File(screnshotpath);
		FileUtils.copyFile(scrfile, destfile);
		
		
		
		
		//Thread.sleep just for user to notice the event
		Thread.sleep(3000);
		
		//Closing the driver instance
		driver.quit();
	}

}
