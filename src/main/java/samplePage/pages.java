package samplePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static samplePage.envVariables.driver;

public class pages { 
	
	//public static WebDriver driver;

	@FindBy(xpath="//button[text()='Register']") private WebElement registerBtn;
	
	loginPage LoginPage = new loginPage();	
	registerPage RegisterPage = new registerPage();
	
}