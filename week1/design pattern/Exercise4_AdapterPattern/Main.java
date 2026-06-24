 public class Main {

    public static void main(String[] args) {

        PayPalGateway payPalGateway =
                new PayPalGateway();

        PaymentProcessor paymentProcessor =
                new PayPalAdapter(payPalGateway);

        paymentProcessor.processPayment(5000);
    }
}
