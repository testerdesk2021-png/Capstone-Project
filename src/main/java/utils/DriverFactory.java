package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//utility class to manage browser setup
public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver() {

        //set up  chrome driver
        WebDriverManager.chromedriver().setup();
        //launch chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static void quitDriver() {

        driver.quit();
        }

    }

