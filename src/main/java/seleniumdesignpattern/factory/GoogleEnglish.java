package seleniumdesignpattern.factory;

import driver.Driver;
import org.openqa.selenium.By;

     class GoogleEnglish extends GooglePage{

    private By searchBox = By.name("q");
    private By btnSearch = By.name("btnK");
    private By lblText = By.id("result-stats");

    @Override
    public void launchSite() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        Driver.getDriver().findElement(searchBox).sendKeys("Selenium");
        Driver.getDriver().findElement(btnSearch).click();
    }

    @Override
    public String getResultCount() {
        return Driver.getDriver().findElement(lblText).getText();
    }
}
