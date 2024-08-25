package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class TransferPage
{
    WebDriver driver;

    By transferText = xpath("//*[@id=\"root\"]/main/h1");
    By destinationAccountField = xpath("//*[@id=\"accountTo\"]");
    By selectBankButton = xpath("//*[@id=\"bankTo\"]");
    By selectBankBCA = xpath("//*[@id=\"bankTo\"]/option[2]");
    By descField = xpath("//*[@id=\"description\"]");
    By amountField = xpath("//*[@id=\"amount\"]");
    By nextButton = xpath("//*[@id=\"btnLanjut\"]");
    By errorMessage = xpath("//*[@id=\"root\"]/div[2]/div/div");

    public TransferPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void TransferTextIsDisplayed()
    {
        driver.findElement(transferText).isDisplayed();
    }

    public void DestinationAccountIsDisplayed()
    {
        driver.findElement(destinationAccountField).isDisplayed();
    }

    public void InputDestinationAccount(String number)
    {
        driver.findElement(destinationAccountField).sendKeys(number);
    }

    public void SelectBankIsDisplayed()
    {
        driver.findElement(selectBankButton).isDisplayed();
    }

    public void ClickDropdownBank()
    {
        driver.findElement(selectBankButton).click();
    }

    public void ClickSelectBankBCA()
    {
        driver.findElement(selectBankBCA).click();
    }

    public void DescFieldIsDisplayed()
    {
        driver.findElement(descField).isDisplayed();
    }

    public void InputDesc(String text)
    {
        driver.findElement(descField).sendKeys(text);
    }

    public void AmountFieldIsDisplayed()
    {
        driver.findElement(amountField).isDisplayed();
    }

    public void InputNominal(String nominal)
    {
        driver.findElement(amountField).sendKeys(nominal);
    }

    public void NextButtonIsDisplayed()
    {
        driver.findElement(nextButton).isDisplayed();
    }

    public void ClickNextButton()
    {
        driver.findElement(nextButton).click();
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
