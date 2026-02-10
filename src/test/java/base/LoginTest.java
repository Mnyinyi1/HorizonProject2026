package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {

    private final String username = "mnyinyi@clientele.co.za";
    private final String password = "12Leave123$";

    @Test
    public void enterUsername() {
        loginPage.enterUsername(username);
    }

    @Test(dependsOnMethods = "enterUsername")
    public void enterPassword() {
        loginPage.enterPassword(password);
    }

    @Test(dependsOnMethods = "enterPassword")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }


    @Test(dependsOnMethods = "clickLoginButton")
    public void clickClientCapture() {
        homePage.clickClientCapture();
    }
    @Test(dependsOnMethods = "clickClientCapture")
    public void clickNewQuoteCapture(){
        homePage.clickNewQuoteCapture();
    }
    @AfterTest
    public void tearDown() {
        quitDriver();
    }
}