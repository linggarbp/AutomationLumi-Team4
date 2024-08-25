package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class LoginPage
{
    AndroidDriver driver;
    WebDriverWait wait;

    By emailField = xpath("//android.widget.EditText[@content-desc=\"input email\"]");
    By passwordField = xpath("//android.widget.EditText[@content-desc=\"Input password\"]");
    By loginButton = xpath("//android.widget.Button[@content-desc=\"Masuk\"]");
    By errorEmailMessage = xpath("//android.widget.Toast[@text=\"User not found\"]");
    By errorPasswordMessage = xpath("//android.widget.Toast[@text=\"Invalid password\"]");

    public LoginPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//android.widget.TextView[@content-desc=\"Masuk\"]")));
    }

    public void InputEmail(String email)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    public void InputPassword(String password)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void ClickLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public String ErrorEmailMessageText()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(errorEmailMessage));
        return driver.findElement(errorEmailMessage).getText();
    }

    public String ErrorPasswordMessageText()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(errorPasswordMessage));
        return driver.findElement(errorPasswordMessage).getText();
    }

}