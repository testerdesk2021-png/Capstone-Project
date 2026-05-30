package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import pages.HomePage;
import pages.HomePage;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchProductTest() {

        HomePage home = new HomePage(driver);
        home.searchProduct("Beetroot");
        home.waitForProductsToLoad();
        Assert.assertTrue(home.isProductDisplayed("Beetroot"));
    }
}
