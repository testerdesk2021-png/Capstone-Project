package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {
        //create home page object
        HomePage home = new HomePage(driver);
        String product = "Beetroot";
        home.addProductByName(product);
        home.openCart();

        CartPage cart = new CartPage(driver);

        //validate product is visible in cart
        List<String> cartItems = cart.getCartProductNames();
        boolean found = cartItems.stream().anyMatch(item -> item.toLowerCase().contains(product.toLowerCase()));
        Assert.assertTrue(found,"product not found in cart");
        System.out.println("Product is visible in cart");

        //validate Quantity = 1
        int quantity = cart.getProductQuantity(product);
        System.out.println("Quantity: " + quantity);
        Assert.assertEquals(quantity, 1, "Quantity is not equal to 1");
        System.out.println("Quantity validation passed");
    }
}

