package amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.actiondriver.Action;
import amazon.base.BaseClass;

public class searchresultpage extends BaseClass {
	
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement productresult;
	
	public searchresultpage() {
		 PageFactory.initElements(driver, this);             
		}

	public boolean isproductavailable() {
		return Action.isDisplayed(driver, productresult);
	}
	
	public addtocartpage clickonproduct() {
		Action.click(driver, productresult);
		return new addtocartpage();
		
	}
}
