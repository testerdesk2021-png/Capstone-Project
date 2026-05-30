package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductCountTest extends BaseTest {

    @Test
    public void productCountTest() {

        HomePage home = new HomePage(driver);
        //get count
        int count = home.getProductCount();

        //validate count
        Assert.assertTrue(count > 0);
        System.out.println("Total number of products displayed: " +count);
    }
}
