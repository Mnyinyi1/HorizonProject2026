package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    WebDriver driver;

    @FindBy(xpath = "//a[@href='CaptureClient']")
    WebElement clientCapture_xpath;

    public void clickClientCapture() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(clientCapture_xpath));
        clientCapture_xpath.click();
    }

    public
    @FindBy(xpath = "//span[text()='New Quote Capture']")
    WebElement newQuoteCapture_xpath;

    public void clickNewQuoteCapture() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(newQuoteCapture_xpath));
        newQuoteCapture_xpath.click();


    }
}


