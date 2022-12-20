package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private WebDriver driver;
    private By addToCartBackpackSelector = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private By addToCartBikeLightSelector = By.cssSelector("#add-to-cart-sauce-labs-bike-light");
    private By addToCartBlackTShirtSelector = By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddBackpack(){
        WebElement addToCartBackpack = driver.findElement(addToCartBackpackSelector);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(addToCartBackpack));
        addToCartBackpack.click();
    }

    public void clickAddBikeLight(){
        driver.findElement(addToCartBikeLightSelector).click();
    }

    public void clickBlackTshirt(){
        driver.findElement(addToCartBlackTShirtSelector).click();
    }


}
