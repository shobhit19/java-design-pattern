package seleniumdesignpattern.srp.common;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumdesignpattern.srp.common.AbstractComponent;

import java.time.Duration;
import java.util.List;

public final class SearchSuggestion extends AbstractComponent {

    private By suggestions = By.xpath("//li[@class='sbct']");


    public void clickSuggestion(int index){
        List<WebElement> list=Driver.getDriver().findElements(suggestions);
        list.get(index-1).click();
    }

    @Override
    public boolean isDisplayed() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        return webDriverWait.until((d)->Driver.getDriver().findElements(suggestions).size()>5);
    }
}
