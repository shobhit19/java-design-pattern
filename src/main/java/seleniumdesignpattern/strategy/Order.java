package seleniumdesignpattern.strategy;

import driver.Driver;
import org.openqa.selenium.By;

public class Order {

    private By btnBuy = By.id("buy");
    private By order = By.id("ordernumber");

    public String placeOrder(){
        Driver.getDriver().findElement(btnBuy).click();
        return Driver.getDriver().findElement(order).getText();
    }
}
