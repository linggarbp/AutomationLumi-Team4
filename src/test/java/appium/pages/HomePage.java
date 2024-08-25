package appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class HomePage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By welcomeText = xpath("//android.widget.TextView[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/tv_good_morning\"]");

    public HomePage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//android.view.ViewGroup[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/acc_layout\"]")));
    }

    public String GetWelcomeText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        return driver.findElement(welcomeText).getText();
    }
}