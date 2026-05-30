package testcases;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigationTest() throws InterruptedException {

        //open Rahulshetty site
        System.out.println("Rahul shetty site opened");
        Thread.sleep(500);

        //navigate to another site
        driver.navigate().to("https://google.com");
        System.out.println("Navigate to google");
        Thread.sleep(500);

        //navigate back, should go to Rahulshetty
        driver.navigate().back();
        System.out.println("Navigate back to previous page");
        Thread.sleep(500);

        //navigate forward
        driver.navigate().forward();
        System.out.println("Navigate forward to google");
        Thread.sleep(500);

        // refresh
        driver.navigate().refresh();
        System.out.println("refreshing the page");
        Thread.sleep(500);

        //validate current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Final URL after navigation: " + currentUrl);

        //validation
        Assert.assertTrue(currentUrl.contains("google"), "Navigation failed");
    }
}

