package testngpackge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BestBuy {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void wait_() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}

	@Test(priority = 1)
	public void get() {
		driver.get("https://www.bestbuy.ca");
	}

	@Test(priority = 2)
	public void serach() {
		driver.findElement(By.xpath("//input[@name='search' and contains(@placeholder,'Search Best Buy')]")).sendKeys("ipad");

	}

	@Test(priority = 3)
	public void waitAndClick() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("autocompleteLink_3QJrx")));
		driver.findElement(By.xpath("//a[@class='autocompleteLink_3QJrx' and contains(@data-automation,'autocomplete-entry-4')]")).click();
	}

	@Test(priority = 4)
	public void OnlineOnly() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.className("flexValue_3XOP_"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(By.id("facetFilter-Online Only")).click();
	}

	@Test(priority = 5)
	public void selectOne() {
		driver.findElement(By.partialLinkText("Apple iPad Air 10.9-inch, Wi-Fi")).click();

	}

	@Test(priority = 6)
	public void addToCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.className("productActionContainer_2cpo_"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'test\']/button")));
		driver.findElement(By.xpath("//*[@id=\'test\']/button")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'button_E6SE9 primary_1oCqK addToCartButton_1op0t addToCartButton regular_1jnnf ')]")));

		driver.findElement(By.xpath("//button[contains(@class,'button_E6SE9 primary_1oCqK addToCartButton_1op0t addToCartButton regular_1jnnf ')]")).click();
	}

	@Test(priority = 7) 
	  public void chechoutAsGuest() {
	  driver.findElement(By.className("_3Po4I guest-continue-link")).click();
}
	@Test(priority = 8) public void addressDetail() {
	  driver.findElement(By.id("email")).sendKeys("mishraatul65@gmail.com");
	  driver.findElement(By.id("firstName")).sendKeys("atul");
	  driver.findElement(By.id("lastName")).sendKeys("mishra");
	  driver.findElement(By.id("phoneNumber")).sendKeys("9039817558");
	  driver.findElement(By.id("addressLine1")).sendKeys("indore");
	  driver.findElement(By.id("city")).sendKeys("indore"); 
	  Select s=new Select(driver.findElement(By.id("regionCode"))); s.selectByValue("NU");
	  driver.findElement(By.id("postalCode")).sendKeys("482002");
	  driver.findElement(By.
	  className("button_2MMWS primary_5qmKv continue-to-payment regular_XiOzA")).
	  click();
	  }  
	@Test(priority = 9) public void masterardPayement() {
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  
	  }

	@AfterTest

	public void closeBrowser() {
		 driver.close();
	}
}
