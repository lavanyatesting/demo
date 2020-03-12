package samplePage;

import org.openqa.selenium.By;
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
		WebElement loginBtn = driver.findElement(By.xpath("//a[text()='Login']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		System.out.println("Login btn is visible");
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		System.out.println("Login Button is clicked");

		
		/* Entering email address for login */
		driver.navigate().refresh();
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
			
		}
			/* Entering password for login */
			WebElement pswdLabel = driver.findElement(By.xpath("//label[contains(text(),'Password')]"));
			WebElement pswdInput = driver.findElement(By.xpath("//input[@type='password'][@name='_password']"));
			if (pswdLabel.isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(pswdLabel));
				action.moveToElement(pswdLabel);
				action.click(pswdLabel).perform();
				pswdInput.sendKeys("test@123");
				System.out.println("Password is entered");
			} else {
				pswdInput.isEnabled();
				pswdInput.sendKeys("test@123");
				System.out.println("Password is entered");
			}
		
		
		WebElement login = driver.findElement(By.xpath("//button[@type='submit'][text()='Log In ']"));
		wait.until(ExpectedConditions.visibilityOf(login));
		wait.until(ExpectedConditions.elementToBeClickable(login));
			login.click();
			System.out.println("Login is successful");
			
			driver.switchTo().window(driver.getWindowHandles().iterator().next());
			WebElement modalWindow = driver.findElement(By.xpath("//div[@class='modal--content']"));
			WebElement skipIt = modalWindow.findElement(By.xpath("//a[text()='Skip it']"));
			action.moveToElement(skipIt);
			action.click(skipIt).perform();
			System.out.println("Pop-up handled");
			
		WebElement userProf = driver.findElement(By.xpath("//div[@class='user-menu']"));
		wait.until(ExpectedConditions.visibilityOf(userProf));
		wait.until(ExpectedConditions.elementToBeClickable(userProf));
		userProf.click();
		
		WebElement general = driver.findElement(By.xpath("//a[contains(text(),'General')]"));
		wait.until(ExpectedConditions.visibilityOf(general));
		wait.until(ExpectedConditions.elementToBeClickable(general));
		general.click();
			System.out.println("User profile expanded and General is clicked");
		}		
			
			
		
		
	}		
