package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserSetUp {
	
	static WebDriver driver;
	
	public static WebDriver StartBrowser(String browername, String Url) throws InterruptedException {
		
		if (browername.equalsIgnoreCase("chrome")) {
		String driverpath= System.getProperty("user.dir") + "\\config\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
			
		}else
			if (browername.equalsIgnoreCase("firefox")) {
			String driverpath= System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new FirefoxDriver();
		}
		waitTime(100);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Url);
		waitTime(100);
		return driver;
	}
	
	
	public static void waitTime(Integer milliSeconds) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(milliSeconds);
	}
}
