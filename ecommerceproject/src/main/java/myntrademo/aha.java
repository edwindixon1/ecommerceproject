package myntrademo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class aha {

	@Test
	public void sivaji() throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
		driver.get("https://www.aha.video");
		driver.findElement(By.xpath("//h5[text()='Tamil']")).click();
		driver.findElement(By.xpath("//h4[text()='Proceed']")).click();
		
		driver.findElement(By.xpath("//div[@id='search-box']")).click();
		driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("siv");
		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		WebElement ele=(WebElement) jse.executeScript("return document.querySelector(\"body > div:nth-child(2) > app-root > div > app-home > section > app-search-page > div > div > div > qp-plus-grid\").shadowRoot.querySelector(\"div > div > div:nth-child(1) > qp-res-plus-card\").shadowRoot.querySelector(\"div > qp-card-content\").shadowRoot.querySelector(\"div > qp-image\").shadowRoot.querySelector(\"div > a > img\")");
//		
//		String js ="arguments[0].click()";
//		jse.executeScript(js, ele);
		
		driver.findElement(By.xpath("//qp-plus-grid")).getShadowRoot()
		.findElement(By.cssSelector("qp-res-plus-card.hydrated")).getShadowRoot()
		.findElement(By.cssSelector("qp-card-content.hydrated")).getShadowRoot()
		.findElement(By.cssSelector("qp-image.hydrated")).getShadowRoot()
		.findElement(By.cssSelector("qp-res-plus-card.hydrated")).getShadowRoot()
		.findElement(By.cssSelector("qp-card-content.hydrated")).getShadowRoot()
		.findElement(By.cssSelector("qp-image.hydrated")).getShadowRoot()
		.findElement(By.cssSelector("div.imgContainer")).click();
		//driver.findElement(By.xpath("//button[.=' Play Trailer ']")).click();
		
		
		
		

	}

}
