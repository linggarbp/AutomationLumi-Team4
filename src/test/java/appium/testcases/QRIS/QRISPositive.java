package appium.testcases.QRIS;

import appium.pages.HomePage;
import appium.pages.LandingPage;
import appium.pages.LoginPage;
import appium.pages.QRISPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QRISPositive
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

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        landingPage.ValidatePage();
        landingPage.ClickAlreadyHaveAccount();

        loginPage.ValidatePage();
        loginPage.InputEmail("dxa0727@gmail.com");
        loginPage.InputPassword("password123");
        loginPage.ClickLoginButton();

        homePage.ValidatePage();
        Assert.assertEquals(homePage.GetWelcomeText(),"Selamat Datang,");
    }

    @Test
    public static void QRISPositiveTest()
    {
        QRISPage qrisPage = new QRISPage(driver);

        qrisPage.ValidatePage();
        qrisPage.ClickQRISButton();
        Assert.assertEquals(qrisPage.GetQRISText(), "QR");
    }

    @AfterClass
    public static void TearDown()
    {
        driver.terminateApp("com.synrgy7team4.bankingapps.debug");
    }
}
