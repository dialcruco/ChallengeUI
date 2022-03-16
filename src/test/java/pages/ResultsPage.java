package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.transform.Result;

public class ResultsPage {

    private By movieName = By.xpath("//*[@id=\"card_movie_4bc88fc1017a3c122d009254\"]/div/div[2]/div[1]/div/div/a");
    private By filterBox = By.xpath("//*[@id=\"media_v4\"]/div/div/div[2]/div[1]/div[2]/div[1]/span");
    private By actionFilter = By.xpath("//*[@id=\"with_genres\"]/li[1]/a");
    private By searchButton = By.xpath("//*[@id=\"media_v4\"]/div/div/div[2]/div[3]/p/a");
    private By movieChosen = By.xpath("//*[@id=\"page_1\"]/div[2]/div[2]/h2/a[@href=\"/movie/155\"]");
    private By sortBox = By.xpath("//*[@id=\"media_v4\"]/div/div/div[2]/div[1]/div[1]/div[2]/span/span/span[2]/span");
    private By dateAscendingOption = By.xpath("//*[@id=\"sort_by_listbox\"]/li[6]");
    private By searchButtonSort = By.xpath("//*[@id=\"media_v4\"]/div/div/div[2]/div[1]/div[4]/p/a");
    private WebDriver driver;
    private By popMovie1 = By.xpath("//*[@id=\"page_1\"]/div[1]/div[2]/h2/a");


    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage selectFilterAndSearch(){
        driver.findElement(filterBox).click();
        driver.findElement(actionFilter).click();
        driver.findElement(searchButton).click();
        return new ResultsPage(driver);
    }
    public ResultsPage waitForResults(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(movieChosen));
        return new ResultsPage(driver);
    }

    public MoviePage selectMovieFromSearch(){
        driver.findElement(movieChosen).click();
        return new MoviePage(driver);
    }

    public ResultsPage selectSortAndSearch(){
        driver.findElement(sortBox).click();
        driver.findElement(dateAscendingOption).click();
        driver.findElement(searchButtonSort).click();
        return new ResultsPage(driver);
    }
    /*
    public ResultsPage waitForResultsSort(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(popMovieChosen));
        return new ResultsPage(driver);
    }
    */

    //Assertions
    public String getMovieName(){
        return driver.findElement(movieName).getText();
    }

    public String getPopMovie1(){
        return driver.findElement(popMovie1).getText();
    }

}
