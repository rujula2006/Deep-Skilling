class Order {

    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Price: " + totalPrice);
        System.out.println();
    }
}

class SortOperations {

    public void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].getTotalPrice();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].getTotalPrice() < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public void displayOrders(Order[] orders) {

        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

public class SortCustomer {

    public static void main(String[] args) {

        Order[] orders1 = {
                new Order(101, "Arun", 5000),
                new Order(102, "Kavin", 2000),
                new Order(103, "Riya", 7000),
                new Order(104, "Priya", 3000)
        };

        SortOperations sort = new SortOperations();

        System.out.println("Bubble Sort:");

        sort.bubbleSort(orders1);
        sort.displayOrders(orders1);

        Order[] orders2 = {
                new Order(101, "Arun", 5000),
                new Order(102, "Kavin", 2000),
                new Order(103, "Riya", 7000),
                new Order(104, "Priya", 3000)
        };

        System.out.println("Quick Sort:");

        sort.quickSort(orders2, 0, orders2.length - 1);
        sort.displayOrders(orders2);
    }
}
