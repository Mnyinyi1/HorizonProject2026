package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BasePage {

    private final String username = "mnyinyi@clientele.co.za";
    private final String password = "Offsets123$";

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
    public void isInformationBoardDisplayed() {
        homePage.isInformationBoardDisplayed();
    }

    @Test(dependsOnMethods = "isInformationBoardDisplayed")
    public void clickClientCapture() {
        homePage.clickClientCapture();
    }


    @Test(dependsOnMethods = "clickClientCapture")
    public void clickNewQuoteCapture() {
        homePage.clickNewQuoteCapture();
    }

    @Test(dependsOnMethods = "clickNewQuoteCapture")
//    public void selectSelect(){
//       homePage.selectSelect();
//    }

    //@Test(dependsOnMethods = "selectSelect")
    public void selectPlanTypeFromDropdown() {
        homePage.selectRadzenDropdownOption("Clientele Funeral Dignity Plan");
    }

    @Test(dependsOnMethods = "selectPlanTypeFromDropdown")
    public void selectPlanTypeFromDropdown1() {
        homePage.selectRadzenDropdownPlanOption("Clientele Funeral Dignity Plan");

    }
    //@Test(dependsOnMethods = "selectPlanTypeFromDropdown")


//    public  void  selectPlanItem(){
//        homePage.selectPlanItem();
//    }
//   @Test(dependsOnMethods = "selectPlanTypeFromDropdown")
//    public void selectPlanType(){
//        homePage.selectPlanTypeFromDropdown();
//   }
//    public void SelectProdOption(){
//        homePage.SelectPlann("Clientèle Funeral Dignity Plan");
//    }
//    @Test(dependsOnMethods = "selectSelect")
//    public void ProdPlanType(){
//        homePage.ProdPlanType("Clientèle Funeral Dignity Plan");
//    }
//    @Test(dependsOnMethods = "ProdPlanType")
//    public void selectPlan(){
//        homePage.selectPlan();
//    }
//    @Test(dependsOnMethods = "selectPlan")
//            public void ProdPlanType1(){
//        homePage.ProdPlanType1("Clientèle Funeral Dignity Plan");
//    }

//    @Test(dependsOnMethods = "selectSelect")
//    public void SelectPlan(){
//        homePage.SelectPlann("Clientèle Worksite Solution");
//    }
//    @Test(dependsOnMethods ="SelectPlan" )
//            public void capturePlan(){
//        homePage.SelectPlann("Clientèle Funeral Dignity Plan");
//
//    }
//    @Test(dependsOnMethods = "SelectPlan")
//    public void ProdPlanType(){
//    homePage.ProdPlanType("Clientèle Funeral Dignity Plan");
//
//    }
//  @Test(dependsOnMethods = "selectprodplan")
//    public void selectPlan(){
//        homePage.selectPlan();
//    }


//    @Test(dependsOnMethods = "SelectPlan")
//    public void clickContinueButton() {
//        homePage.clickContinueButton();
//    }
//
//


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (org.openqa.selenium.NoSuchSessionException ignored) {
                // session already closed
            } catch (Exception ignored) {
            }
        }
    }
}