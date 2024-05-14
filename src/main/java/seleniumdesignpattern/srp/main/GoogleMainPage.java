package seleniumdesignpattern.srp.main;

import driver.Driver;
import seleniumdesignpattern.srp.common.SearchSuggestion;
import seleniumdesignpattern.srp.common.SearchWidget;

public class GoogleMainPage {

    public void goToGooglePage(){
        Driver.getDriver().get("https://www.google.co.in");
    }

    public SearchWidget getSearchWidget(){
        return new SearchWidget();
    }
    public SearchSuggestion getSearchSuggestion(){
        return new SearchSuggestion();
    }
}
