package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ScreenshotUtil;

import java.sql.Driver;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader config;
    protected HomePage home;
    protected CartPage cart;
    protected CheckoutPage checkout;

    @BeforeMethod
    public void setup() {
         config = new ConfigReader();
         driver =DriverFactory.initDriver(config.getBrowser());
         driver.get(config.getUrl());
         home = new HomePage(driver, 10);
         cart = new CartPage(driver);
         checkout = new CheckoutPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            ScreenshotUtil.captureScreenshot(driver, testName);
            System.out.println("Screenshot captured for Failed test: " + testName);
        }
        driver.quit();
    }

}
