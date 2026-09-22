import java.util.*;

class Product {

    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double totalValue() {
        return price * quantity;
    }

    void display() {
        System.out.println("----------------------------");
        System.out.println("Product ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Price      : " + price);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Value      : " + totalValue());
        System.out.println("----------------------------");
    }
}

public class InventoryManager {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        products.add(new Product(id, name, price, quantity));
        System.out.println("Product added successfully.");
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n===== PRODUCT LIST =====");

        for (Product p : products) {
            p.display();
        }
    }

    static void searchProduct() {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Product p : products) {
            if (p.id == id) {
                p.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    static void updateQuantity() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product selected = null;

        for (Product p : products) {
            if (p.id == id) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new quantity: ");
        int newQuantity = sc.nextInt();

        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        selected.quantity = newQuantity;
        System.out.println("Quantity updated successfully.");
    }

    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        Product target = null;

        for (Product p : products) {
            if (p.id == id) {
                target = p;
                break;
            }
        }

        if (target != null) {
            products.remove(target);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void sortProductsByPrice() {
        if (products.isEmpty()) {
            System.out.println("No products to sort.");
            return;
        }

        products.sort((a, b) -> Double.compare(a.price, b.price));

        System.out.println("Products sorted by price.");
        viewProducts();
    }

    static void showTotalInventoryValue() {
        double total = 0;

        for (Product p : products) {
            total += p.totalValue();
        }

        System.out.println("Total Inventory Value: " + total);
    }

    static void showLowStockProducts() {
        System.out.print("Enter stock threshold: ");
        int limit = sc.nextInt();

        boolean found = false;

        for (Product p : products) {
            if (p.quantity <= limit) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products found.");
        }
    }

    static void findMostExpensiveProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        Product expensive = products.get(0);

        for (Product p : products) {
            if (p.price > expensive.price) {
                expensive = p;
            }
        }

        System.out.println("\nMost Expensive Product:");
        expensive.display();
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== INVENTORY MANAGEMENT =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. Delete Product");
            System.out.println("6. Sort Products By Price");
            System.out.println("7. Show Total Inventory Value");
            System.out.println("8. Show Low Stock Products");
            System.out.println("9. Find Most Expensive Product");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateQuantity();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    sortProductsByPrice();
                    break;

                case 7:
                    showTotalInventoryValue();
                    break;

                case 8:
                    showLowStockProducts();
                    break;

                case 9:
                    findMostExpensiveProduct();
                    break;

                case 10:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
