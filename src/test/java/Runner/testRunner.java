package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
features = "/demo/src/test/resources/Features/login.feature",
glue= {"StepDefinitions"},
plugin= {"pretty", "html:target/cucumber-reports", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml"},
monochrome = true,
dryRun = true

)

public class testRunner {

}