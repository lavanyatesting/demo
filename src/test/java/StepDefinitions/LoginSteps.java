/**
 * @author mercy
 */
package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import samplePage.loginPage;
import samplePage.registerPage;

public class LoginSteps {
	
@Given("^user is  on homepage$")
public void user_is_on_homepage() throws Throwable {
//	registerPage.registerCompany();	
}

@When("^user navigates to Login Page$")
public void user_navigates_to_Login_Page() throws Throwable {
    loginPage.loginCheck();
}

@When("^user enters username and Password$")
public void user_enters_username_and_Password() throws Throwable {
}

@Then("^success message is displayed$")
public void success_message_is_displayed() throws Throwable {
}
}