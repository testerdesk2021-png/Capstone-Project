package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitUtils {

    private WebDriver driver; //stores webdriver instance
    private WebDriverWait wait; ;//explicit wait object,used to apply wait conditions

    public WaitUtils(WebDriver driver, int timeout)  {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout) );//creates wait object with driver and timeout
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
}
    public void waitForProductsToLoad(By locator) {
        WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
    }

}
