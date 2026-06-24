public class Main {

    public static void main(String[] args) {

        PaymentStrategy strategy =
                new CreditCardPayment();

        PaymentContext context =
                new PaymentContext(strategy);

        context.executePayment(5000);
    }
}
