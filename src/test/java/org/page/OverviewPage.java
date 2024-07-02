package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseClass {
	public OverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Validation
	@FindBy(xpath="//div[text()='Checkout: Overview']")
	public WebElement overviewInfo;

	public WebElement getOverviewInfo() {
		return overviewInfo;
	}
	
	//Finish
	@FindBy(xpath="//a[text()='FINISH']")
	public WebElement finishButton;

	public WebElement getFinishButton() {
		return finishButton;
	}
	
	

}
