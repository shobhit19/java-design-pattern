package seleniumdesignpattern.proxy;

import driver.Driver;
import org.openqa.selenium.By;

import java.util.Map;

public class CreditCard implements PaymentOption {

    private By cc = By.id("cc");
    private By year = By.id("year");
    private By cvv = By.id("cvv");

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        Driver.getDriver().findElement(cc).sendKeys(paymentDetails.get("cc"));
        Driver.getDriver().findElement(year).sendKeys(paymentDetails.get("year"));
        Driver.getDriver().findElement(cvv).sendKeys(paymentDetails.get("cvv"));
    }
}
