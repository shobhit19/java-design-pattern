package seleniumdesignpattern.proxy;

import driver.Driver;
import org.openqa.selenium.By;

public class UserInformation {

    private By firstName = By.id("fn");
    private By lastName = By.id("ln");
    private By eMail = By.id("email");

    public void enterDetails(String fn,String ln,String email){
        Driver.getDriver().findElement(firstName).sendKeys(fn);
        Driver.getDriver().findElement(lastName).sendKeys(fn);
        Driver.getDriver().findElement(eMail).sendKeys(email);
    }

}


