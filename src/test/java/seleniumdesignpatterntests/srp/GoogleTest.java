package seleniumdesignpatterntests.srp;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumdesignpattern.srp.main.GoogleMainPage;
import seleniumdesignpattern.srp.result.GoogleResultPage;

public class GoogleTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setUpPages(){
        googleMainPage = new GoogleMainPage();
        googleResultPage = new GoogleResultPage();

    }

    @DataProvider
    Object [][] getData(){
        return new Object[][]{
                {"Selenium WebDriver",1},
                {"docker",7}
        };
    }
    @Test(dataProvider = "getData")
    public void googleWorkFlow(String keyword,int index){

        googleMainPage.goToGooglePage();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestion(index);


        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestion(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getResultStat().isDisplayed();
        System.out.println(googleResultPage.getResultStat().getCountOfResults());

       googleResultPage.getNavigationBar().goToImages();

       Driver.getDriver().quit();


    }
}
