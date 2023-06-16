package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.admin.BaseTest;

public class OrderPage extends BaseTest {

	public OrderPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		productPage =  new ProductPage(driver);
	}

	@FindBy	
	(xpath ="//div[@class='ivu-layout-sider-children']//a[@href='/data/orders']") 
	public WebElement Order;
	
	@FindBy	
	(xpath ="//span[contains(text(),'Orders ')]") 
	public WebElement OrdersList;
	
	@FindBy	
	(xpath ="//button//i[contains(@class,'ion-md-add')]") 
	public WebElement AddOrdertButton;

	@FindBy	
	(xpath ="//div[contains(text(),'Create Order')]") 
	public WebElement CreateOrderForm;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]//i[contains(@class,'ivu-select-arrow')]") 
	public WebElement SelectCustomer;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]//div[contains(@class,'ivu-select')]//ul[@class='ivu-select-dropdown-list']") 
	public WebElement CustomerDropdown;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]/div[2]//input") 
	public WebElement AddLineOne;
	
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]/div[4]//input") 
	public WebElement City;
	

	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]/div[5]//input") 
	public WebElement State;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]/div[6]//input") 
	public WebElement Zip;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]/div[7]//input") 
	public WebElement Status;
	
	public void CreateOrder() throws InterruptedException {

		Order.click();
		System.out.println("CLicked Order Menu");
		
		wait.until(ExpectedConditions.visibilityOf(OrdersList));
		System.out.println("Orders List Display");
		
		AddOrdertButton.click();
		wait.until(ExpectedConditions.visibilityOf(CreateOrderForm));
		System.out.println("Create Order Form Display.");
		
		SelectCustomer.click();	
		Thread.sleep(2000);
		List<WebElement> customerList=CustomerDropdown.findElements(By.tagName("li"));
		
		for (WebElement li : customerList) {
			if (li.getText().equals("#2 Elvin Runolfsson")) {
			     li.click();
			   }
			}
		System.out.println("- Customer Selected");
		
		
		AddLineOne.sendKeys(Ord);
		System.out.println("- Entered Address Line One.");
		
		City.sendKeys("QA City");
		System.out.println("- Entered City.");
		
		State.sendKeys("QA State");
		System.out.println("- Entered State.");
		
		Zip.sendKeys("380001");
		System.out.println("- Entered Zip.");
		
		Status.sendKeys("Blocked");
		System.out.println("- Entered Status.");
		
		productPage.BtnSave.click();
		System.out.println("- Clicked Save button");
		
		wait.until(ExpectedConditions.visibilityOf(productPage.ProductAddSuccessMessage));
		Assert.assertEquals(productPage.ProductAddSuccessMessage.getText(), "Order has been created");
		System.out.println("- Order has been created");
		
	}
	

}
