/**
 * 
 */
package amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.base.BaseClass;
import amazon.pageobjects.Indexpage;

/**
 * @author edwin.kattumath
 *
 */
public class indexpagetest extends BaseClass{
	
	Indexpage indexpage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifylogo() {
		indexpage= new Indexpage();
		boolean result=indexpage.validatelogo();
		Assert.assertTrue(result);
		
		}
	
	@Test
	public void verifytitle() {
		
		String title=indexpage.gettitle();
		
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
	}

	

}
