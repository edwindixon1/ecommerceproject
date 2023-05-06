package amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.actiondriver.Action;
import amazon.base.BaseClass;

public class accountcreationpage extends BaseClass {
	
	@FindBy(xpath="//h1[contains(text(),'Create Account')]")
	WebElement formtitle;
	
	public accountcreationpage() {
		 PageFactory.initElements(driver, this);             
		}
	
	public boolean validateaccountcreatepage() {
		return Action.isDisplayed(driver, formtitle);
	}
	

}
