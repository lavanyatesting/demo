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

public class registerPage extends pages {
	//static WebDriver driver;

	public static void registerCompany() throws Throwable {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/DriverFiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome is launched");
		String url = "https://demo.saloodo.com";
		driver.get(url);

		System.out.println("Demo site is opened");
		Thread.sleep(100);

		/* Clicking Register Button */
		WebElement registerBtn = driver.findElement(By.xpath("//button[text()='Register']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(registerBtn));
		System.out.println("REgister btn is visible");
		wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
		registerBtn.click();
		System.out.println("Register Button is clicked");

		/* Clicking Register company */

		WebElement registerComp = driver.findElement(By.xpath("//a[contains(text(),'Register Your Company')]"));
		registerComp.click();
		System.out.println("Navigating to register company modal");

		// Validating page arrival of registering company
		WebElement companyNameLabel = driver.findElement(By.xpath("//label[contains(text(),'Company Name')]"));
		WebElement companyNameInput = driver.findElement(By.xpath("//input[@type='text'][@name='name']"));
		try {
			wait.until(ExpectedConditions.visibilityOf(companyNameLabel));
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(companyNameInput));
		}
		System.out.println("Landed in register company modal");
		WebElement countryArrow = driver.findElement(By.xpath("//span[@class='Select-arrow']"));
		wait.until(ExpectedConditions.visibilityOf(countryArrow));
		wait.until(ExpectedConditions.elementToBeClickable(countryArrow));
		Actions action = new Actions(driver);
		action.moveToElement(countryArrow);
		action.click(countryArrow).perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

		/* Entering company credentials for registration */
		if (companyNameLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(companyNameLabel));
			action.moveToElement(companyNameLabel).click().perform();
			companyNameInput.isEnabled();
			companyNameInput.sendKeys("Lavs Testing Company");
			System.out.println("Company name is added");
		} else {
			companyNameInput.isEnabled();
			companyNameInput.sendKeys("Lavs Testing Company");
			System.out.println("Company name is added");
		}
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		WebElement emailAddressLabel = driver.findElement(By.xpath("//label[contains(text(),'Email address')]"));
		wait.until(ExpectedConditions.elementToBeClickable(emailAddressLabel));
		action.moveToElement(emailAddressLabel).click().perform();
		WebElement emailAddressInput = driver.findElement(By.xpath("//input[@type='text'][@name='email']"));
		emailAddressInput.isEnabled();
		emailAddressInput.sendKeys("lavanya.poorni" + randomInt + "@gmail.com");
		System.out.println("Email address is added");

		WebElement firstNameLabel = driver.findElement(By.xpath("//label[contains(text(),'First name')]"));
		wait.until(ExpectedConditions.elementToBeClickable(firstNameLabel));
		action.moveToElement(firstNameLabel).click().perform();
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@type='text'][@name='firstName']"));
		firstNameInput.isEnabled();
		firstNameInput.sendKeys("Lavanya");
		System.out.println("First Name is added");

		WebElement lastNameLabel = driver.findElement(By.xpath("//label[contains(text(),'Last name')]"));
		wait.until(ExpectedConditions.elementToBeClickable(lastNameLabel));
		action.moveToElement(lastNameLabel).click().perform();
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@type='text'][@name='lastName']"));
		lastNameInput.isEnabled();
		lastNameInput.sendKeys("Ramesh");
		System.out.println("Last Name is added");

		WebElement phoneNumLabel = driver.findElement(By.xpath("//label[contains(text(),'Phone number')]"));
		wait.until(ExpectedConditions.elementToBeClickable(phoneNumLabel));
		action.moveToElement(phoneNumLabel).click().perform();
		WebElement phoneNumInput = driver.findElement(By.xpath("//input[@type='text'][@name='phoneNumber']"));
		phoneNumInput.isEnabled();
		phoneNumInput.sendKeys("+49 1234");
		System.out.println("Phone Number is added");

		WebElement VATLabel = driver.findElement(By.xpath("//label[contains(text(),'VAT ID')]"));
		WebElement VATInput = driver.findElement(By.xpath("//input[@type='text'][@name='vatId']"));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(VATLabel));
			action.moveToElement(VATLabel).click().perform();
			VATInput.isEnabled();
			VATInput.sendKeys("DE211203" + randomInt);
		} catch (Exception e) {
			VATInput.isEnabled();
			VATInput.sendKeys("DE120343" + randomInt);
			e.printStackTrace();
		}
		System.out.println("VAT is added");

		WebElement agree1 = driver.findElement(By.xpath("(//div[@class='filter-checkbox'])[1]"));
		WebElement agree2 = driver.findElement(By.xpath("(//div[@class='filter-checkbox'])[2]"));
		if (agree1.isSelected()) {
			System.out.println("Agreement already accepted ");
		} else {
			agree1.click();
			System.out.println("Accepted agreement ");
		}
		if (agree2.isSelected()) {
			System.out.println("Agreement already accepted ");
		} else {
			agree2.click();
			System.out.println("Accepted agreement ");
		}
		WebElement createAcc = driver.findElement(By.xpath("//button[@type='submit'][text()='Create your Saloodo! account']"));
		wait.until(ExpectedConditions.visibilityOf(createAcc));
		wait.until(ExpectedConditions.elementToBeClickable(createAcc));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//button[@type='submit'][text()='Create your Saloodo! account']")));
			action.moveToElement(createAcc).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(createAcc));
			driver.findElement(By.xpath("//button[@type='submit'][text()='Create your Saloodo! account']")).click();
		} catch (Exception e) {
			System.out.println("Create button is not enabled");
		}
		System.out.println("Account is created");
		driver.navigate().refresh();
		driver.quit();
	}
}
