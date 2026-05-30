package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By searchBox = By.cssSelector(".search-keyword");
    By productList = By.cssSelector(".product");
    By cartIcon = By.cssSelector(".cart-icon");

    public HomePage(WebDriver driver) {
        //assign driver to this class
        this.driver = driver;
        //initialize wait
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //1.method to search product
public void searchProduct(String productName) {

    driver.findElement(searchBox).sendKeys(productName);
}
 //Method to wait for products to load after search
    public void waitForProductsToLoad() {

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.numberOfElementsToBeMoreThan(productList, 0));
    }

    //method to verify if product is displayed
    public boolean isProductDisplayed(String productName) {

        //get list of all product elements
    List<WebElement> products = driver.findElements(productList);
      for (WebElement product : products)  {
          //get product name
          String name = product.findElement(By.cssSelector("h4.product-name")).getText();
          //compare with expected product name
          if (name.toLowerCase().contains(productName.toLowerCase())) {
              return true;

          }
      }
        return false;
}
   //2.method to add product by name

public void addProductByName(String productName) {

    List<WebElement> products = driver.findElements(By.cssSelector(".product"));
    for (WebElement product : products)  {
        String name = product.findElement(By.cssSelector("h4.product-name")).getText();
        if (name.toLowerCase().contains(productName.toLowerCase())) {
            WebElement addBtn = product.findElement(By.cssSelector(".product-action button"));
            wait.until(ExpectedConditions.elementToBeClickable(addBtn));
            addBtn.click();
           wait.until(driver -> addBtn.getText().toLowerCase().contains("added"));

            break;
        }
    }
}

//3.method to add multiple products
    public void addMultipleProducts(String[] productNames) {

        for (String nameToAdd : productNames) {

        List<WebElement> products = driver.findElements(By.cssSelector(".product"));
            boolean productFound =false;

            for(WebElement product : products) {

                String name = product.findElement(By.cssSelector("h4.product-name")).getText();

                if(name.toLowerCase().contains(nameToAdd.toLowerCase())) {
                    WebElement addBtn = product.findElement(By.cssSelector(".product-action button"));
                    wait.until(ExpectedConditions.elementToBeClickable(addBtn));
                    addBtn.click();
                    System.out.println("Added product: " +name);
                   wait.until(driver -> addBtn.getText().toLowerCase().contains("added"));
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
    //count only displayed products
    for (WebElement product : products) {

        if (product.isDisplayed()) {
            visibleCount++;
        }
    }
    //return visible product count
    return visibleCount;
    }

    //5.method to open cart
    public void openCart() {

        driver.findElement(cartIcon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-preview")));

    }
}

