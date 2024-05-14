package seleniumdesignpatterntests.template;

import driver.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumdesignpattern.template.AmazonShopping;
import seleniumdesignpattern.template.EBayShopping;
import seleniumdesignpattern.template.ShoppingTemplate;

public class ShoppingTest {



    @Test(dataProvider = "getData")
    public void shoopingTest(ShoppingTemplate shoppingTemplate){
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object [][]getData(){
        return new Object[][]{
                {new AmazonShopping(Driver.getDriver(),"samsung")},
                {new EBayShopping(Driver.getDriver(),"samsung")}
        };
    }
}
