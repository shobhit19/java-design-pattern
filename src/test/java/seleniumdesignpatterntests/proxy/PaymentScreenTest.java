package seleniumdesignpatterntests.proxy;



import driver.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumdesignpattern.proxy.CreditCard;
import seleniumdesignpattern.proxy.NetBanking;
import seleniumdesignpattern.proxy.PaymentOption;
import seleniumdesignpattern.proxy.PaymentScreen;

import java.util.HashMap;
import java.util.Map;

public class PaymentScreenTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void test(){
        System.setProperty("env","PROD");
        paymentScreen = new PaymentScreen();
    }

    @Test(dataProvider = "getData")
    public void paymentTest(PaymentOption paymentOption, Map<String,String> paymentDetails){
        paymentScreen.goTo();
        paymentScreen.getUserInformation().enterDetails("cecq","cefcef","dey@gmail.com");
        paymentScreen.setPaymentOption(paymentOption);
        paymentScreen.getPaymentOption().enterPaymentInformation(paymentDetails);
        String orderNumber = paymentScreen.getOrder().placeOrder();

        System.out.println("Order Number: "+orderNumber);
    }

    @AfterTest
    public void tearDown(){
        Driver.getDriver().quit();
    }
    @DataProvider
    public Object [][] getData(){

        Map<String,String> cc = new HashMap<>();
        cc.put("cc","712912871981");
        cc.put("year","2050");
        cc.put("cvv","211");

        Map<String,String> nb = new HashMap<>();
        nb.put("bank","WELLS FARGO");
        nb.put("account","my account");
        nb.put("pin","999");

        return new Object[][]{
                {new CreditCard(),cc},
                {new NetBanking(),nb}

        };
    }

}
