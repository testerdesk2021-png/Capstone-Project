package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ScreenshotUtil;

//base class for all testcases
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        //initialize browser
        driver = DriverFactory.initDriver();
        //open application url
        driver.get(ConfigReader.getUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            ScreenshotUtil.captureScreenshot(driver, testName);
            System.out.println("Screenshot captured for Failed test: " + testName);
        }
        DriverFactory.quitDriver();
    }

}
