package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "/demo/src/test/resources/Features/login.feature",
glue= {"StepDefinitions"},
monochrome = true,
dryRun = true

)

public class testRunner {

}