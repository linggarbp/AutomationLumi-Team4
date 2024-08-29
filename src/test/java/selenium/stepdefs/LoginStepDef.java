package selenium.stepdefs;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class LoginStepDef
{
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("User is on login page")
    public void UserIsOnLoginPage()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://lumibank.netlify.app/login");

//        Assert.assertEquals(loginPage.GetCurrentURL(),"https://lumibank.netlify.app/login");
    }

    @And("User input email with {string}")
    public void UserInputEmail(String email)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"email\"]")));
        loginPage.InputEmail(email);
    }

    @And("User input password with {string}")
    public void UserInputPassword(String password)
    {
        loginPage.InputPassword(password);
    }

    @When("User click on login button")
    public void UserClickOnLoginButton()
    {
        loginPage.ClickLoginButton();
    }

    @Then("User is on home page")
    public void UserIsOnHomePage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/header/div[1]/a/div/img")));
        Assert.assertEquals(homePage.GetCurrentURL(),"https://lumibank.netlify.app/dashboard");
        homePage.LumiLogoIsDisplayed();
    }

    @Then("Error login message is showing up")
    public void ErrorMessage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/div[2]/div/div")));
        Assert.assertEquals(loginPage.GetErrorMessage(),"Email atau Password Salah");
    }

}
