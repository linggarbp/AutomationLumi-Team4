package selenium.testcases.Transfer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;
import selenium.pages.PinPage;
import selenium.pages.TransferPage;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class TransferNegativePin
{
    WebDriver driver;

    @BeforeClass
    public void SetUp()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://lumibank.netlify.app/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"email\"]")));
        Assert.assertEquals(loginPage.GetCurrentURL(),"https://lumibank.netlify.app/login");
        loginPage.EmailFieldIsDisplayed();
        loginPage.PasswordFieldIsDisplayed();
        loginPage.LoginButtonIsDisplayed();
        loginPage.InputEmail("dxa0727@gmail.com");
        loginPage.InputPassword("password123");
        loginPage.ClickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/header/div[1]/a/div/img")));
        Assert.assertEquals(homePage.GetCurrentURL(),"https://lumibank.netlify.app/dashboard");
        homePage.LumiLogoIsDisplayed();
        homePage.ClickTransferButton();
    }

    @Test
    public void TranferNegativePinTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TransferPage transferPage = new TransferPage(driver);
        PinPage pinPage = new PinPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/main/h1")));
        Assert.assertEquals(transferPage.GetCurrentURL(),"https://lumibank.netlify.app/transfer");
        transferPage.TransferTextIsDisplayed();
        transferPage.DestinationAccountIsDisplayed();
        transferPage.SelectBankIsDisplayed();
        transferPage.DescFieldIsDisplayed();
        transferPage.AmountFieldIsDisplayed();
        transferPage.NextButtonIsDisplayed();
        transferPage.InputDestinationAccount("7434907276");
        transferPage.ClickDropdownBank();
        transferPage.ClickSelectBankBCA();
        transferPage.InputNominal("1000");
        transferPage.InputDesc("Transfer 1000");
        transferPage.ClickNextButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"pin\"]")));
        pinPage.InputPinFieldDisplayed("654321");
        pinPage.ClickTransferButton();
        Assert.assertEquals(pinPage.GetCurrentURL(),"https://lumibank.netlify.app/transfer/input-pin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/div[2]/div/div/div/p")));
        pinPage.ErrorMessageIsDisplayed();
        Assert.assertEquals(pinPage.ErrorGetText(),"Pin Salah");
    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}
