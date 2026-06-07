import java.util.*;

public class InventoryManager {

    // Product Class
    static class Product {

        private int id;
        private String name;
        private double price;
        private int quantity;

        public Product(int id, String name, double price, int quantity) {

            if (id <= 0)
                throw new IllegalArgumentException("Invalid Product ID");

            if (price < 0)
                throw new IllegalArgumentException("Price cannot be negative");

            if (quantity < 0)
                throw new IllegalArgumentException("Quantity cannot be negative");

            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {

            if (quantity < 0)
                throw new IllegalArgumentException("Quantity cannot be negative");

            this.quantity = quantity;
        }

        public double getInventoryValue() {
            return price * quantity;
        }

        public void display() {

            System.out.println("--------------------------------------");
            System.out.println("Product ID      : " + id);
            System.out.println("Product Name    : " + name);
            System.out.println("Price           : ₹" + price);
            System.out.println("Quantity        : " + quantity);
            System.out.println("Inventory Value : ₹" + getInventoryValue());

            if (quantity < 5)
                System.out.println("⚠ LOW STOCK");

            System.out.println("--------------------------------------");
        }
    }

    // Inventory Storage
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Product
    static void addProduct() {

        try {

            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Product p : products) {
                if (p.getId() == id) {
                    System.out.println("Product ID already exists.");
                    return;
                }
            }

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Product Price: ");
            double price = Double.parseDouble(sc.nextLine());

            System.out.print("Enter Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());

            products.add(new Product(id, name, price, quantity));

            System.out.println("Product Added Successfully.");

        } catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }

    // View Products
    static void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("Inventory Empty.");
            return;
        }

        for (Product p : products) {
            p.display();
        }
    }

    // Search By ID
    static void searchById() {

        try {

            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Product p : products) {

                if (p.getId() == id) {
                    p.display();
                    return;
                }
            }

            System.out.println("Product Not Found.");

        } catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }

    // Search By Name
    static void searchByName() {

        System.out.print("Enter Product Name: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Product p : products) {

            if (p.getName().toLowerCase().contains(keyword)) {
                p.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("No Matching Products Found.");
    }

    // Update Quantity
    static void updateQuantity() {

        try {

            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Product p : products) {

                if (p.getId() == id) {

                    System.out.print("Enter New Quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    p.setQuantity(quantity);

                    System.out.println("Quantity Updated Successfully.");
                    return;
                }
            }

            System.out.println("Product Not Found.");

        } catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }

    // Delete Product
    static void deleteProduct() {

        try {

            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(sc.nextLine());

            Iterator<Product> iterator = products.iterator();

            while (iterator.hasNext()) {

                Product p = iterator.next();

                if (p.getId() == id) {

                    iterator.remove();

                    System.out.println("Product Deleted Successfully.");
                    return;
                }
            }

            System.out.println("Product Not Found.");

        } catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }

    // Sort Products
    static void sortByPrice() {

        products.sort(
                Comparator.comparingDouble(Product::getPrice)
        );

        System.out.println("Products Sorted By Price.");
    }

    // Inventory Value
    static void showTotalInventoryValue() {

        double total = 0;

        for (Product p : products) {
            total += p.getInventoryValue();
        }

        System.out.println("Total Inventory Value = ₹" + total);
    }

    // Low Stock Report
    static void lowStockReport() {

        boolean found = false;

        for (Product p : products) {

            if (p.getQuantity() < 5) {

                p.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("No Low Stock Products.");
    }

    // Statistics
    static void showStatistics() {

        double totalValue = 0;
        int totalQuantity = 0;

        for (Product p : products) {

            totalValue += p.getInventoryValue();
            totalQuantity += p.getQuantity();
        }

        System.out.println("\n===== INVENTORY STATISTICS =====");
        System.out.println("Total Products       : " + products.size());
        System.out.println("Total Quantity       : " + totalQuantity);
        System.out.println("Total Inventory Value: ₹" + totalValue);
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== SMART INVENTORY SYSTEM ==========");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product By ID");
            System.out.println("4. Search Product By Name");
            System.out.println("5. Update Quantity");
            System.out.println("6. Delete Product");
            System.out.println("7. Sort Products By Price");
            System.out.println("8. Show Total Inventory Value");
            System.out.println("9. Low Stock Report");
            System.out.println("10. Inventory Statistics");
            System.out.println("11. Exit");

            System.out.print("Enter Choice: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        addProduct();
                        break;

                    case 2:
                        viewProducts();
                        break;

                    case 3:
                        searchById();
                        break;

                    case 4:
                        searchByName();
                        break;

                    case 5:
                        updateQuantity();
                        break;

                    case 6:
                        deleteProduct();
                        break;

                    case 7:
                        sortByPrice();
                        break;

                    case 8:
                        showTotalInventoryValue();
                        break;

                    case 9:
                        lowStockReport();
                        break;

                    case 10:
                        showStatistics();
                        break;

                    case 11:
                        System.out.println("Exiting Program...");
                        return;

                    default:
                        System.out.println("Invalid Choice.");
                }

            } catch (Exception e) {
                System.out.println("Please Enter Valid Input.");
            }
        }
    }
}
