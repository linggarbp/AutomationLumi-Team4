package appium.testcases.Login;

import appium.pages.LandingPage;
import appium.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginNegativePassword
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
    public static void LoginNegativePasswordTest()
    {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        landingPage.ValidatePage();
        landingPage.ClickAlreadyHaveAccount();

        loginPage.ValidatePage();
        loginPage.InputEmail("dxa0727@gmail.com");
        loginPage.InputPassword("password12345");
        loginPage.ClickLoginButton();

        Assert.assertEquals(loginPage.ErrorPasswordMessageText(),"Invalid password");
    }

    @AfterClass
    public static void TearDown()
    {
        driver.terminateApp("com.synrgy7team4.bankingapps.debug");
    }
}