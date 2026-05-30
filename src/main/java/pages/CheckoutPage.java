package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;
    //locators
    By countryDropdown = By.cssSelector("select");
    By agreeCheckbox = By.cssSelector(".chkAgree");
    By proceedBtn = By.xpath("//button[contains(text(),'Proceed')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //select india from dropdown
    public void selectCountry(String countryName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown));
        //create select object
        Select select = new Select(driver.findElement(By.cssSelector("select")));
        //select India
        select.selectByVisibleText(countryName);

    }
    //Agree terms
    public void agreeTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeCheckbox)).click();
    }
    //click proceed
    public void clickProceed() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedBtn)).click();
    }
}

