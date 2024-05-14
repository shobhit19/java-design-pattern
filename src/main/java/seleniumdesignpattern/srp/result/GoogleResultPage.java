package seleniumdesignpattern.srp.result;

import seleniumdesignpattern.srp.common.SearchSuggestion;
import seleniumdesignpattern.srp.common.SearchWidget;

public class GoogleResultPage {



    public SearchWidget getSearchWidget(){
        return new SearchWidget();
    }
    public SearchSuggestion getSearchSuggestion(){
        return new SearchSuggestion();
    }
    public NavigationBar getNavigationBar(){
        return new NavigationBar();
    }
    public ResultStat getResultStat(){
        return new ResultStat();
    }

}
