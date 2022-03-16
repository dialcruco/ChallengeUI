package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoviePage {

    private WebDriver driver;
    private By movieGenre = By.xpath("//*[@id=\"original_header\"]/div[2]/section/div[1]/div/span[3]/a[2]");
    private By actorToSelect = By.xpath("//*[@id=\"popular_scroller\"]/div/div[3]/div[2]/h2");

    public MoviePage(WebDriver driver) {
        this.driver = driver;
    }

    public ActorPage selectActor(){
        driver.findElement(actorToSelect).click();
        return new ActorPage(driver);
    }

    //Assertions
    public String getMovieGenre(){
        return driver.findElement(movieGenre).getText();
    }
}
