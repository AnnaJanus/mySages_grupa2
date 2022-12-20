import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class AddToCart {

    private static final String URL = "https://www.saucedemo.com/";

    private WebDriver driver;

    private By numberOfItemsInCartSelector = By.cssSelector(".shopping_cart_badge");

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(URL);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

        loginPage.setUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
    }

    @Test
    public void addOneItem(){
        productsPage.clickAddBackpack();

        String numberOfItems = driver.findElement(numberOfItemsInCartSelector).getText();
        Assert.assertEquals(numberOfItems, "1");
    }

    @Test
    public void addTwoItem(){
        productsPage.clickAddBikeLight();

        productsPage.clickBlackTshirt();

        String numberOfItems = driver.findElement(numberOfItemsInCartSelector).getText();
        Assert.assertEquals(numberOfItems, "2");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
