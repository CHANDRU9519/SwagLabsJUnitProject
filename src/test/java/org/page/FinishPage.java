package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage extends BaseClass {
	
	public FinishPage() {
		PageFactory.initElements(driver, this);
	}

	//Validation
	@FindBy(xpath="//div[text()='Finish']")
	public WebElement finish;

	public WebElement getFinish() {
		return finish;
	}
	
	//Information
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	public WebElement finalInfo;

	public WebElement getFinalInfo() {
		return finalInfo;
	}
	
	
}
