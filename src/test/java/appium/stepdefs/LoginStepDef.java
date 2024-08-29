package appium.stepdefs;

import appium.pages.HomePage;
import appium.pages.LandingPage;
import appium.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LoginStepDef
{
    protected static AndroidDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("User is on login page")
    public void UserIsOnLoginPage()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.synrgy7team4.bankingapps.debug");
        capabilities.setCapability("appActivity", "com.synrgy7team4.bankingapps.MainActivity");

        driver = new AndroidDriver(capabilities);

        LandingPage landingPage = new LandingPage(driver);
        landingPage.ValidatePage();
        landingPage.ClickAlreadyHaveAccount();
    }

    @And("User input email with {string}")
    public void UserInputEmailWith(String username)
    {
        loginPage.InputEmail(username);
    }

    @And("User input password with {string}")
    public void UserInputPasswordWith(String password)
    {
        loginPage.InputPassword(password);
    }

    @When("User click on login button")
    public void UserClickLoginButton()
    {
        loginPage.ClickLoginButton();
    }

    @Then("User is on home page")
    public void UserIsOnHomePage()
    {
        homePage.ValidatePage();
    }

    @Then("Error message is showing up")
    public void ErrorMessageIsShowingUp()
    {
        loginPage.ErrorEmailMessageText();
        loginPage.ErrorPasswordMessageText();
    }
}