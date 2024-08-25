package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.By.*;

public class HomePage
{
    WebDriver driver;
    WebDriverWait wait;

    By lumiLogo = xpath("//*[@id=\"root\"]/header/div[1]/a/div/img");
    By hideViewBalance = xpath("//*[@id=\"root\"]/main/div/div[1]/div/div/div/div[2]/button/svg/path[2]");
    By balanceValue = xpath("//*[@id=\"root\"]/main/div/div[1]/div/div/div/div[2]/p");
    By transferButton = xpath("//*[@id=\"root\"]/header/div[1]/nav/ul/li[2]/a");
    By mutationButton = xpath("//*[@id=\"root\"]/header/div[1]/nav/ul/li[3]/a");
    By qrisButton = xpath("//*[@id=\"root\"]/header/div[1]/nav/ul/li[4]/a");
    By profileButton = xpath("//*[@id=\"root\"]/header/div[1]/nav/ul/li[5]/a/div");
    By notifButton = xpath("//*[@id=\"root\"]/header/div[1]/nav/ul/li[6]/div/button");
    By logoutButton = xpath("//*[@id=\"root\"]/header/div[1]/nav/ul/li[7]/button");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void LumiLogoIsDisplayed()
    {
        driver.findElement(lumiLogo).isDisplayed();
    }

    public void HideViewBalanceIsDisplayed()
    {
        driver.findElement(hideViewBalance).isDisplayed();
    }

    public void ClickViewBalance()
    {
        driver.findElement(hideViewBalance).click();
    }

    public void BalanceValueIsDisplayed()
    {
        driver.findElement(balanceValue).isDisplayed();
    }

    public void TransferButtonIsDisplayed()
    {
        driver.findElement(transferButton).isDisplayed();
    }

    public void ClickTransferButton()
    {
        driver.findElement(transferButton).click();
    }

    public void MutationButtonIsDisplayed()
    {
        driver.findElement(mutationButton).isDisplayed();
    }

    public void ClickMutationButton()
    {
        driver.findElement(mutationButton).click();
    }

    public void QRISButtonIsDisplayed()
    {
        driver.findElement(qrisButton).isDisplayed();
    }

    public void ClickQRISButton()
    {
        driver.findElement(qrisButton).click();
    }

    public void ProfileButtonIsDisplayed()
    {
        driver.findElement(profileButton).isDisplayed();
    }

    public void ClickProfileButton()
    {
        driver.findElement(profileButton).click();
    }

    public void NotifButtonIsDisplayed()
    {
        driver.findElement(notifButton).isDisplayed();
    }

    public void ClickNotifButton()
    {
        driver.findElement(notifButton).click();
    }

    public void LogoutButtonIsDisplayed()
    {
        driver.findElement(logoutButton).isDisplayed();
    }

    public void ClickLogoutButton()
    {
        driver.findElement(logoutButton).click();
    }

}
