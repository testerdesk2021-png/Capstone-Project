package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;
import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WaitUtils wait;

    By countryDropdown = By.cssSelector("select");
    By agreeCheckbox = By.cssSelector(".chkAgree");
    By proceedBtn = By.xpath("//button[contains(text(),'Proceed')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }
    //select India from dropdown
    public void selectCountry(String countryName) {

        Select select = new Select(driver.findElement(countryDropdown));//create select object
        wait.waitForVisibility(countryDropdown).click();//wait for dropdown to be visible and click to open
        select.selectByVisibleText(countryName);//select India

    }
    //Agree terms
    public void agreeTerms() {
        wait.waitForClickable(agreeCheckbox).click();
    }
    //click proceed
    public void clickProceed() {
        wait.waitForClickable(proceedBtn).click();
    }
}

