package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class TransferPage {
    AndroidDriver driver;
    WebDriverWait wait;

    By accountSavedText = xpath("//android.widget.TextView[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/savedList\"]");
    By accountNumberText = xpath("//android.widget.TextView[@content-desc=\"Nomor Rekening\"]");
    By selectDataTransfer = xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/saved_account_list\"]/androidx.cardview.widget.CardView[2]/android.view.ViewGroup");
    By addnewTransfer = xpath("//android.widget.Button[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/addNewAccountInfo\"]");
    By selectBankDropdown = xpath("//android.widget.Spinner[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/bankDropdown\"]");
    By selectBankBCA = xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"BCA\"]");
    By inputAccNumField = xpath("//android.widget.TextView[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/textinput_placeholder\"]");
    By nextButton = xpath("//android.widget.Button[@content-desc=\"Lanjutkan\"]");
    By accNumDetail = xpath("//android.widget.TextView[@resource-id=\"com.synrgy7team4.bankingapps.debug:id/tv_bank_name_account_bank_receiver\"]");
    By nextDetailButton = xpath("//android.widget.Button[@content-desc=\"Lanjutkan\"]");

    public TransferPage(AndroidDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ValidatePage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(addnewTransfer));
    }

    public void SelectAccounDestination()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(selectBankDropdown));
        driver.findElement(selectBankDropdown).click();
        driver.findElement(selectBankBCA).click();
        driver.findElement(inputAccNumField).click();
        driver.findElement(nextButton).click();
    }
}