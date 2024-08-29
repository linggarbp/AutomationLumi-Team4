package appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    By startDateInputFalse = xpath("//android.widget.TextView[@content-desc=\"Friday, August 30\"]");
    By okayStartDateButton = xpath("//android.widget.Button[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/confirm_button\"]");
    By toDateInput = xpath("(//android.widget.ImageButton[@content-desc=\"Pilih tanggal\"])[2]");
    By okayEndDateButton = xpath("//android.widget.Button[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/confirm_button\"]");
    By getTextDate = xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Daftar riwayat mutasi\"]");

    public MutationPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(mutationText));
    }

    public boolean GetTextDate()
    {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(getTextDate));
        }catch (Exception e) {
            return false;
        }
        return true;
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

    public void InputFromDateTrue ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateInput));
        driver.findElement(fromDateInput).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(startDateInput));
        driver.findElement(startDateInput).click();
        driver.findElement(okayStartDateButton).click();
    }

    public void InputFromDateFalse ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateInput));
        driver.findElement(fromDateInput).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(startDateInputFalse));
        driver.findElement(startDateInputFalse).click();
        driver.findElement(okayStartDateButton).click();
    }

    public void InputToDate ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toDateInput));
        driver.findElement(toDateInput).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okayEndDateButton));
//        driver.findElement(endDateInput).click();
        driver.findElement(okayEndDateButton).click();
    }

    public String GetIncomeText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textTransactionIn));
        WebElement element = driver.findElement(textTransactionIn);

        String elementText = element.getText();
        String data = elementText.substring(0, 1);
        return data;
    }

    public String GetOutcomeText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textTransactionOut));
        WebElement element = driver.findElement(textTransactionOut);

        String elementText = element.getText();
        String data = elementText.substring(0, 1);
        return data;
    }
}
