package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //właściwości - selectory...
    private WebDriver driver;

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    private By usernameSelector = By.cssSelector("#user-name");
    private By passwordSelector = By.cssSelector("#password");
    private By loginButtonSelector = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver){
        //ten kod wywoła się podczas tworzenia obiektu LoginPage
        this.driver = driver;
    }

    //metody - kliknij, wpisz...
    public void setUsername(){
        WebElement username = driver.findElement(usernameSelector);
        username.sendKeys(USERNAME);
    }

    public void setPassword(){
        driver.findElement(passwordSelector).sendKeys(PASSWORD);
    }

    public void clickLoginButton(){
        driver.findElement(loginButtonSelector).click();
    }
}
