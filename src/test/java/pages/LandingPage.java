package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage{

    private By loginButtonHome = By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/ul/li[3]/a");
    private By profileName = By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div/div/div[1]/h2/a");
    private By badConfirmMessage = By.xpath("//*[@id=\"main\"]/section/div/div/div/div/div/a/h2");
    private By searchBar = By.id("inner_search_v4");
    private By searchButton = By.xpath("//*[@id=\"inner_search_form\"]/input");
    private By topRatedButton = By.xpath("/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/div/ul/li[4]/a");
    private By moviesButtonHome = By.xpath("/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]");
    private By movieToSelect = By.xpath("//*[@id=\"popular_scroller\"]/div/div[3]/div[2]/h2/a");
    private By popularButton = By.xpath("/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/div/ul/li[1]/a");
    //private WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLogin(){
        driver.findElement(loginButtonHome).click();
        return new LoginPage(driver);
    }
    public LoginPage clickOnLogin(By locator){
        driver.findElement(locator).click();
        return new LoginPage(driver);
    }

    public WebElement mapElement(By locator){
        return super.mapElement(locator);
    }

    public LandingPage searchQuery(String query){
        super.mapElement(searchBar).sendKeys(query);
        return new LandingPage(driver);
    }

    public ResultsPage searchButtonClick(){
        driver.findElement(searchButton).click();
        return new ResultsPage(driver);
    }

    public ResultsPage clickOnTopRatedMovies(){
        driver.findElement(moviesButtonHome).click();
        driver.findElement(topRatedButton).click();
        return new ResultsPage(driver);
    }

    public MoviePage selectMovie() {
        driver.findElement(movieToSelect).click();
        return new MoviePage(driver);
    }
    public ResultsPage clickOnPopularMovies(){
        driver.findElement(moviesButtonHome).click();
        driver.findElement(popularButton).click();
        return new ResultsPage(driver);
    }

    //Assertions
    public String getProfileName(WebDriver driver){
        return driver.findElement(profileName).getText();
    }

    public String getBadConfirmation(WebDriver driver){
        return driver.findElement(badConfirmMessage).getText();
    }


}
