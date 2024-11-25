package steps;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pom.LoginPage;

public class LoginLogOutSteps {

    private BaseTest baseTest = new BaseTest();
    private LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        //user is already on login page in @Before hook
    }

    @When("User enters correct credentials {string} and {string}")
    public void user_enters_correct_credentials_username_and_password(String username, String password) throws Exception {
        loginPage.inputUserName(username)
                .inputPassword(password)
                .clickOnLoginBtnWithCorrectData();
    }

    @Then("User should be redirected to the inventory page")
    public void user_should_be_redirected_to_the_inventory_page() {
        Assert.assertTrue(loginPage.isURLDirected(baseTest.inventoryUrl));
    }

    @When("User enters locked out user credentials {string} and {string}")
    public void user_enters_locked_out_user_credentials(String username, String password) throws Exception {
        loginPage.inputUserName(username)
                .inputPassword(password)
                .clickOnLoginBtnWithIncorrectData();
    }

    @Then("User should see the error message {string}")
    public void user_should_see_the_error_message(String errorMessage) {
        Assert.assertTrue(loginPage.isErrorStatus(errorMessage));
    }
}