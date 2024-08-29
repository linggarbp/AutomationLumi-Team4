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
    By selectDate = xpath("");
    By inputDate = xpath("");
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

    public void InputDestinationAccount(String number)
    {
        driver.findElement(destinationAccountField).isDisplayed();
        driver.findElement(destinationAccountField).sendKeys(number);
    }

    public void ClickSelectBankBCA()
    {
        driver.findElement(selectBankButton).isDisplayed();
        driver.findElement(selectBankButton).click();
        driver.findElement(selectBankBCA).click();
    }

    public void InputDesc(String text)
    {
        driver.findElement(descField).isDisplayed();
        driver.findElement(descField).sendKeys(text);
    }

    public void InputNominal(String nominal)
    {
        driver.findElement(amountField).isDisplayed();
        driver.findElement(amountField).sendKeys(nominal);
    }

    public void NextButtonIsDisplayed()
    {
        driver.findElement(nextButton).isDisplayed();
    }

    public void ClickSelectDate()
    {
        driver.findElement(selectDate).isDisplayed();
        driver.findElement(selectDate).click();
        driver.findElement(inputDate).click();
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
