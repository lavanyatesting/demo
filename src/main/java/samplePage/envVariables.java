package samplePage;

import static samplePage.envVariables.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.Before;

public class envVariables
{
	public static WebDriver driver= new ChromeDriver();
	public static WebDriverWait wait;
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	public static Actions action = new Actions(driver);
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		System.out.println("Before class");
		driver.get("http://demo.saloodo.com");
	}
	
}
