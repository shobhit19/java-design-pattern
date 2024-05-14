package seleniumdesignpattern.srp.result;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumdesignpattern.srp.common.AbstractComponent;

import java.time.Duration;

public class ResultStat extends AbstractComponent {

    private By resultText = By.id("result-stats");


    public String getCountOfResults(){
       return Driver.getDriver().findElement(resultText).getText();
    }

    @Override
    public boolean isDisplayed() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(resultText));
        return Driver.getDriver().findElement(resultText).isDisplayed();
    }
}
