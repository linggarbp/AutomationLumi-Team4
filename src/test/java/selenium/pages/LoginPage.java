package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.By.*;

public class LoginPage
{
    WebDriver driver;

    By emailField = xpath("//*[@id=\"email\"]");
    By passwordField = xpath("//*[@id=\"password\"]");
    By loginButton = xpath("//*[@id=\"btnLogin\"]");
    By errorMessage = xpath("//*[@id=\"root\"]/div[2]/div/div");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void InputEmail(String email)
    {
        driver.findElement(emailField).isDisplayed();
        driver.findElement(emailField).sendKeys(email);
    }

    public void InputPassword(String password)
    {
        driver.findElement(passwordField).isDisplayed();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void ClickLoginButton()
    {
        driver.findElement(loginButton).isDisplayed();
        driver.findElement(loginButton).click();
    }

    public String GetErrorMessage()
    {
        driver.findElement(errorMessage).isDisplayed();
        return driver.findElement(errorMessage).getText();
    }
}