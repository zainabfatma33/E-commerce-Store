import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void removeProduct(int productId) {
        boolean removed = items.removeIf(p -> p.getId() == productId);
        if (removed) System.out.println("Product removed from cart.");
        else System.out.println("Product not found in cart.");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\n--- Your Cart ---");
        double total = 0;
        for (Product p : items) {
            System.out.println(p);
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public double checkout() {
        double total = 0;
        for (Product p : items) total += p.getPrice();
        items.clear();
        return total;
    }
}
