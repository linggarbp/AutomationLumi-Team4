package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class QRISPage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By qrisButton = xpath("//android.widget.FrameLayout[@content-desc=\"QRIS\"]");
    By qrisText = xpath("//android.widget.TextView[@content-desc=\"QR\"]");

    public QRISPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(qrisButton));
    }

    public void ClickQRISButton()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(qrisButton));
        driver.findElement(qrisButton).click();
    }

    public String GetQRISText()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(qrisText));
        return driver.findElement(qrisText).getText();
    }
}
