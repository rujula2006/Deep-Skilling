class Product {

    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
    }
}

class SearchOperations {

    public Product linearSearch(Product[] products, int productId) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == productId) {
                return products[i];
            }
        }

        return null;
    }

    public Product binarySearch(Product[] products, int productId) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            }

            if (products[mid].getProductId() < productId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}

public class ECommerce {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Electronics")
        };

        SearchOperations search = new SearchOperations();

        System.out.println("Linear Search:");

        Product p1 = search.linearSearch(products, 104);

        if (p1 != null) {
            p1.displayProduct();
        } else {
            System.out.println("Product not found");
        }

        System.out.println();

        System.out.println("Binary Search:");

        Product p2 = search.binarySearch(products, 104);

        if (p2 != null) {
            p2.displayProduct();
        } else {
            System.out.println("Product not found");
        }
    }
}