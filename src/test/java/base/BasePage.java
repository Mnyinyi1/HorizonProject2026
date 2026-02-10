// java
package base;

import Pages.HomePage;
import Pages.loginPage;

import utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
     BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver;
    protected final loginPage loginPage;
    protected  final HomePage homePage ;

    public BasePage() {
        this.driver = browserFactory.startBrowser("chrome", "https://horizontest.clientele.co.za/horizon.ui/");
        this.loginPage = PageFactory.initElements(driver, loginPage.class);
        this .homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}