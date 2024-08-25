package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class MutationPage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By mutationText = xpath("");
    By typeofTransactionButton = xpath("");
    By selectTransactionIn = xpath("");
    By selectTransactionOut = xpath("");
    By fromDateInput = xpath("");
    By toDateInput = xpath("");
    By findMutationButton = xpath("");
    By errorMessage = xpath("");

    public MutationPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("")));
    }

    public void MutationTextDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mutationText));
    }

    public void ClickDropdownTransaction()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(typeofTransactionButton));
        driver.findElement(typeofTransactionButton).click();
    }

    public void ClickIncomeTransaction()
    {
        driver.findElement(selectTransactionIn).click();
    }

    public void ClickOutcomeTransaction()
    {
        driver.findElement(selectTransactionOut).click();
    }

    public void InputFromDate (String fromDate)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateInput));
        driver.findElement(fromDateInput).sendKeys(fromDate);
    }

    public void InputToDate (String toDate)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toDateInput));
        driver.findElement(toDateInput).sendKeys(toDate);
    }

    public void ClickFindMutationButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findMutationButton));
        driver.findElement(findMutationButton).click();
    }

    public String ErrorGetMessageText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }
}
