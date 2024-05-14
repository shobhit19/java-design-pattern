package seleniumdesignpattern.strategy;

import driver.Driver;

public class PaymentScreen {

        private UserInformation userInformation;
        private Order order;
        private PaymentOption paymentOption;

        public PaymentScreen(){
                this.userInformation = new UserInformation();
                this.order = new Order();
        }

        public UserInformation getUserInformation() {
                return userInformation;
        }

        public Order getOrder() {
                return order;
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
