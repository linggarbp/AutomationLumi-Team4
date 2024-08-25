package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class PinPage
{
    WebDriver driver;

    By pinField = xpath("//*[@id=\"pin\"]");
    By transferButton = xpath("//*[@id=\"btnTransfer\"]");
    By errorMessage = xpath("//*[@id=\"root\"]/div[2]/div/div/div/p");
    By successMessage = xpath("//*[@id=\"root\"]/div[2]/div/div/div/h1");
    By okayButton = xpath("//*[@id=\"btnOke\"]");

    public PinPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void InputPinFieldDisplayed(String pin)
    {
        driver.findElement(pinField).isDisplayed();
        driver.findElement(pinField).sendKeys(pin);
    }

    public void ClickTransferButton()
    {
        driver.findElement(transferButton).click();
    }

    public void ErrorMessageIsDisplayed()
    {
        driver.findElement(errorMessage).isDisplayed();
    }

    public String ErrorGetText()
    {
        return driver.findElement(errorMessage).getText();
    }

    public void ClickOkeyButtonDisplayed()
    {
        driver.findElement(okayButton).isDisplayed();
        driver.findElement(okayButton).click();
    }

    public void SuccessMessageIsDisplayed()
    {
        driver.findElement(successMessage).isDisplayed();
    }

    public String SuccessGetText()
    {
        return driver.findElement(successMessage).getText();
    }
}
