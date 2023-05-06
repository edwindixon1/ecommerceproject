package myntrademo;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
	
	@Test
	public void demoqa() {

	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/alertsWindows");
	
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)", "");
	
	//js.executeScript("window.scrollBy(0,300)", "");
	  driver.findElement(By.xpath("//span[.=\"Frames\"]")).click();
	 driver.switchTo().frame("frame1");
	 System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
	
	
	
	
	//driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\edwin.kattumath\\Documents\\certificates\\Selenium_Intermediate_Certificate.pdf");

	//WebElement upload=driver.findElement(By.xpath("//input[@id='uploadFile']"));
	//upload.click();
	
	//js.executeScript("arguments[0].click();",upload);
	
	
	
	
	//driver.findElement(By.cssSelector("#edit-record-1")).click();
	
	/*List<WebElement> Form =driver.findElements(By.cssSelector(".mr-sm-2"));
	for(int i=0;i<Form.size();i++) {
		Form.get(i).clear();
	}
	*/
	
	//driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Hemanth");
	
	
	
	}
	
}
