package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Login Validation
	@FindBy(xpath="//h4[text()='Accepted usernames are:']")
	private WebElement userLoginPage;

	public WebElement getUserLoginPage() {
		return userLoginPage;
	}
	
	//UserName
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}
	
	//Password
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}
	
	//Login Button
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}
}
