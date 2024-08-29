package selenium.testcases.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.pages.LandingPage;
import selenium.pages.LoginPage;

import java.time.Duration;

import static org.openqa.selenium.By.*;

public class LoginNegativePassword
{
    WebDriver driver;

    @BeforeClass
    public void SetUp()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://lumibank.netlify.app/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LandingPage landingPage = new LandingPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/header/a/img")));
        Assert.assertEquals(landingPage.GetCurrentURL(), "https://lumibank.netlify.app/");
        landingPage.LumiTextIsDisplayed();
        landingPage.ClickJoinButton();
    }

    @Test
    public void LoginNegativePasswordTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"email\"]")));
        Assert.assertEquals(loginPage.GetCurrentURL(),"https://lumibank.netlify.app/login");
        loginPage.InputEmail("dxa072727@gmail.com");
        loginPage.InputPassword("password12345");
        loginPage.ClickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/div[2]/div/div")));
        Assert.assertEquals(loginPage.GetErrorMessage(),"Email atau Password Salah");
    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}
