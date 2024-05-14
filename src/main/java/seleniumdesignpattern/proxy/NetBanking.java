package seleniumdesignpattern.proxy;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentOption {


    private By drpDownBank = By.id("bank");
    private By account = By.id("acc_number");
    private By pin = By.id("pin");


    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        Select select = new Select(Driver.getDriver().findElement(drpDownBank));
        select.selectByVisibleText(paymentDetails.get("bank"));
        Driver.getDriver().findElement(account).sendKeys(paymentDetails.get("account"));
        Driver.getDriver().findElement(pin).sendKeys(paymentDetails.get("pin"));

    }
}
