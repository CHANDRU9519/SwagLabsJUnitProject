package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BaseClass {
	public YourCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Validation
	@FindBy(xpath="//div[text()='Your Cart']")
	public WebElement yourCartConform;
	
	
	public WebElement getYourCartConform() {
		return yourCartConform;
	}
	
	//Remove Product 1
	@FindBy(xpath="(//button[text()='REMOVE'])[1]")
	public WebElement removeProduct1;

	public WebElement getRemoveProduct1() {
		return removeProduct1;
	}
	
	//Remove Product2
	@FindBy(xpath="(//button[text()='REMOVE'])[1]")
	public WebElement removeProduct2;

	public WebElement getRemoveProduct2() {
		return removeProduct1;
	}
	
	//Cart Validation
	@FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
	public WebElement yourCartContainer;

	public WebElement getYourCartContainer() {
		return yourCartContainer;
	}
	
	@FindBy(xpath="//a[text()='CHECKOUT']")
	public WebElement checkOut;


	public WebElement getCheckOut() {
		return checkOut;
	}
	
	
	

}
