package seleniumdesignpatterntests.command;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import seleniumdesignpattern.command.ElementValidator;
import seleniumdesignpattern.command.HomePage;

import java.util.List;

public class HomePageTest {
    private HomePage homePage;

    @BeforeTest
    public void init(){
        homePage = new HomePage();
    }

    @Test
    public void homePageTest(){
        homePage.goTo();
        // Before java 8
        for(ElementValidator ev :homePage.getElementValidator()){
            boolean result=ev.validate();
            Assert.assertTrue(result);
        }
         // Java 8
        homePage.getElementValidator()
                .stream()
                .map(ev->ev.validate())
                .forEach(b-> Assert.assertTrue(b));

    }
    @AfterTest
    public void tearDown(){
        Driver.getDriver().quit();
    }
}
