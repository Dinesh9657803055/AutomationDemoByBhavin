package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.admin.BaseTest;

public class LoginPage extends BaseTest{
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy	
	(xpath ="//h1[contains(text(),'Hello Admin')]") 
	public WebElement DashboardScreen;
	

	@FindBy	
	(id = "admin_user_email") 
	public WebElement Username;
	
	@FindBy	
	(id = "admin_user_password") 
	public WebElement Password;
	
	@FindBy	
	(name="commit") 
	public WebElement LogiInButton;
	
	
	
	public void Login() throws InterruptedException
	{

		Username.clear();
		Username.sendKeys("jaysoni.bca@gmail.com");
		System.out.println("Entered Username.");
		Password.clear();
		Password.sendKeys("hello123");
		System.out.println("Entered Password.");
		LogiInButton.click();
		System.out.println("Click on Login");
		
		wait.until(ExpectedConditions.visibilityOf(DashboardScreen));
		Assert.assertEquals(DashboardScreen.getText(), "Hello Admin 👋");
		System.out.println("Login Successfully.");
		
	}

}
