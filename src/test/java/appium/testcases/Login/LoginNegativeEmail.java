package appium.testcases.Login;

import appium.pages.HomePage;
import appium.pages.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import appium.pages.LoginPage;

public class LoginNegativeEmail
{
    protected static AndroidDriver driver;

    @BeforeClass
    public static void SetUp()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.synrgy7team4.bankingapps.debug");
        capabilities.setCapability("appActivity", "com.synrgy7team4.bankingapps.MainActivity");

        driver = new AndroidDriver(capabilities);
    }

    @Test
    public static void LoginNegativeEmailTest()
    {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        landingPage.ValidatePage();
        landingPage.ClickAlreadyHaveAccount();

        loginPage.ValidatePage();
        loginPage.InputEmail("dxa072727@gmail.com");
        loginPage.InputPassword("password123");
        loginPage.ClickLoginButton();

        Assert.assertEquals(loginPage.ErrorEmailMessageText(),"User not found");
    }

    @AfterClass
    public static void TearDown()
    {
        driver.terminateApp("com.synrgy7team4.bankingapps.debug");
    }
}