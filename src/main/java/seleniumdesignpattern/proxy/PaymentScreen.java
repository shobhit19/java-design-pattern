package seleniumdesignpattern.proxy;

import driver.Driver;

public class PaymentScreen {

        private UserInformation userInformation;
        private OrderComponent orderComponent;
        private PaymentOption paymentOption;

        public PaymentScreen(){
                this.userInformation = new UserInformation();
                this.orderComponent = new OrderComponentProxy();
        }

        public UserInformation getUserInformation() {
                return userInformation;
        }

        public OrderComponent getOrder() {
                return orderComponent;
        }

        public void setPaymentOption(PaymentOption paymentOption) {
                this.paymentOption = paymentOption;
        }

        public PaymentOption getPaymentOption() {
                return paymentOption;
        }
        public void goTo(){
                Driver.getDriver().get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
        }
}
