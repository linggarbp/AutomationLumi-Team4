package selenium.stepdefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.pages.MutationPage;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class MutationStepDef
{
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    HomePage homePage = new HomePage(driver);
    MutationPage mutationPage = new MutationPage(driver);

    @Given("User is on mutation page")
    public void UserIsOnMutationPage()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
//        homePage.ClickMutationButton();
        driver.get("https://lumibank.netlify.app/mutasi");

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//*[@id=\"root\"]/main/h1")));
        Assert.assertEquals(mutationPage.GetCurrentURL(), "https://lumibank.netlify.app/mutasi");
//        mutationPage.MutationTextIsDisplayed();
    }

    @And("User click on dropdown transaction list")
    public void UserClickDropdownList()
    {
        mutationPage.ClickDropdownTransaction();
    }

    @And("User click on all option")
    public void UserClickOnAllOption()
    {
        mutationPage.ClickAllTransaction();
    }

    @When("User click on find mutation button")
    public void UserClickOnFindMutationButton()
    {
        mutationPage.ClickFindMutationButton();
    }

    @Then("All transaction is showing up")
    public void AllTransaction()
    {

    }

    @And("User click on income option")
    public void UserClickOnIncomeOption()
    {
        mutationPage.ClickIncomeTransaction();
    }

    @Then("Income transaction is showing up")
    public void IncomeTransaction()
    {
        Assert.assertEquals(mutationPage.GetFirstMutationData(), "+");
        Assert.assertEquals(mutationPage.GetSecondMutationData(), "+");
    }

    @And("User click on outcome option")
    public void UserClickOnOutcomeOption()
    {
        mutationPage.ClickOutcomeTransaction();
    }

    @Then("Outcome transaction is showing up")
    public void OutcomeTransaction()
    {
        Assert.assertEquals(mutationPage.GetFirstMutationData(), "-");
        Assert.assertEquals(mutationPage.GetSecondMutationData(), "-");
    }

    @And("User click input startdate")
    public void UserClickInputStartDate()
    {
        mutationPage.InputFromTwentyThreeDate();
    }

    @And("User click input enddate true")
    public void UserClickInputEndDateTrue()
    {
        mutationPage.InputToTwentyFiveDate();
    }

    @And("User click input enddate false")
    public void UserClickInputEndDateFalse()
    {
        mutationPage.InputToTwentyDate();
    }

    @Then("All transaction between startdate and enddate is showing up")
    public void AllTransactionBetween()
    {
        mutationPage.SortingDate();
        Assert.assertTrue(Float.parseFloat(mutationPage.GetThirdDate()) > Float.parseFloat(mutationPage.GetFirstDate()));
    }

    @Then("Error mutation message is showing up")
    public void ErrorMessage()
    {
        Assert.assertEquals(mutationPage.ErrorGetText(), "Tanggal Awal lebih besar dari tanggal akhir");
    }
}
