package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class HomePage {


    WebDriver driver;

    // constructor for PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@href='CaptureClient']")
    WebElement clientCapture_xpath;

    public void clickClientCapture() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(clientCapture_xpath));
        clientCapture_xpath.click();
    }


    @FindBy(xpath = "//button//span[contains(text(),'New Quote Capture')]")
    WebElement newQuoteCapture_xpath;

    public void clickNewQuoteCapture() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(newQuoteCapture_xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newQuoteCapture_xpath);
        try {
            newQuoteCapture_xpath.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newQuoteCapture_xpath);
        }
    }

    @FindBy(xpath = "//p[contains(text(),'Information Board')]")
    WebElement informationBoard_xpath;

    public void isInformationBoardDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(informationBoard_xpath));
        informationBoard_xpath.isDisplayed();
    }

    //div[contains(@class,'rz-dropdown') and .//input[@aria-haspopup='listbox']])[1]")

    @FindBy(xpath = "(//span[contains(@class,'rz-dropdown-label')])[1]")
    WebElement Product_xpath;

//    }
@FindBy(xpath ="//li[@role='option' and @aria-label='OPTION_TEXT']")
WebElement dropdownOption_xpath;



    // Use this method to select an option from the product Radzen dropdown
    public void selectRadzenDropdownOption(String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 1. Click the dropdown (uses Product_xpath)
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Product_xpath));
        dropdown.click();

        // 2. Locate and click the option
        By optionLocator = By.xpath("//li[@role='option' and @aria-label='" + optionText + "']");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));

        // Ensure visible and clickable, then click with fallback
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        try {
            option.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }
    }

    @FindBy(xpath = "(//span[contains(@class,'rz-dropdown-label')])[2]")
       WebElement plan_xpath;


    public void selectRadzenDropdownPlanOption(String optionText) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 1. Open the dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(plan_xpath)
        );
        dropdown.click();

        // 2. Wait for dropdown list to be present
        By dropdownList = By.xpath("//ul[contains(@class,'rz-dropdown-items') and contains(@class,'rz-dropdown-overlay')][3]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownList));

        // 3. Locate option by aria-label or visible text
        By optionLocator = By.xpath(
                "//li[contains(@class,'rz-dropdown-item') and normalize-space(.)='" + optionText + "'][3]"
        );

        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(optionLocator)
        );

        // 4. Scroll + click (Radzen safe)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", option);

        try {
            option.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", option);
        }
    }

}

