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

    public void EmailFieldIsDisplayed()
    {
        driver.findElement(emailField).isDisplayed();
    }

    public void PasswordFieldIsDisplayed()
    {
        driver.findElement(passwordField).isDisplayed();
    }

    public void LoginButtonIsDisplayed()
    {
        driver.findElement(loginButton).isDisplayed();
    }

    public void InputEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }

    public void InputPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void ClickLoginButton()
    {
        driver.findElement(loginButton).click();
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