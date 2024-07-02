package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInfoPage extends BaseClass {
	public CheckoutYourInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Validation
	@FindBy(xpath="//div[text()='Checkout: Your Information']")
	public WebElement checkoutInfo;

	public WebElement getCheckoutInfo() {
		return checkoutInfo;
	}

	//FirstName
	@FindBy(id="first-name")
	public WebElement firstName;

	public WebElement getFirstName() {
		return firstName;
	}
	
	//LastName
	@FindBy(id="last-name")
	public WebElement lastName;

	public WebElement getLastName() {
		return lastName;
	}
	
	//Postal Code
	@FindBy(id="postal-code")
	public WebElement postCode;

	public WebElement getPostCode() {
		return postCode;
	}
	
	//Continue
	@FindBy(xpath="//input[@type='submit']")
	public WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}
	
	
	
	
	
	
	

}
