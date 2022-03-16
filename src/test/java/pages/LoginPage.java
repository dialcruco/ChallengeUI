package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LandingPage{

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login_button");
    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsernameAndPassword(String username,String password){
        mapElement(usernameField).sendKeys(username);
        mapElement(passwordField).sendKeys(password);
        return new LoginPage(driver);
    }
    public LandingPage loginClick(){
        clickOnLogin(loginButton);
        return new LandingPage(driver);
    }

}
