package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseClass {
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Products Page Validation
	@FindBy(xpath="//div[text()='Products']")
	public WebElement products;

	public WebElement getProducts() {
		return products;
	}
	
	//Product 1
	@FindBy(xpath="(//button[text()='ADD TO CART'])[1]")
	public WebElement product1;

	public WebElement getProduct1() {
		return product1;
	}
	
	//Product 2
	@FindBy(xpath="(//button[text()='ADD TO CART'])[2]")
	public WebElement product2;

	public WebElement getProduct2() {
		return product1;
	}
	
	//Product 3
	@FindBy(xpath="(//button[text()='ADD TO CART'])[3]")
	public WebElement product3;

	public WebElement getProduct3() {
		return product1;
	}
	
	//Product 4
	@FindBy(xpath="(//button[text()='ADD TO CART'])[4]")
	public WebElement product4;

	public WebElement getProduct4() {
		return product1;
	}
	
	//Product 5
	@FindBy(xpath="(//button[text()='ADD TO CART'])[5]")
	public WebElement product5;

	public WebElement getProduct5() {
		return product1;
	}
	
	//Product 6
	@FindBy(xpath="(//button[text()='ADD TO CART'])[6]")
	public WebElement product6;

	public WebElement getProduct6() {
		return product1;
	}
	
	@FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
	public WebElement cartContainer;
	
	
	
	public WebElement getCartContainer() {
		return cartContainer;
	}

	//Number of Products Validation
	@FindBy(xpath="//span[text()='6']")
	public WebElement noOfProduct;

	public WebElement getNoOfProduct() {
		return noOfProduct;
	}
	

}
