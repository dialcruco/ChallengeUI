import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class Runner extends Hooks {

    @Test
    public void successfulLogin(){
        LandingPage landingPageSuccessful = new LandingPage(driver);

        LoginPage loginPage = landingPageSuccessful.clickOnLogin();
        loginPage.enterUsernameAndPassword("dicruz","Testingintern2022");
        LandingPage newLandingPage = loginPage.loginClick();

        Assert.assertEquals(newLandingPage.getProfileName(driver),"dicruz");
    }
    @Test
    public void failedLogin(){
        LandingPage landingPageFailed = new LandingPage(driver);
        LoginPage loginPageFailed = landingPageFailed.clickOnLogin();
        loginPageFailed.enterUsernameAndPassword("dicruz","NonValidPassword");

        LandingPage failed = loginPageFailed.loginClick();

        Assert.assertEquals(failed.getBadConfirmation(driver)," There was a problem");
    }
    @Test
    public void successfulSearch(){
        LandingPage landingPageSearch = new LandingPage(driver);
        landingPageSearch.searchQuery("Fight Club");

        ResultsPage resultsPageSearch = landingPageSearch.searchButtonClick();

        Assert.assertEquals(resultsPageSearch.getMovieName(),"Fight Club");
    }
    @Test
    public void verifyMovieGenreFilter(){
        LandingPage landingPageGenreFilter = new LandingPage(driver);
        ResultsPage resultsPageFilter = landingPageGenreFilter.clickOnTopRatedMovies();
        resultsPageFilter.selectFilterAndSearch()
                .waitForResults();

        MoviePage movieInfo = resultsPageFilter.selectMovieFromSearch();

        Assert.assertEquals(movieInfo.getMovieGenre(),"Action");
    }

    @Test
    public void validateActingTimeline(){
        //Movie in timeline: //*[@id="media_v4"]/div/div/div[2]/div/section[4]/div[1]/table[1]/tbody/tr[16]/td/table/tbody/tr[3]/td[3]/a

        LandingPage landingPageActingTimeline = new LandingPage(driver);
        ResultsPage resultsPageValidate = landingPageActingTimeline.clickOnPopularMovies();
        
    }
    @Test
    public void sortByDatesOnAscendingOrder(){
        LandingPage landingPageSorting = new LandingPage(driver);
        ResultsPage resultsPageSorting = landingPageSorting.clickOnPopularMovies();
        resultsPageSorting.selectSortAndSearch();


        //Assert.assertEquals(resultsPageSorting.getPopMovie1(),"Passage of Venus");


    }
}
