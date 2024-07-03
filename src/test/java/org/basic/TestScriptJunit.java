package org.basic;

import java.io.IOException;

import org.global.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.page.CheckoutYourInfoPage;
import org.page.FinishPage;
import org.page.LoginPage;
import org.page.OverviewPage;
import org.page.ProductsPage;
import org.page.YourCartPage;

public class TestScriptJunit {
	public static BaseClass base = new BaseClass();
	public static LoginPage loginPage = new LoginPage();
	public static ProductsPage productsPage = new ProductsPage();
	public static YourCartPage yourCartPage = new YourCartPage();
	public static CheckoutYourInfoPage checkoutYourInfoPage = new CheckoutYourInfoPage();
	public static OverviewPage overviewPage = new OverviewPage();
	public static FinishPage finishPage = new FinishPage();
	
	
	
	@BeforeClass
	public static void BrowserLaunch() throws IOException {

		// Launch the Driver
		base.getDriver(base.readExcell(4, 0));

		// Launch the URL
		base.getUrl(base.readExcell(4, 1));
	}

	@Before
	public void Login() throws IOException {
		loginPage = new LoginPage();
		if(loginPage.getUserLoginPage().isDisplayed()) {
			System.out.println("User successfully launched the Browser and open the Website");
		}
		else {
			System.out.println("Browser launched but the Website not open");
		}
		
		// Enter User Name
		WebElement userName = loginPage.getUserName();
		base.textSend(userName, base.readExcell(4, 2));

		// Enter Password
		WebElement password = loginPage.getPassword();
		base.textSend(password, base.readExcell(4, 3));

		// Click Login
		WebElement login = loginPage.getLogin();
		base.pressClick(login);
	}
	
	@Test
	public void Products() throws IOException, InterruptedException {
		
		
		productsPage = new ProductsPage();
		yourCartPage = new YourCartPage();
		checkoutYourInfoPage = new CheckoutYourInfoPage();
		
		
		//Validating Login
		if(productsPage.getProducts().isDisplayed()) {
			System.out.println("User sucessfully Logged in and in the Products Page");
		}
		else {
			System.out.println("User does not Login,Make sure the UserId and Password is correct ");
		}
		
		
		base.hold(10000);
		
		
		//Product 1 Add to Cart
		WebElement product1 = productsPage.getProduct1();
		base.pressClick(product1);
		
		//Product 2 Add to Cart
		WebElement product2 = productsPage.getProduct2();
		base.pressClick(product2);
		
		//Product 3 Add to Cart
		WebElement product3 = productsPage.getProduct3();
		base.pressClick(product3);
		
		//Product 4 Add to Cart
		WebElement product4 = productsPage.getProduct4();
		base.pressClick(product4);
		
		//Product 5 Add to Cart
		WebElement product5 = productsPage.getProduct5();
		base.pressClick(product5);
		
		//Product 6 Add to Cart
		WebElement product6 = productsPage.getProduct6();
		base.pressClick(product6);
		
		//Validating Number of Products in the Cart
		WebElement cartContainer2 = productsPage.cartContainer;
		System.out.println("Number of Products in the Cart :"+base.elementText(cartContainer2));
		
		//Entering Cart
		WebElement cartContainer = productsPage.getCartContainer();
		base.pressClick(cartContainer);
		
		//Validating Cart Page
		if(yourCartPage.getYourCartConform().isDisplayed()) {
			System.out.println("User is in the Cart Page");
		}
		else {
			System.out.println("User not in Cart");
		}
		
		//Removing Product1
		WebElement removeProduct1 = yourCartPage.getRemoveProduct1();
		base.pressClick(removeProduct1);
		
		//Removing Product2
		WebElement removeProduct2 = yourCartPage.getRemoveProduct1();
		base.pressClick(removeProduct2);
		
		//Validating the Cart after removing Products
		WebElement yourCartContainer = yourCartPage.getYourCartContainer();
		System.out.println("Number of Products after Removing the items :"+base.elementText(yourCartContainer));
		
		//Checking out
		WebElement checkOut = yourCartPage.getCheckOut();
		base.pressClick(checkOut);
		
		//Validating Checkout Information page
		if(checkoutYourInfoPage.getCheckoutInfo().isDisplayed()) {
			System.out.println("User in the Checkout Page and have to enter the Details");
		}
		else {
			System.out.println("User doesnot in the Checkout page");
		}
		
		//Enter First Name
		WebElement firstName = checkoutYourInfoPage.getFirstName();
		base.textSend(firstName, base.readExcell(4, 4));
		
		//Enter Last Name
		WebElement lastName = checkoutYourInfoPage.getLastName();
		base.textSend(lastName, base.readExcell(4, 5));
		
		//Enter Postal Code
		WebElement postCode = checkoutYourInfoPage.getPostCode();
		base.textSend(postCode, base.readExcell(4, 6));
		
		WebElement continueButton = checkoutYourInfoPage.getContinueButton();
		base.pressClick(continueButton);	
	}
	
	
	@After
	public void Overview() {
		
		overviewPage = new OverviewPage();
		
		//Validating the Overview Page
		if(overviewPage.getOverviewInfo().isDisplayed()) {
			System.out.println("User is in the Final page");
		}
		else {
			System.out.println("User not in the Final Page");
		}
		
		//Continue
		WebElement finishButton = overviewPage.getFinishButton();
		base.pressClick(finishButton);
	}
	
	@AfterClass
	public static void finish() throws InterruptedException {
		
		finishPage = new FinishPage();
		
		
		if(finishPage.getFinish().isDisplayed()) {
			System.out.println("User successfully purchased the product");
		}
		else {
			System.out.println("Order not yet Placed");
		}
		WebElement finalInfo = finishPage.getFinalInfo();
		System.out.println("Final Information :"+base.elementText(finalInfo));
		
		base.hold(5000);
		
		base.close();
		
		System.out.println("Bye Bye");
		
	}
	
	
	
}
