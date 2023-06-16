package WebFunction;

import org.testng.annotations.Test;

import com.admin.BaseTest;

public class CreateOrderTest extends BaseTest {
	
	/*@Test(priority = 0)
	public void  LoginBeforeCreateProduct() throws InterruptedException {
	
		System.out.println("\n--> Login with valid credentials");
		loginPage.Login();
	}*/
	
	@Test(priority = 1)
	public void CreateOrder() throws InterruptedException
	{
		System.out.println("\n--> Creating Order");
		orderPage.CreateOrder();
	}

}
