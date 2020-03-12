package samplePage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends pages {
	static WebDriver driver;
	
	public static void loginCheck() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/koner/OneDrive/Desktop/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome is launched");
		String url = "https://demo.saloodo.com";
		driver.get(url);

		System.out.println("Demo site is opened");
		
		/* Clicking Login Button */
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		System.out.println("Login btn is visible");
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		System.out.println("Login Button is clicked");

		
		/* Entering email address for login */
		WebElement emailLabel = driver.findElement(By.xpath("//label[contains(text(),'Email')]"));
		WebElement emailInput = driver.findElement(By.xpath("//input[@type='text'][@name='_email']"));
		Actions action = new Actions(driver);
		if (emailLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(emailLabel));
			action.moveToElement(emailLabel).click().perform();
			emailInput.isEnabled();
			emailInput.sendKeys("lavanya.poorni@gmail.com");
			System.out.println("Email is entered");
		} else {
			emailInput.isEnabled();
			emailInput.sendKeys("lavanya.poorni@gmail.com");
			System.out.println("Email is entered");
			
			
			/* Entering password for login */
			WebElement pswdLabel = driver.findElement(By.xpath("//label[contains(text(),'Email')]"));
			WebElement pswdInput = driver.findElement(By.xpath("//input[@type='text'][@name='_email']"));
			if (pswdLabel.isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(pswdLabel));
				action.moveToElement(pswdLabel).click().perform();
				pswdInput.isEnabled();
				pswdInput.sendKeys("test@123");
				System.out.println("Password is entered");
			} else {
				pswdInput.isEnabled();
				pswdInput.sendKeys("test@123");
				System.out.println("Password is entered");
			}
		}
}
}
