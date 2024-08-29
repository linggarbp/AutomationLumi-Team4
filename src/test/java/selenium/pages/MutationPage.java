package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;

public class MutationPage
{
    WebDriver driver;

    By mutationText = xpath("//*[@id=\"root\"]/main/h1");
    By typeofTransactionButton = xpath("//*[@id=\"jenisTransaksi\"]");
    By selectTransactionAll = xpath("//*[@id=\"jenisTransaksi\"]/option[1]");
    By selectTransactionIn = xpath("//*[@id=\"jenisTransaksi\"]/option[2]");
    By selectTransactionOut = xpath("//*[@id=\"jenisTransaksi\"]/option[3]");
    By fromDateInput = xpath("//*[@id=\"root\"]/main/div[1]/form/div[2]/div/button");
    By toDateInput = xpath("//*[@id=\"root\"]/main/div[1]/form/div[3]/div/button");
    By twentyDateInput = xpath("//*[@id=\":r2:\"]/div/div/div/table/tbody/tr[4]/td[3]/button");
    By twentyThreeDateInput = xpath("//*[@id=\":r0:\"]/div/div/div/table/tbody/tr[4]/td[6]/button");
    By twentyFiveDateInput = xpath("//*[@id=\":r2:\"]/div/div/div/table/tbody/tr[5]/td[1]/button");
    By findMutationButton = xpath("//*[@id=\"btnMutasi\"]");
    By firstMutationData = xpath("//*[@id=\"root\"]/main/div[2]/div/table/tbody/tr[1]/td[5]/span");
    By secondMutationData = xpath("//*[@id=\"root\"]/main/div[2]/div/table/tbody/tr[2]/td[5]/span");
    By getFirstDate = xpath("//*[@id=\"root\"]/main/div[2]/div/table/tbody/tr[1]/td[1]");
    By getThirdDate = xpath("//*[@id=\"root\"]/main/div[2]/div/table/tbody/tr[3]/td[1]");
    By sortingDate = xpath("//*[@id=\"root\"]/main/div[2]/div/table/thead/tr/th[1]");
    By errorMessage = xpath("//*[@id=\"root\"]/div[2]/div/div");

    public MutationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void MutationTextIsDisplayed()
    {
        driver.findElement(mutationText).isDisplayed();
    }

    public void ClickDropdownTransaction()
    {
        driver.findElement(typeofTransactionButton).isDisplayed();
        driver.findElement(typeofTransactionButton).click();
    }

    public void ClickAllTransaction()
    {
        driver.findElement(selectTransactionAll).click();
    }

    public void ClickIncomeTransaction()
    {
        driver.findElement(selectTransactionIn).click();
    }

    public void ClickOutcomeTransaction()
    {
        driver.findElement(selectTransactionOut).click();
    }

    public void InputFromTwentyThreeDate ()
    {
        driver.findElement(fromDateInput).isDisplayed();
        driver.findElement(fromDateInput).click();
        driver.findElement(twentyThreeDateInput).isDisplayed();
        driver.findElement(twentyThreeDateInput).click();
    }

    public void InputToTwentyDate ()
    {
        driver.findElement(toDateInput).isDisplayed();
        driver.findElement(toDateInput).click();
        driver.findElement(twentyDateInput).isDisplayed();
        driver.findElement(twentyDateInput).click();
    }

    public void InputToTwentyFiveDate ()
    {
        driver.findElement(toDateInput).isDisplayed();
        driver.findElement(toDateInput).click();
        driver.findElement(twentyFiveDateInput).isDisplayed();
        driver.findElement(twentyFiveDateInput).click();
    }

    public void ClickFindMutationButton()
    {
        driver.findElement(findMutationButton).isDisplayed();
        driver.findElement(findMutationButton).click();
    }

    public String GetFirstMutationData()
    {
        WebElement element = driver.findElement(firstMutationData);

        String elementText = element.getText();
        String data = elementText.substring(0, 1);
        return data;
    }

    public String GetSecondMutationData()
    {
        WebElement element = driver.findElement(secondMutationData);

        String elementText = element.getText();
        String data = elementText.substring(0, 1);
        return data;
    }

    public String GetFirstDate()
    {
        WebElement element = driver.findElement(getFirstDate);

        String elementText = element.getText();
        String date = elementText.substring(0, 2);
        return date;
    }

    public String GetThirdDate()
    {
        WebElement element = driver.findElement(getThirdDate);

        String elementText = element.getText();
        String date = elementText.substring(0, 2);
        return date;
    }

    public void SortingDate()
    {
        driver.findElement(sortingDate).isDisplayed();
        driver.findElement(sortingDate).click();
    }

    public String ErrorGetText()
    {
        driver.findElement(errorMessage).isDisplayed();
        return driver.findElement(errorMessage).getText();
    }
}
