package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class MutationPage
{
    WebDriver driver;

    By mutationText = xpath("//*[@id=\"root\"]/main/h1");
    By typeofTransactionButton = xpath("//*[@id=\"jenisTransaksi\"]");
    By selectTransactionIn = xpath("//*[@id=\"jenisTransaksi\"]/option[2]");
    By selectTransactionOut = xpath("//*[@id=\"jenisTransaksi\"]/option[3]");
    By fromDateInput = xpath("//*[@id=\"dariTanggal\"]");
    By toDateInput = xpath("//*[@id=\"sampaiTanggal\"]");
    By findMutationButton = xpath("//*[@id=\"btnMutasi\"]");
    By errorMessage = xpath("");

    public MutationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void MutationTextIsDisplayed()
    {
        driver.findElement(mutationText).isDisplayed();
    }

    public void DropdownTransactionIsDisplayed()
    {
        driver.findElement(typeofTransactionButton).isDisplayed();
    }

    public void ClickDropdownTransaction()
    {
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

    public void FromDateInputIsDisplayed()
    {
        driver.findElement(fromDateInput).isDisplayed();
    }

    public void InputFromDate (String fromDate)
    {
        driver.findElement(fromDateInput).sendKeys(fromDate);
    }

    public void ToDateInputIsDisplayed()
    {
        driver.findElement(toDateInput).isDisplayed();
    }

    public void InputToDate (String toDate)
    {
        driver.findElement(toDateInput).sendKeys(toDate);
    }

    public void FindMutationButtonIsDisplayed()
    {
        driver.findElement(findMutationButton).isDisplayed();
    }

    public void ClickFindMutationButton()
    {
        driver.findElement(findMutationButton).click();
    }

    public void ErrorMessageIsDisplayed()
    {
        driver.findElement(errorMessage).isDisplayed();
    }

    public String ErrorGetText()
    {
        return driver.findElement(errorMessage).getText();
    }
}
