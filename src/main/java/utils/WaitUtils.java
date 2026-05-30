package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//utility class for explicit waits
public class WaitUtils {

    WebDriver driver ;

    public WaitUtils(WebDriver driver)  {
        this.driver = driver;
    }

    public void waitForElementVisible(By locator) {

        //wait until element is visible
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));

    }



}
