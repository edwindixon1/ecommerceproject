package amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.actiondriver.Action;
import amazon.base.BaseClass;

public class Homepage extends BaseClass {
	
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement cart;
	
	@FindBy(xpath="//a[@id='nav-orders']")
	WebElement orders;

	public Homepage() {
		 PageFactory.initElements(driver, this);             
		}
	
	public boolean validatecart() {
		return Action.isDisplayed(driver, cart);
		
		
	}
	public boolean validateorders() {
		return Action.isDisplayed(driver, orders);
		
	}
	
	public String getcurrenturl() {
		String homepageurl=driver.getCurrentUrl();
		return homepageurl;
	}

	

}
