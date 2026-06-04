package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

import java.util.List;

public class AddMultipleProductsTest extends BaseTest {
    @Test
    public void addMultipleProductsTest() {

        String[] products = {"Beetroot", "Tomato"};
        home.addMultipleProducts(products);
        home.openCart();
        cart.clickCheckout();

        //1.validation :to get All products names from checkout table, store in List
        List<String> cartItems = cart.getCheckoutProductNames();
        for (String product : products) {
            String expected = product.toLowerCase().trim();
            boolean found = cartItems.stream().anyMatch(item -> {
                String actual =item.toLowerCase().trim();
                //remove"- 1kg" part from product name
                if(actual.contains("-")) {
                    actual = actual.split("-")[0].trim();
                }
                return actual.equals(expected);
                    });
            Assert.assertTrue(found, " Missing product: " + product);
        }
        System.out.println("All products present in cart");

        //2.price validation :get all product prices from checkout table and store in list
        List<Integer> prices = cart.getProductPrices();
        int expectedTotal = prices.stream().mapToInt(Integer::intValue).sum();//add all product prices and stores as a expected total
        int actualTotal = cart.getTotalAmount(); //get total amount displayed on UI
        System.out.println("Expected Total:" + expectedTotal);
        System.out.println("Actual Total: " +actualTotal);
        Assert.assertEquals(actualTotal,expectedTotal,"Total price mismatch");
        System.out.println("Price Validation successful");

    }

}
