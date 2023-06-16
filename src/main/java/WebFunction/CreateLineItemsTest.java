package WebFunction;

import org.testng.annotations.Test;

import com.admin.BaseTest;

public class CreateLineItemsTest extends BaseTest {

	
	/*@Test(priority = 0)
	public void  LoginBeforeCreateProduct() throws InterruptedException {
	
		System.out.println("\n--> Login with valid credentials");
		loginPage.Login();
	}*/
	
	@Test(priority = 1)
	public void CreateLineItem() throws InterruptedException
	{
		System.out.println("\n--> Creating Line Item");
		lineItemsPage.CreateLineItem();
	}
	
	@Test(priority = 2)
	public void ToVerifyValidation() throws InterruptedException
	{
		
		System.out.println("\n--> Check the validation on Line Item Creation");
		lineItemsPage.ToVerifyValidation();
	}
	@Test(priority = 3)
	public void ToVerifyLineItemFilter() throws InterruptedException
	{
		
		System.out.println("\n--> Verify the filter");
		lineItemsPage.ToVerifyLineItemFilter();
	}
}
