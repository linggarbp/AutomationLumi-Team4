package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class MutationPage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By mutationText = xpath("//android.widget.TextView[@content-desc=\"Transaksi\"]");
    By typeofTransactionButton = xpath("//android.widget.Spinner[@content-desc=\"Jenis Transaksi\"]");
    By selectTransactionAll = xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Semua\"]");
    By selectTransactionIn = xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Uang Masuk\"]");
    By textTransactionIn = xpath("(//android.widget.TextView[@content-desc=\"Rupiah\"])[1]");
    By selectTransactionOut = xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Uang Keluar\"]");
    By textTransactionOut = xpath("(//android.widget.TextView[@content-desc=\"Rupiah\"])[2]");
    By fromDateInput = xpath("(//android.widget.ImageButton[@content-desc=\"Pilih tanggal\"])[1]");
    By startDateInput = xpath("//android.widget.TextView[@content-desc=\"Tuesday, August 20\"]");
    By okayStartDateButton = xpath("//android.widget.Button[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/confirm_button\"]");
    By toDateInput = xpath("(//android.widget.ImageButton[@content-desc=\"Pilih tanggal\"])[2]");
    By endDateInput = xpath("//android.widget.TextView[@content-desc=\"Today Sunday, August 25\"]");
    By okayEndDateButton = xpath("//android.widget.Button[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/confirm_button\"]");

    public MutationPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(mutationText));
    }

    public void ClickDropdownTransaction()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(typeofTransactionButton));
        driver.findElement(typeofTransactionButton).click();
    }

    public void ClickAllTransaction()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectTransactionAll));
        driver.findElement(selectTransactionAll).click();
    }

    public void ClickIncomeTransaction()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectTransactionIn));
        driver.findElement(selectTransactionIn).click();
    }

    public void ClickOutcomeTransaction()
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(selectTransactionOut));
        driver.findElement(selectTransactionOut).click();
    }

    public void InputFromDate ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateInput));
        driver.findElement(fromDateInput).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(startDateInput));
        driver.findElement(startDateInput).click();
        driver.findElement(okayStartDateButton).click();
    }

    public void InputToDate ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toDateInput));
        driver.findElement(toDateInput).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(endDateInput));
        driver.findElement(endDateInput).click();
        driver.findElement(okayEndDateButton).click();
    }

    public String GetIncomeText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textTransactionIn));
        return driver.findElement(textTransactionIn).getText();
    }

    public String GetOutcomeText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textTransactionOut));
        return driver.findElement(textTransactionOut).getText();
    }
}
