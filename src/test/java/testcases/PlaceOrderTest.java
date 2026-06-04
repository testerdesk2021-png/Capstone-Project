package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import utils.ScreenshotUtil;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void placeOrderTest() {

        home.addProductByName("Beetroot");
        home.openCart();
        cart.clickCheckout();
        cart.clickPlaceOrder();
        checkout.selectCountry("India");
        checkout.agreeTerms();
        checkout.clickProceed();
        //validation
        Assert.assertTrue(driver.getPageSource().contains("Thank you"));
        String path = ScreenshotUtil.captureScreenshot(driver,"PlaceOrder_Success");
        System.out.println("order placed successfully");
    }
}
