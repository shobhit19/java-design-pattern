package seleniumdesignpattern.proxy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent{


    private static final List<String> EXCLUDED = Arrays.asList("STAGING","PROD");
    private OrderComponent orderComponent;

    public OrderComponentProxy(){
        String currentEnv = System.getProperty("env");
        if(!EXCLUDED.contains(currentEnv)){
            orderComponent = new OrderComponentReal();
        }
    }

    @Override
    public String placeOrder() {
        if(Objects.nonNull(orderComponent)){
            return orderComponent.placeOrder();
        }
        else {
            return "SKIPPED";
        }
    }
}
