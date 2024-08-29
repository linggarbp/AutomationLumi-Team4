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
import selenium.pages.TransferPage;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class TransferNegativeNumberAccount
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
        loginPage.InputEmail("dxa0727@gmail.com");
        loginPage.InputPassword("password123");
        loginPage.ClickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/header/div[1]/a/div/img")));
        Assert.assertEquals(homePage.GetCurrentURL(),"https://lumibank.netlify.app/dashboard");
        homePage.LumiLogoIsDisplayed();
        homePage.ClickTransferButton();
    }

    @Test
    public void TranferNegativeNumberAccountTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TransferPage transferPage = new TransferPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/main/h1")));
        Assert.assertEquals(transferPage.GetCurrentURL(),"https://lumibank.netlify.app/transfer");
        transferPage.TransferTextIsDisplayed();
        transferPage.NextButtonIsDisplayed();
        transferPage.InputDestinationAccount("74349072761");
        transferPage.ClickSelectBankBCA();
        transferPage.InputNominal("1000");
        transferPage.InputDesc("Transfer 1000");
        transferPage.ClickNextButton();
        Assert.assertEquals(transferPage.GetCurrentURL(),"https://lumibank.netlify.app/transfer");
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/div[2]/div/div")));
        transferPage.ErrorMessageIsDisplayed();
        Assert.assertEquals(transferPage.ErrorGetText(),"Nomor Rekening Tujuan Tidak Valid");
    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}
