package amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.actiondriver.Action;
import amazon.base.BaseClass;

public class Loginpage extends BaseClass {
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement countinuebutton;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signinbutton;
	
	public Loginpage() {
		 PageFactory.initElements(driver, this);             
		}
		
	public Homepage login(String uname, String pword) {
		Action.type(username, uname);
		Action.click(driver, countinuebutton);
		Action.type(password, pword);
		Action.click(driver, signinbutton);
		return new Homepage();
		
		}
	
	
	
	
	

}
