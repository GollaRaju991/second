package Phone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class iphone {
	

	@Test
	public void logindetails() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("rajkumar.rvyadav@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("671432Raju@");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		Thread.sleep(2000);
		WebElement prod =products.stream().filter(a->a.findElement(By.xpath("//b[.='ZARA COAT 3']")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[routerlink$='/dashboard/cart']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-bottom-right.toast-container")));
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'India')][2]")).click();

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
			Thread.sleep(1000);
			
			String name= driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(name.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			driver.close();
			
			}
@Test
	
	public void test()
	{
		System.out.println("Hello World");
		System.out.println("Hello World2");
		System.out.println("Hello World3");
	}
@Test

public void test2()
{
	System.out.println("Hello World4");
	System.out.println("Hello World5");
}
}