package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WaitUtils wait;

    public CartPage(WebDriver driver) {
        this.driver = driver; //assign driver to this class
        this.wait = new WaitUtils(driver, 10); //initialize wait with timeout
    }

    //"click proceed to checkout"  method
    public void clickCheckout()
    {
        By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
        wait.waitForClickable(checkoutButton).click();
    }
    // place order method
    public void clickPlaceOrder() {
        By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
        wait.waitForClickable(placeOrderButton).click();
    }
    //get all cart product names
public List<String> getCartProductNames() {

    List<WebElement> items = driver.findElements((By.cssSelector(".cart-preview .product-name")));
    List<String> names = new ArrayList<>(); //store product names
    for (WebElement item : items) {
        names.add(item.getText());//add to list
    }
    return names;//return all product names
}

    //method to get quantity of products
    public int getProductQuantity(String productName) {
        List<WebElement> items = driver.findElements(By.cssSelector(".cart-preview .product-name"));
       int count =0;
       for(WebElement item : items) {
           String name = item.getText().toLowerCase();
           if(name.contains(productName.toLowerCase())){
               count++;
           }
       }
       return count;
    }
    //method to get checkout products names
public List<String> getCheckoutProductNames() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    List<WebElement> rows = driver.findElements(By.cssSelector(".cartTable tbody tr"));
    List<String> names = new ArrayList<>();
    for (WebElement row : rows) {
        String name = row.findElement(By.cssSelector("td:nth-child(2)")).getText().toLowerCase();
        System.out.println("Found products in checkout: " + name);
        names.add(name);
    }
    return names;
}

//method to get total amount
    public int getTotalAmount() {
        //get total amount displayed in UI and convert to int
        String total = driver.findElement(By.cssSelector(".totAmt")).getText();
        return Integer.parseInt(total.trim());
        }

        //method get all product prices
    public List<Integer> getProductPrices() {
        List<WebElement> rows = driver.findElements(By.cssSelector(".cartTable tbody tr"));//get all rows from cart table
        List<Integer> priceList = new ArrayList<>();//store prices
        for (WebElement row : rows) {
            String priceText = row.findElement(By.cssSelector("td:nth-child(5)")).getText().trim(); //get price directly from 5th column
            System.out.println("Price found: " +priceText);
            priceList.add(Integer.parseInt(priceText)); //add to list and convert to integer
        }
        return priceList;
    }


    }















