import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Product> products = new ArrayList<>();
    private Cart cart = new Cart();
    private Scanner scanner = new Scanner(System.in);

    public Store() {
        products.add(new Product(1, "Laptop", 800.00));
        products.add(new Product(2, "Smartphone", 500.00));
        products.add(new Product(3, "Headphones", 50.00));
        products.add(new Product(4, "Keyboard", 30.00));
    }

    public void start() {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> showProducts();
                case 2 -> addToCart();
                case 3 -> removeFromCart();
                case 4 -> cart.viewCart();
                case 5 -> checkout();
                case 6 -> System.out.println("Exiting store. Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private void showMenu() {
        System.out.println("\n--- E-Commerce Store ---");
        System.out.println("1. View Products");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. Remove Product from Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    private void showProducts() {
        System.out.println("\n--- Products ---");
        for (Product p : products) System.out.println(p);
    }

    private void addToCart() {
        System.out.print("Enter product ID to add: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findProductById(id);
        if (product != null) cart.addProduct(product);
        else System.out.println("Product not found.");
    }

    private void removeFromCart() {
        System.out.print("Enter product ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        cart.removeProduct(id);
    }

    private void checkout() {
        double total = cart.checkout();
        System.out.println("Your total bill: $" + total);
        System.out.println("Thank you for shopping!");
    }

    private Product findProductById(int id) {
        for (Product p : products) if (p.getId() == id) return p;
        return null;
    }
}
