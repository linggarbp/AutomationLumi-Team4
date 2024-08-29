package selenium.testcases.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class LoginPositive
{
    static WebDriver driver;

    @BeforeClass
    public static void SetUp()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://lumibank.netlify.app/login");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        LandingPage landingPage = new LandingPage(driver);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/header/a/img")));
//        Assert.assertEquals(landingPage.GetCurrentURL(), "https://lumibank.netlify.app/");
//        landingPage.LumiTextIsDisplayed();
//        landingPage.ClickJoinButton();
    }

    @Test
    public void LoginTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"email\"]")));
        Assert.assertEquals(loginPage.GetCurrentURL(),"https://lumibank.netlify.app/login");
        loginPage.InputEmail("dxa0727@gmail.com");
        loginPage.InputPassword("password123");
        loginPage.ClickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/header/div[1]/a/div/img")));
        Assert.assertEquals(homePage.GetCurrentURL(),"https://lumibank.netlify.app/dashboard");
        homePage.LumiLogoIsDisplayed();
    }

    @AfterClass
    public static void TearDown()
    {
        driver.quit();
    }
}
