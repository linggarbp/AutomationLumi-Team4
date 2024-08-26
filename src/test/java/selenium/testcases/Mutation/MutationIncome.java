package selenium.testcases.Mutation;

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
import selenium.pages.MutationPage;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class MutationIncome
{
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://lumibank.netlify.app/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"email\"]")));
        Assert.assertEquals(loginPage.GetCurrentURL(), "https://lumibank.netlify.app/login");
        loginPage.EmailFieldIsDisplayed();
        loginPage.PasswordFieldIsDisplayed();
        loginPage.LoginButtonIsDisplayed();
        loginPage.InputEmail("dxa0727@gmail.com");
        loginPage.InputPassword("password123");
        loginPage.ClickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/header/div[1]/a/div/img")));
        Assert.assertEquals(homePage.GetCurrentURL(), "https://lumibank.netlify.app/dashboard");
        homePage.LumiLogoIsDisplayed();
        homePage.ClickMutationButton();
    }

    @Test
    public void MutationAllTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        MutationPage mutationPage = new MutationPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/main/h1")));
        Assert.assertEquals(mutationPage.GetCurrentURL(), "https://lumibank.netlify.app/mutasi");
        mutationPage.MutationTextIsDisplayed();
        mutationPage.ClickDropdownTransaction();
        mutationPage.ClickIncomeTransaction();
        mutationPage.ClickFindMutationButton();
        Assert.assertEquals(mutationPage.GetFirstMutationData(), "+");
        Assert.assertEquals(mutationPage.GetSecondMutationData(), "+");
    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}
