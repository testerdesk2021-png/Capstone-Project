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

        HomePage home = new HomePage(driver);
        home.addProductByName("Beetroot");
        home.openCart();
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();
        //place order
        cart.clickPlaceOrder();
        //create object for checkout page
        CheckoutPage checkout = new CheckoutPage(driver);

        //select India from dropdown
        checkout.selectCountry("India");
        //agree terms
        checkout.agreeTerms();
        //proceed
        checkout.clickProceed();
        //validation
        Assert.assertTrue(driver.getPageSource().contains("Thank you"));
        String path = ScreenshotUtil.captureScreenshot(driver,"PlaceOrder_Success");
        System.out.println("Screenshot saved at: " + path);
    }
}
