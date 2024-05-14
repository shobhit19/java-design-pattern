package seleniumdesignpattern.factory;

import driver.Driver;
import org.openqa.selenium.By;

 class GoogleFrench extends GoogleEnglish{

    private By linkLang = By.linkText("Français");

    @Override
    public void launchSite() {
        Driver.getDriver().get("https://www.google.fr");
        Driver.getDriver().findElement(linkLang).click();
    }

}
