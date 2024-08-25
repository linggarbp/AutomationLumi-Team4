package appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class LandingPage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By alreadyHaveAccount = xpath("//android.widget.Button[@content-desc=\"Sudah Punya Rekening\"]");
    By dontHaveAccount = xpath("//android.widget.Button[@content-desc=\"Belum Punya Rekening\"]");

    public LandingPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//android.widget.ImageView[@content-desc=\"logo dari lumi\"]")));
    }

    public void ClickAlreadyHaveAccount()
    {
        driver.findElement(alreadyHaveAccount).click();
    }

    public void ClickDontHaveAccount()
    {
        driver.findElement(dontHaveAccount).click();
    }

}
