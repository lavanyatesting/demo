package samplePage;

import static samplePage.envVariables.action;
import static samplePage.envVariables.driver;
import static samplePage.envVariables.jse;
import static samplePage.envVariables.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends pages {

	
	public static void openUrl() throws Throwable {
		driver.manage().window().maximize();
		System.out.println("Demo site is opened");
	}

	public static void loginPage() throws Throwable {
		WebElement loginBtn = driver.findElement(By.xpath("//a[text()='Login']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		System.out.println("Login btn is visible");
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		System.out.println("Login Button is clicked");
	}

	public static void emailEntry() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		WebElement emailLabel = driver.findElement(By.xpath("//label[contains(text(),'Email')]"));
		WebElement emailInput = driver.findElement(By.xpath("//input[@type='text'][@name='_email']"));
		if (emailLabel.isDisplayed()) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(emailLabel));
			action.moveToElement(emailLabel).click().perform();
			emailInput.sendKeys("lavanya.poorni@gmail.com");
			System.out.println("Email is entered");
		} else {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(emailInput));
			emailInput.sendKeys("lavanya.poorni@gmail.com");
			System.out.println("Email is entered");
		}

	}

	/* Entering password for login */
	public static void passwordEntry() throws Throwable {
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
	}

	public static void loginPageCheckArrival() throws Throwable {
		WebElement login = driver.findElement(By.xpath("//button[@type='submit'][text()='Log In ']"));
		wait.until(ExpectedConditions.visibilityOf(login));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		System.out.println("Login is successful");
	}

	public static void notificationModal() throws Throwable {
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
		System.out.println("Switched to modal ");
		driver.switchTo().activeElement();
		WebElement modalWindow = driver.findElement(By.xpath("//div[@class='modal--content']"));
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOf(modalWindow));
		WebElement skipIt = modalWindow.findElement(By.xpath("//a[text()='Skip it']"));
		action.moveToElement(skipIt);
		action.click(skipIt).perform();
		System.out.println("Pop-up handled");
	}

	public static void myProfile() throws Throwable {
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

	public static void compEdit() throws Throwable {
		driver.switchTo().defaultContent();
		WebElement companyDetailsEdit = driver.findElement(By.xpath(
				"(//body//div[@id='profile']//div[@class='container main-wrapper']//div[@class='profile']/div[2]//button[@class='editBtn'][text()='Edit']"));
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(companyDetailsEdit));
		wait.until(ExpectedConditions.elementToBeClickable(companyDetailsEdit));
		action.moveToElement(companyDetailsEdit);
		companyDetailsEdit.click();
		System.out.println("Company edit button is clicked");
	}

	public static void compAddressUpdate() throws Throwable {
		// Entering the street
		WebElement streetLabel = driver.findElement(By.xpath("//label[contains(text(),'Street')]"));
		WebElement streetInput = driver.findElement(By.xpath("//input[@type='text'][@name='street']"));
		if (streetLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(streetLabel));
			action.moveToElement(streetLabel);
			action.click(streetLabel).perform();
			streetInput.sendKeys("Hardley Cross street");
			System.out.println("Street is entered");
		} else {
			streetInput.isEnabled();
			streetInput.sendKeys("3rd Cross street");
			System.out.println("Street is entered");
		}

		// Entering the street no
		WebElement streetNoLabel = driver.findElement(By.xpath("//label[contains(text(),'No.')]"));
		WebElement streetNoInput = driver.findElement(By.xpath("//input[@type='text'][@name='streetNo']"));
		if (streetNoLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(streetNoLabel));
			action.moveToElement(streetNoLabel);
			action.click(streetNoLabel).perform();
			streetNoInput.sendKeys("3");
			System.out.println("Street No is entered");
		} else {
			streetNoInput.isEnabled();
			streetNoInput.sendKeys("3");
			System.out.println("Street No is entered");
		}

		// Entering the Postalcode
		WebElement postalCodeLabel = driver.findElement(By.xpath("//label[contains(text(),'Postalcode')]"));
		WebElement postalCodeInput = driver.findElement(By.xpath("//input[@type='text'][@name='postalCode']"));
		if (postalCodeLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(postalCodeLabel));
			action.moveToElement(postalCodeLabel);
			action.click(postalCodeLabel).perform();
			postalCodeInput.sendKeys("20095");
			System.out.println("Postal Code is entered");
		} else {
			postalCodeInput.isEnabled();
			postalCodeInput.sendKeys("20095");
			System.out.println("Postal Code is entered");
		}

		// Entering the City
		WebElement cityLabel = driver.findElement(By.xpath("//label[contains(text(),'City')]"));
		WebElement cityInput = driver.findElement(By.xpath("//input[@type='text'][@name='city']"));
		if (cityLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(cityLabel));
			action.moveToElement(cityLabel);
			action.click(cityLabel).perform();
			cityInput.sendKeys("20095");
			System.out.println("City is entered");
		} else {
			cityInput.isEnabled();
			cityInput.sendKeys("20095");
			System.out.println("City is entered");
		}

		// Entering the Description
		WebElement descLabel = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		WebElement descInput = driver.findElement(By.xpath("//input[@type='text'][@name='description']"));
		if (descLabel.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(descLabel));
			action.moveToElement(descLabel);
			action.click(descLabel).perform();
			descInput.sendKeys("20095");
			System.out.println("Descrption is entered");
		} else {
			descInput.isEnabled();
			descInput.sendKeys("20095");
			System.out.println("Descrption is entered");
		}

		// Entering the Industry Dropdown & selecting the value
		WebElement industryDrpdwn = driver.findElement(By .xpath("//div[@class='Select brand-select is-clearable Select--single']//span[@class='Select-arrow']"));
		wait.until(ExpectedConditions.visibilityOf(industryDrpdwn));
		wait.until(ExpectedConditions.elementToBeClickable(industryDrpdwn));
		action.moveToElement(industryDrpdwn);
		action.click(industryDrpdwn).perform();
		jse.executeScript("window.scrollBy(0,250)");
		Select industryValue = new Select(driver.findElement(By.xpath("//div[@class='Select brand-select is-clearable Select--single']//span[@class='Select-arrow']")));
		industryValue.selectByIndex(1);

		// Updating Company Details
		WebElement updateProfile = driver.findElement(By.xpath("//button[@type='submit'][text()='Update Profile ']"));
		wait.until(ExpectedConditions.visibilityOf(updateProfile));
		wait.until(ExpectedConditions.elementToBeClickable(updateProfile));
		updateProfile.click();
		System.out.println("Updating Profile is successful");

	}
	
	   
}