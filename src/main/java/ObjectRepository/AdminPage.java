package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	WebDriver driver;
	
	public AdminPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[contains(text(),'Admin')]")
	private WebElement AdminTab;
	
	@FindBy(xpath="//input[@id='searchSystemUser_userName']")
	private WebElement UserNameTextBox;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement SearchBtn;
	
	
	
	public void AdminTab() {
		AdminTab.click();
	}
	
	public void UserNameTextBox(String strUserNameTextBox) {
		UserNameTextBox.sendKeys(strUserNameTextBox);
	}
	
	public void SearchBtn() {
		SearchBtn.click();
	}
	
	
	public void VerifyEnabled() {
		List<WebElement> enabled = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[5]"));
		int count = enabled.size();
		System.out.println("Size of Enabled text : " + count);
		
		for(int i=0;i<  count;i++) {
			String str = enabled.get(i).getText() ;
			System.out.println("Display enabled button : " +str );
		
		
		if(str.equals("Enabled")) {
			System.out.println("Status is Enabled");
		}else {
			System.out.println("Status is not Enabled");
		}
	}
	}}
	


