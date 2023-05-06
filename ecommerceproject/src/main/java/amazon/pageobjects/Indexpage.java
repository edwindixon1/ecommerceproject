package amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.actiondriver.Action;
import amazon.base.BaseClass;

public class Indexpage extends BaseClass {
	
	@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[13]/div[2]/a[1]/span[1]")
	WebElement signinbutton;
	
	
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement amazonlogo;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchbox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchbutton;
	
	public Indexpage() {
	 PageFactory.initElements(driver, this);             
	}
	
	
	public Loginpage clickonsignin() {
		Action.click(driver, signinbutton);
		return new Loginpage();
		
	}
	
	public boolean validatelogo() {
		return Action.isDisplayed(driver, amazonlogo);
		}
	
	public String gettitle() {
		String amazontitle=driver.getTitle();
		return amazontitle;
	}
	
	public searchresultpage searchproduct(String productname) {
		Action.type(searchbox, productname);
		Action.click(driver,searchbutton );
		return new searchresultpage();
	}
	
	
	
	
	
	
	

}
