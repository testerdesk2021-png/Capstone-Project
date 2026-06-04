package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductCountTest extends BaseTest {

    @Test
    public void productCountTest() {

        int count = home.getProductCount();  //get count
        Assert.assertTrue(count > 0);  //validate count
        System.out.println("Total number of products displayed: " +count);
    }
}
