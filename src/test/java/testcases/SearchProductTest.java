package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchProduct() {

        home.searchProduct("Beetroot");
        home.waitForProductsToLoad();
        Assert.assertTrue(home.isProductDisplayed("Beetroot"));
        System.out.println("search product is Beetroot");
    }
}
