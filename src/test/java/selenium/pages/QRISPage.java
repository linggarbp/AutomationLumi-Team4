package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class QRISPage
{
    WebDriver driver;

    By getHeadertext = xpath("//*[@id=\"root\"]/main/h2");
    By getQRIStext = xpath("//*[@id=\"root\"]/main/div/div[2]/img");
    By getQRISImage = xpath("//*[@id=\"root\"]/main/div/div[3]/img");

    public QRISPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void GetAllQRISElement()
    {
        driver.findElement(getHeadertext).isDisplayed();
        driver.findElement(getQRIStext).isDisplayed();
    }

}
