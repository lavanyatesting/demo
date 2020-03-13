package samplePage;

import static samplePage.envVariables.driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import cucumber.api.cli.*;


public class envVariables
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	public static Actions action;	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/DriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Before class");
		driver.get("http://demo.saloodo.com");
		System.out.println("Before class passed");
		action = new Actions(driver);

	}
	
}
