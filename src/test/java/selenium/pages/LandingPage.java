package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class LandingPage
{
    WebDriver driver;

    By lumiText = xpath("//*[@id=\"root\"]/header/a/img");
    By joinButton = xpath("//*[@id=\"root\"]/main/div[2]/div/a[2]");

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void LumiTextIsDisplayed()
    {
        driver.findElement(lumiText).isDisplayed();
    }

    public void ClickJoinButton()
    {
        driver.findElement(joinButton).isDisplayed();
        driver.findElement(joinButton).click();
    }

}
