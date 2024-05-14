package seleniumdesignpattern.factory;

import driver.Driver;
import org.openqa.selenium.By;

 class GoogleArabic extends GoogleEnglish{

    private By linkLang = By.linkText("العربية");

    @Override
    public void launchSite() {
        Driver.getDriver().get("https://www.google.com.sa");
    }
}
