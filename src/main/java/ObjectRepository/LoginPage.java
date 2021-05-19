package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='txtUsername']")
	private WebElement UserName;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@name='Submit']")
	private WebElement LoginButton;
	
	public void UserName(String strUserName) {
		UserName.sendKeys(strUserName);
	}
	
	public void Password(String strPassword) {
		Password.sendKeys(strPassword);
	}
	
	public void LoginButton() {
		LoginButton.click();
	}
	
	

}
