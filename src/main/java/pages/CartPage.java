package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //"click proceed to checkout"  method
    public void clickCheckout()
    {
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // place order method
    public void clickPlaceOrder() {
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
    }

    //get all product names
public List<String> getCartProductNames() {

    List<WebElement> items = driver.findElements((By.cssSelector(".cart-preview .product-name")));
    List<String> names = new ArrayList<>();

    for (WebElement item : items) {
        names.add(item.getText());
    }
    return names;
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
public List<String> getCheckoutProductNames() {
    try {
        Thread.sleep(2000);
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

        String total = driver.findElement(By.cssSelector(".totAmt")).getText();

        return Integer.parseInt(total.trim());
        }

        //get all product prices
    public List<Integer> getProductPrices() {

        List<WebElement> rows = driver.findElements(By.cssSelector(".cartTable tbody tr"));

        List<Integer> priceList = new ArrayList<>();

        for (WebElement row : rows) {
            //get price directly from 5th column
            String priceText = row.findElement(By.cssSelector("td:nth-child(5)")).getText().trim();
            System.out.println("Price found: " +priceText);
            priceList.add(Integer.parseInt(priceText));
        }
        return priceList;
    }


    }















