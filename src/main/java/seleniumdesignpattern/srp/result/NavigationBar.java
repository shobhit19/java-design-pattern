package seleniumdesignpattern.srp.result;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumdesignpattern.srp.common.AbstractComponent;

import java.time.Duration;

public class NavigationBar extends AbstractComponent {

    private By bar = By.id("bqHHPb");
    private By images = By.linkText("Images");
    private By news = By.xpath("//span[text()='Images']/parent::div");

    public void goToImages(){
        Driver.getDriver().findElement(images).click();
    }

    public void goToNews(){
        Driver.getDriver().findElement(news).click();
    }

    @Override
    public boolean isDisplayed() {
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(bar));
        return Driver.getDriver().findElement(bar).isDisplayed();
    }

}
