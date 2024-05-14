package seleniumdesignpattern.srp.common;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumdesignpattern.srp.common.AbstractComponent;

import java.time.Duration;

public final class SearchWidget extends AbstractComponent {

    private final By searchBox = By.name("q");


    public void enter(String keyword){
        Driver.getDriver().findElement(searchBox).clear();
        Driver.getDriver().findElement(searchBox).sendKeys(keyword);
    }

    @Override
    public boolean isDisplayed() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        return Driver.getDriver().findElement(searchBox).isDisplayed();
    }
}
