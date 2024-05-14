package seleniumdesignpattern.proxy;

import driver.Driver;
import org.openqa.selenium.By;

public class OrderComponentReal implements OrderComponent{

    private By btnBuy = By.id("buy");
    private By order = By.id("ordernumber");



    @Override
    public String placeOrder() {
        Driver.getDriver().findElement(btnBuy).click();
        return Driver.getDriver().findElement(order).getText();
    }
}
