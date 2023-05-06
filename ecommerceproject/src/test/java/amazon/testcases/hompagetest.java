package amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import amazon.base.BaseClass;

public class hompagetest extends BaseClass {


	@BeforeMethod
	public void setup() {
		launchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
