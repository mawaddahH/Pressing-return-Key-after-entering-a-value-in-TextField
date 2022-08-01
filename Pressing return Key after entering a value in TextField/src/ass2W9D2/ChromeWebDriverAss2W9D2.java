package ass2W9D2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeWebDriverAss2W9D2 {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 */

	@BeforeTest
	public void setUp() {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to a WebSite
		driver.navigate().to("https://demoqa.com/text-box");

		driver.manage().window().maximize();
	}

	/**
	 * Test Entering Ways in TextFeild
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LearnEnglishWebSite() throws InterruptedException {
		// Write Ways:
		
		// First Way
		WebElement firstWay = driver.findElement(By.id("userName"));
		firstWay.sendKeys("Mawaddah");
		System.out.println("The text is " + firstWay.getAttribute("value"));
		Thread.sleep(3000);
		
		// Second Way -- https://www.browserstack.com/guide/javascriptexecutor-in-selenium
		JavascriptExecutor secondWay = (JavascriptExecutor) driver;
		secondWay.executeScript("document.getElementById('userEmail').value='MawaddahHanbali@text.com'");
		String printText = (String) secondWay.executeScript("return document.getElementById('userEmail').value");  
		System.out.println(printText);
		Thread.sleep(3000);

		
		// Third Way -- https://www.c-sharpcorner.com/article/how-to-enter-text-into-a-textbox-using-javascriptexecutor-in-selenium-webdriver/
		WebElement text = driver.findElement(By.xpath("//textarea[@id='currentAddress']")); 
		JavascriptExecutor thirdWay = (JavascriptExecutor) driver;
		thirdWay.executeScript("arguments[0].value='Hello Best Tester'", text);  
		String printText2 = (String) thirdWay.executeScript("return arguments[0].value", text);
		System.out.println(printText2);
		Thread.sleep(3000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.close();

		// Quite the selenium
		driver.quit();
	}
}
