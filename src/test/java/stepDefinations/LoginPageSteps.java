package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.driverFactory.DriverFactory;
import org.example.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageSteps {

    private static String pageTitle;
    public static long noOfSeconds =5;
    private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());
    @Given("The user is in SwagLabs Login Page")
    public void the_User_Is_In_SwagLabs_LoginPage() {
        DriverFactory.getWebDriver().get("https://www.saucedemo.com/v1/");
    }

    @When("^User logs into application with the (.+) and (.+)$")
    public void user_logs_into_application_with_the_standard_user_and_secret_sauce(String useName, String password) {
        loginPage.enterUserName(useName);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        WebDriverWait webDriverWait = new WebDriverWait(DriverFactory.getWebDriver(),Duration.ofSeconds(noOfSeconds));
    }
    @Then("Verify user is thrown an error message saying {string}")
    public void verify_user_is_thrown_an_error_message_saying(String expectedErrorMessage) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage));
    }

    @When("The user gets the title of the page")
    public void theUserGetsTheTitleOfThePage() {
        pageTitle = loginPage.getLoginPageTitle();
        System.out.println("Login Page Title: "+pageTitle);
    }

    @Then("The title of the page should be {string}.")
    public void theTitleOfThePageShouldBe(String expectedPageTitle) {
        Assert.assertTrue(pageTitle.contains(expectedPageTitle));
    }

    @And("The Login Page Logo is displayed")
    public void theLoginPageLogoIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPageLogoAvailable());
    }
}
