package Kha1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ProductManagementSystem {
    private static Map<Integer, Product> productMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        productMap.put(2, new Product(2, "Khoai tây chiên", 20000.0));
        productMap.put(3, new Product(3, "Kẹo cốm", 50.0));


        while (true) {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    filterProducts();
                    break;
                case 6:
                    totalValue();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, price);
        productMap.put(id, product);
        System.out.println("Product added successfully.");
    }


    private static void editProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (productMap.containsKey(id)) {
            System.out.print("Enter new Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new Product Price: ");
            double price = scanner.nextDouble();

            // Cập nhật thông tin mới cho sản phẩm
            Product product = productMap.get(id);
            product.setName(name);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }


    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();

        if (productMap.containsKey(id)) {
            productMap.remove(id);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }


    private static void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        productMap.values().forEach(System.out::println);
    }


    private static void filterProducts() {
        System.out.println("Products with price greater than 100:");
        productMap.values().stream()
                .filter(product -> product.getPrice() > 100) // Lọc điều kiện giá trị lớn hơn 100
                .forEach(System.out::println); // In ra màn hình các sản phẩm thỏa mãn
    }


    private static void totalValue() {
        double total = productMap.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total value of products: " + total);
    }
}
