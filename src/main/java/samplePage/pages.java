package samplePage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pages { 
	
	public static WebDriver driver;

	@FindBy(xpath="//button[text()='Register']") private WebElement registerBtn;
	
	loginPage LoginPage = new loginPage();	
	registerPage RegisterPage = new registerPage();
	
}