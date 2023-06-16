package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.admin.BaseTest;

import Utility.Util;

public class ProductPage extends BaseTest {

WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy	
	(xpath ="//div[@class='ivu-layout-sider-children']//a[@href='/data/products']") 
	public WebElement Product;
	
	@FindBy	
	(xpath ="//span[contains(text(),'Products ')]") 
	public WebElement ProductsList;
	
	@FindBy	
	(xpath ="//button//i[contains(@class,'ion-md-add')]") 
	public WebElement AddProductButton;

	@FindBy	
	(xpath ="//div[contains(text(),'Create Product')]") 
	public WebElement CreateProductForm;
	
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form-label-top')]/div[1]//input") 
	public WebElement Name;

	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form-label-top')]/div[2]//input") 
	public WebElement Price;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form-label-top')]/div[3]//input") 
	public WebElement Discription;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form-label-top')]/div[4]//input") 
	public WebElement Category;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form-label-top')]/div[5]//input") 
	public WebElement Slug;
	
	@FindBy	
	(xpath ="//form[contains(@class,'ivu-form-label-top')]/div[6]//input") 
	public WebElement ReleaseYear;
	
	@FindBy	
	(xpath ="//button//span[text()='Save']") 
	public WebElement BtnSave;
	
	@FindBy	
	(xpath ="//div[contains(@class,'ivu-message-info')]//span") 
	public WebElement ProductAddSuccessMessage;
	
	
	
	
	public void CreateProduct()
	{

		String randomString = Util.randomAlphanumericString(6);
		Product.click();
		System.out.println("Clicked on Product Menu.");
		
		wait.until(ExpectedConditions.visibilityOf(ProductsList));
		System.out.println("Product List Display");
		
		AddProductButton.click();
		System.out.println("Clicked on Add Product Button ");
		
		wait.until(ExpectedConditions.visibilityOf(CreateProductForm));
		System.out.println("Create Product Form Displayed.");
		
		
		Name.sendKeys(Prod);
		System.out.println("- Entered Name.");
		
		Price.sendKeys("1000");
		System.out.println("- Entered Price");
		
		Discription.sendKeys("QA Discription");
		System.out.println("- Entered Discription.");
		
		Category.sendKeys("QA Category");
		System.out.println("- Entered Category.");
		
		Slug.sendKeys(randomString+"_Slug");
		System.out.println("- Entered Slug.");
		
		ReleaseYear.sendKeys("2023");
		System.out.println("- Entered Release Year.");
				
		BtnSave.click();
		System.out.println("- Clicked Save button");
		
		
		wait.until(ExpectedConditions.visibilityOf(ProductAddSuccessMessage));
		Assert.assertEquals(ProductAddSuccessMessage.getText(), "Product has been created");
		System.out.println("- Product has been created");

	}
	
	
}
