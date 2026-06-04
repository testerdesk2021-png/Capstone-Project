package testcases;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigationTest()  {

        //open Rahulshetty site
        System.out.println("Rahul shetty site opened");

        //navigate to another site
        driver.navigate().to("https://google.com");
        System.out.println("Navigate to google");

        //navigate back, should go to Rahulshetty
        driver.navigate().back();
        System.out.println("Navigate back to previous page");

        //navigate forward
        driver.navigate().forward();
        System.out.println("Navigate forward to google");

        // refresh
        driver.navigate().refresh();
        System.out.println("refreshing the page");

        //validate current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Final URL after navigation: " + currentUrl);

        //validation
        Assert.assertTrue(currentUrl.contains("google"), "Navigation failed");
    }
}

