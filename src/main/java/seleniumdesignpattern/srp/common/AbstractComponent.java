package seleniumdesignpattern.srp.common;

import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
    protected WebDriverWait webDriverWait;
    public  abstract boolean isDisplayed();
}
