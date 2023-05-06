/**
 * 
 */
package amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.base.BaseClass;
import amazon.pageobjects.Homepage;
import amazon.pageobjects.Indexpage;
import amazon.pageobjects.Loginpage;

/**
 * @author edwin.kattumath
 *
 */
public class loginpagetest extends BaseClass {
	
	Indexpage indexpage;
	Loginpage loginpage;
	Homepage homepage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void logintest() {
		indexpage=new Indexpage();
		loginpage=indexpage.clickonsignin();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		/*String actualurl=homepage.getcurrenturl();
		String expectedurl="https://www.amazon.in/ap/signin";
		Assert.assertEquals(actualurl, expectedurl);*/
		
		
		
		
		
	}

}
