package WebPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.admin.BaseTest;

public class LineItemsPage extends BaseTest {

	public LineItemsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		productPage =  new ProductPage(driver);
	}
	
	

	@FindBy	
	(xpath ="//div[@class='ivu-layout-sider-children']//a[@href='/data/line_items']") 
	public WebElement LineItem;
	
	@FindBy	
	(xpath ="//span[contains(text(),'Line Items ')]") 
	public WebElement LineItemsList;
	
	@FindBy	
	(xpath ="//button//i[contains(@class,'ion-md-add')]") 
	public WebElement AddLineItemsListButton;
	
	@FindBy	
	(xpath ="//div[contains(text(),'Create Line Item')]") 
	public WebElement CreateLineItemsForm;

	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]/div[1]//i[contains(@class,'ivu-select-arrow')]") 
	public WebElement SelectOrder;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[1]//div[contains(@class,'ivu-select')]//ul[@class='ivu-select-dropdown-list']") 
	public WebElement OrderDropdown;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form ')]/div[2]//i[contains(@class,'ivu-select-arrow')]") 
	public WebElement SelectProduct;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[2]//div[contains(@class,'ivu-select')]//ul[@class='ivu-select-dropdown-list']") 
	public WebElement ProductDropdown;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[3]//input") 
	public WebElement UnitPrice;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[4]//input") 
	public WebElement Quantity;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[1]//div[@class='ivu-form-item-error-tip']") 
	public WebElement OrderError;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[2]//div[@class='ivu-form-item-error-tip']") 
	public WebElement ProductError;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[3]//div[@class='ivu-form-item-error-tip']") 
	public WebElement UnitPriceError;
	
	@FindBy
	(xpath ="//form[contains(@class,'ivu-form ')]/div[4]//div[@class='ivu-form-item-error-tip']") 
	public WebElement QuantityError;
	
	
	@FindBy	
	(xpath ="//button//span[text()='Cancel']") 
	public WebElement BtnCancel;
	
	@FindBy	
	(xpath ="//button[@data-role='filter']") 
	public WebElement BtnFilter;
	
	@FindBy	
	(xpath ="//div[contains(text(),'Line Items Filters')]") 
	public WebElement LineItemsFormFilter;
	
	@FindBy	
	(xpath ="//div[@data-role='filter-item']/div[1]//i[contains(@class,'ivu-select-arrow')]") 
	public WebElement FirstDropboxFilterSelect;
	
	@FindBy	
	(xpath ="//div[@data-role='filter-item']/div[1]//ul[@class='ivu-select-dropdown-list']") 
	public WebElement FirstDropboxFilter;
	
	
	@FindBy	
	(xpath ="//div[@data-role='filter-item']/div[2]//i[contains(@class,'ivu-select-arrow')]") 
	public WebElement SecondDropboxFIlterSelect;
	
	@FindBy	
	(xpath ="//div[@data-role='filter-item']/div[2]//ul[@class='ivu-select-dropdown-list']") 
	public WebElement SecondDropboxFilter;
	
	@FindBy	
	(xpath ="//div[@data-role='filter-item']/div[3]//input") 
	public WebElement inputFilter;
	
	@FindBy	
	(xpath ="//button//span[text()='Apply']") 
	public WebElement BtnApply;
	
	@FindBy	
	(xpath ="//div[contains(@class,'ivu-drawer-right')]") 
	public WebElement Drawer;
	
	
	
	public void CreateLineItem() throws InterruptedException {
		
		Actions act = new Actions(driver);
		
		LineItem.click();
		System.out.println("- Clicked Line Item Menu");
		
		wait.until(ExpectedConditions.visibilityOf(LineItemsList));
		System.out.println("- Line Items List Display");
		
		AddLineItemsListButton.click();
		wait.until(ExpectedConditions.visibilityOf(CreateLineItemsForm));
		System.out.println("- Create Line Items Form Display.");
		
		SelectOrder.click();
		driver.findElement(By.xpath("//form[contains(@class,'ivu-form ')]/div[1]//input")).sendKeys(Ord);
		Thread.sleep(2000);
		List<WebElement> orderList=OrderDropdown.findElements(By.tagName("li"));
		for (WebElement ordli : orderList) {
			if (ordli.getText().trim().contains(Ord)) {
	              act.click(ordli).build().perform();
	              break;
			   }
			}
		System.out.println("- Order Selected");
		
		
		
		wait.until(ExpectedConditions.visibilityOf(SelectProduct));
		SelectProduct.click();
		driver.findElement(By.xpath("//form[contains(@class,'ivu-form ')]/div[2]//input")).sendKeys(Prod);
		Thread.sleep(2000);
		List<WebElement> productList=ProductDropdown.findElements(By.tagName("li"));
		for (WebElement prdli : productList) {
			if (prdli.getText().trim().contains(Prod)) {
	              act.click(prdli).build().perform();
	              break;
			   }
			}
		System.out.println("- Product Selected");
		
		
		UnitPrice.sendKeys("10000");
		System.out.println("- Entered Unit Price");
		
		Quantity.sendKeys("1");
		System.out.println("- Entered Quantity");
		
		productPage.BtnSave.click();
		System.out.println("- Clicked Save button");
		
		wait.until(ExpectedConditions.visibilityOf(productPage.ProductAddSuccessMessage));
		Assert.assertEquals(productPage.ProductAddSuccessMessage.getText(), "Line Item has been created");
		System.out.println("- Line Item has been created");
	
	}


	public void ToVerifyValidation() {
		
		LineItem.click();
		System.out.println("- Clicked Line Item Menu");
		
		wait.until(ExpectedConditions.visibilityOf(LineItemsList));
		System.out.println("- Line Items List Display");
		
		AddLineItemsListButton.click();
		wait.until(ExpectedConditions.visibilityOf(CreateLineItemsForm));
		System.out.println("- Create Line Items Form Display.");
		
		productPage.BtnSave.click();
		System.out.println("- Clicked Save button without fill required fields.");
		
		Assert.assertEquals(ProductError.getText(), "Product is required");
		System.out.println("- Verified Product Validation-> "+ProductError.getText());
		
		Assert.assertEquals(OrderError.getText(), "Order is required");
		System.out.println("- Verified Order Validation-> "+OrderError.getText());
		
		Assert.assertEquals(UnitPriceError.getText(), "Unit price is required");
		System.out.println("- Verified Unit price Validation-> "+UnitPriceError.getText());
		
		Assert.assertEquals(QuantityError.getText(), "Quantity is required");
		System.out.println("- Verified Quantity Validation-> "+QuantityError.getText());
		
		BtnCancel.click();
		System.out.println("- Clicked Cancel button.");
		
	}


	public void ToVerifyLineItemFilter() throws InterruptedException {
		
		Actions act = new Actions(driver);

		BtnFilter.click();
		System.out.println("- Clicked Filter button.");
		
		wait.until(ExpectedConditions.visibilityOf(LineItemsFormFilter));
		System.out.println("- Line Items Filter Form Display.");
		
		FirstDropboxFilterSelect.click();
		driver.findElement(By.xpath("//div[@data-role='filter-item']/div[1]//input")).sendKeys("Prod");
		Thread.sleep(2000);
		List<WebElement> firstFilterList=FirstDropboxFilter.findElements(By.tagName("li"));
		for (WebElement firstList : firstFilterList) {
			if (firstList.getText().trim().equals("Product - Name")) {
	              act.click(firstList).build().perform();
	              break;
			   }
			}
		System.out.println("- Apply first filter as a Product - Name");
		
		SecondDropboxFIlterSelect.click();
		Thread.sleep(2000);
		List<WebElement> secondtFilterList=SecondDropboxFilter.findElements(By.tagName("li"));
		for (WebElement secondtList : secondtFilterList) {
			if (secondtList.getText().trim().contains("Contains")) {
	              act.click(secondtList).build().perform();
	              break;
			   }
			}
		System.out.println("- Apply second filter as a Contains");
		
		inputFilter.sendKeys(Prod);
		System.out.println("- Entered Product Name");
		
		BtnApply.click();
		System.out.println("- Click on Apply Button");
		
		boolean filterRecord = driver.findElement(By.xpath("//tbody[@class='ivu-table-tbody']")).isDisplayed();
		if(filterRecord)
		{
			wait.until(ExpectedConditions.invisibilityOf(Drawer));
			System.out.println("- Filtered record displays");
		}
		else {
			System.out.println("- There is no filtered data");
		}
	}

}
