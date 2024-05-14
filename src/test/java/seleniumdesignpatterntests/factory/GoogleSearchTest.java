package seleniumdesignpatterntests.factory;

import driver.Driver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumdesignpattern.factory.GoogleFactory;
import seleniumdesignpattern.factory.GooglePage;

public class GoogleSearchTest {
    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String lang,String keyword){
        googlePage = GoogleFactory.get(lang);
        googlePage.launchSite();
        googlePage.search(keyword);
        String result = googlePage.getResultCount();
        System.out.println(result);

    }
    @DataProvider
    public Object [][] getData(){
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "selenium"},
                {"SA","selenium"}
        };
    }
}
