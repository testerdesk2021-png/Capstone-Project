package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;  //driver instance to interact with browser
    WaitUtils wait;// wait utility for synchronization

    By searchBox = By.cssSelector(".search-keyword");
    By productList = By.cssSelector(".product");
    By cartIcon = By.cssSelector(".cart-icon");

    public HomePage(WebDriver driver, int timeout) {

        this.driver = driver;  //assign driver to this class
        wait = new WaitUtils(driver, timeout); //initialize wait with timeout
    }

    //1.method to search product
public void searchProduct(String productName) {

        driver.findElement(searchBox).sendKeys(productName);
}
     //Method to wait for products to load after search
     public void waitForProductsToLoad() {

        wait.waitForProductsToLoad(productList);
     }

    //method to verify if product is displayed
    public boolean isProductDisplayed(String productName) {
        List<WebElement> products = driver.findElements(productList);  //get list of all product elements
      for (WebElement product : products)  {
          String name = product.findElement(By.cssSelector("h4.product-name")).getText(); //get product name
          if (name.toLowerCase().contains(productName.toLowerCase())) {  //compare with expected product name
              return true;
          }
      }
        return false;
 }
     //2.method to add product by name
  public void addProductByName(String productName) {
        List<WebElement> products = driver.findElements(productList);
     for (WebElement product : products)  {
         String name = product.findElement(By.cssSelector("h4.product-name")).getText();//get product name text
         if (name.toLowerCase().contains(productName.toLowerCase())) { //check if product name matches required product
             product.findElement(By.cssSelector(".product-action button")).click();
                break; //exit loop after adding product
         }
     }
 }
 //3.method to add multiple products
     public void addMultipleProducts(String[] productNames) {

         for (String nameToAdd : productNames) {
         List<WebElement> products = driver.findElements(productList);
             boolean productFound =false;
             for(WebElement product : products) {
                 String name = product.findElement(By.cssSelector("h4.product-name")).getText();
                 if(name.toLowerCase().contains(nameToAdd.toLowerCase())) {
                     product.findElement(By.cssSelector(".product-action button")).click();
                    System.out.println("Added product: " +name);
                     productFound = true;
                     break;
                 }
             }
             if (!productFound) {
                 throw new RuntimeException("Product not found: " + nameToAdd);
             }
         }
     }
//4.method to get total no.of products
public int getProductCount() {
        List<WebElement> products = driver.findElements(productList);
    int visibleCount = 0;
    for (WebElement product : products) { //count only displayed products

        if (product.isDisplayed()) {
            visibleCount++;
        }
    }
    return visibleCount;
    }

     //5.method to open cart
     public void openCart() {
        wait.waitForClickable(cartIcon).click();

     }
 }

