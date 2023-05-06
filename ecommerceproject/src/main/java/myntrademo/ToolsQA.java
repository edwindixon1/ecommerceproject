package myntrademo;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolsQA 
{
	ChromeDriver driver;
	JavascriptExecutor js;
	
 @BeforeTest
  public void BrowserLaunch()
  {
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		js = driver;  //Javascript Executor : For Scrolling the webpage and if we use ChromeDriver instead of WebDriver then no need to do a type casting
		
		js.executeScript("window.scrollBy(0,500)", "");
		//driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]")).click();
		
		
  }
 
  @Test(priority=1)
  public void TextBox()
  {
	   
	    driver.findElement(By.xpath("//h5[.=\"Elements\"]")).click();
		driver.findElement(By.xpath("//span[.=\"Text Box\"]")).click();
		driver.findElement(By.cssSelector("input[id=\"userName\"]")).sendKeys("Hemanth");
		driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]")).sendKeys("hemanth.kc@qualitest.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Bengaluru, Karnataka.");
		driver.findElement(By.id("permanentAddress")).sendKeys("Bengaluru, Karnataka.");
		js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.cssSelector("#submit")).click();
		
  }
  @Test(priority=2)
  public void CheckBox() throws InterruptedException
  {
	    driver.findElement(By.xpath("//span[.=\"Check Box\"]")).click();
		driver.findElement(By.cssSelector(".rct-title")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".rct-title")).click();	
		driver.findElement(By.xpath("//button[@title=\"Expand all\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".rct-checkbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title=\"Collapse all\"]")).click();
		js.executeScript("window.scrollBy(0,500)", "");  
  }
  @Test(priority=3)
  public void RadioButton() throws InterruptedException
  {
	    driver.findElement(By.xpath("//span[.=\"Radio Button\"]")).click();
		driver.findElement(By.xpath("//label[@for=\"yesRadio\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]")).click();
		js.executeScript("window.scrollBy(0,500)", "");  
  }
  @Test(priority=4)
  public void WebTables() throws InterruptedException
  {
		driver.findElement(By.xpath("//span[.=\"Web Tables\"]")).click();
		driver.findElement(By.cssSelector("#edit-record-1")).click();
		List<WebElement> elements = driver.findElements(By.cssSelector(".mr-sm-2"));
		for(int i=0;i<elements.size();i++)
		{
			elements.get(i).clear();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Hemanth");
		driver.findElement(By.id("lastName")).sendKeys("K C");  
		//driver.findElement(By.id("userEmail")).sendKeys("hemanth.kc@qualitest"); 
		driver.findElement(By.id("age")).sendKeys("22");
		driver.findElement(By.id("salary")).sendKeys("25000");
		driver.findElement(By.id("department")).sendKeys("IT");  
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class=\"action-buttons\"])[3]//span[2]")).click(); 
		

  }
  @Test(priority=5)
  public void Buttons () throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,300)", "");
	    driver.findElement(By.xpath("//span[.=\"Buttons\"]")).click();
		Actions act=new Actions(driver);   //To perform double click operation we need Action class
		WebElement ele = driver.findElement(By.cssSelector("#doubleClickBtn"));
		act.doubleClick(ele).perform();  
		WebElement Do = driver.findElement(By.cssSelector("#rightClickBtn"));
		act.contextClick(Do).perform();  
		driver.findElement(By.xpath("//button[.=\"Click Me\"]")).click();
		js.executeScript("window.scrollBy(0,500)", "");
  }
  @Test(priority=6)
  public void Links()
  {
	    driver.findElement(By.xpath("//span[.=\"Links\"]")).click();
		driver.findElement(By.linkText("Home")).click();
		
		Set<String> WindowIDs = driver.getWindowHandles();
		
	    java.util.Iterator<String> it = WindowIDs.iterator(); //when we want to switch the tab from child-parent /parent-child we use this .
	    String parentid = it.next();
	    String childid = it.next();
	    driver.switchTo().window(parentid);
		driver.findElement(By.cssSelector("#dynamicLink")).click();
		 driver.switchTo().window(parentid);
		driver.findElement(By.linkText("Created")).click();
		js.executeScript("window.scrollBy(0,600)", "");
		driver.findElement(By.linkText("No Content")).click();
		driver.findElement(By.linkText("Moved")).click();
		driver.findElement(By.linkText("Bad Request")).click();
		driver.findElement(By.linkText("Unauthorized")).click();
		driver.findElement(By.linkText("Forbidden")).click();
		driver.findElement(By.linkText("Not Found")).click();
		js.executeScript("window.scrollBy(0,-200)", "");
  }
  @Test(enabled=false)
  public void Broken_Link_Images ()
  {
		js.executeScript("window.scrollBy(0,-200)", "");
		driver.findElement(By.xpath("//span[.=\"Broken Links - Images\"]")).click();	
		js.executeScript("window.scrollBy(0,600)", "");
  }
  @Test(priority=8)
  public void Uploads_and_Downloads ()
  {
	    js.executeScript("window.scrollBy(0,600)", "");
		driver.findElement(By.xpath("//span[.=\"Upload and Download\"]")).click();	
		driver.findElement(By.partialLinkText("Download")).click();
		driver.findElement(By.xpath("//input[@id=\"uploadFile\"]")).sendKeys("C:\\Users\\hemanth.kc\\Pictures\\sampleFile.jpeg"); 
  }
  @Test(priority=9)
  public void Dynamic_Properties()
  {
	    js.executeScript("window.scrollBy(0,600)", "");
		driver.findElement(By.xpath("//span[.=\"Dynamic Properties\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#enableAfter"))).click();
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.xpath("//button[.=\"Color Change\"]")).click();
		driver.findElement(By.cssSelector("#visibleAfter")).click();
  }
  @Test(priority=10)
  public void Forms()
  
  {
	    js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.xpath("//div[.=\"Forms\"]")).click();
		driver.findElement(By.xpath("//span[.=\"Practice Form\"]")).click();
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Hemanth");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("K C");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("hemanth.kc@qualitest.com");
		js.executeScript("window.scrollBy(0,600)", "");
		driver.findElement(By.xpath("//label[.=\"Male\"]")).click();
		driver.findElement(By.cssSelector("#userNumber")).sendKeys("6362245981"); 
		driver.findElement(By.cssSelector("#dateOfBirthInput")).click(); 
		driver.findElement(By.cssSelector(".react-datepicker__month-select")).click();  
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(7));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[4]"))).click();
		driver.findElement(By.cssSelector(".react-datepicker__year-select")).sendKeys("2000");
		driver.findElement(By.xpath("(//div[.=\"12\"])[1]")).click();
  }
  @Test(priority=11)
  public void Browser_Windows() throws InterruptedException
  {
	  driver.findElement(By.xpath("//div[.=\"Alerts, Frame & Windows\"]")).click();
	  js.executeScript("window.scrollBy(0,300)", "");
	  driver.findElement(By.xpath("//span[.=\"Browser Windows\"]")).click();
	  driver.findElement(By.cssSelector("#tabButton")).click();
	  Thread.sleep(2000);
	  Set<String> WindowIDs = driver.getWindowHandles();
	  java.util.Iterator<String> it = WindowIDs.iterator(); //when we want to switch the tab from child-parent /parent-child we use this .
	   String parentid = it.next();
	   String childid = it.next();
	  driver.switchTo().window(parentid);
	  driver.findElement(By.cssSelector("#windowButton")).click();
	  driver.switchTo().window(parentid);
	  js.executeScript("window.scrollBy(0,300)", "");
	  driver.findElement(By.cssSelector("#messageWindowButton")).click();
	  driver.switchTo().window(parentid);
	  js.executeScript("window.scrollBy(0,300)", "");
  }
  @Test(priority=12)
  public void Alerts() throws InterruptedException
  {
	  driver.findElement(By.xpath("//span[.=\"Alerts\"]")).click();
	  driver.findElement(By.cssSelector("#alertButton")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  driver.findElement(By.cssSelector("#timerAlertButton")).click();  
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
	  Alert w = wait.until(ExpectedConditions.alertIsPresent());
	  Thread.sleep(2000);
	  w.accept();
	  js.executeScript("window.scrollBy(0,300)", "");
	  driver.findElement(By.cssSelector("#confirmButton")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().dismiss();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("#promtButton")).click();
	  Alert alertwindow = driver.switchTo().alert();
	  Thread.sleep(2000);
	  alertwindow.sendKeys("Hemanth");
	  alertwindow.accept();  
	  Thread.sleep(2000);
  }
  @Test(priority=13)
  public void Frames()
  {
	  js.executeScript("window.scrollBy(0,300)", "");
	  driver.findElement(By.xpath("//span[.=\"Frames\"]")).click();
	 driver.switchTo().frame("frame1");
	 System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
  }
  @Test(enabled=false)
  public void Nested_Frames()
  {
	  
  }
  @Test(priority=13)
  public void Modal_Dialogs() throws InterruptedException
  {
	  js.executeScript("window.scrollBy(0,300)", "");
	  driver.findElement(By.xpath("//span[.=\"Modal Dialogs\"]")).click();
	  driver.findElement(By.cssSelector("#showSmallModal")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("#closeSmallModal")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("#showLargeModal")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("#closeLargeModal")).click();
  }
  
  @AfterTest
  public void close_browser()
  {
	  driver.quit();
  }
   
 }

