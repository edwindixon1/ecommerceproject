package myntrademo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myntratest {
	
	
	@Test
	public void myntra() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/slider");
		
		WebElement slider=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]/input[1]"));
		Actions act=new Actions(driver);
		act.dragAndDropBy(slider, 100,0).perform();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
