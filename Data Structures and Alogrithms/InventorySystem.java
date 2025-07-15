// InventorySystem.java - Manage products using HashMap

import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Qty: " + quantity + ", Price: ₹" + price;
    }
}

class InventorySystem {
    private Map<Integer, Product> inventory;

    public InventorySystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added: " + product.productName);
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.quantity = newQuantity;
            System.out.println("Updated quantity for " + p.productName + ": " + newQuantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            System.out.println("Deleted product: " + inventory.remove(productId).productName);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void showInventory() {
        System.out.println("\n--- Current Inventory ---");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        // Adding products
        system.addProduct(new Product(101, "Mouse", 50, 299.99));
        system.addProduct(new Product(102, "Keyboard", 30, 499.50));
        system.addProduct(new Product(103, "Monitor", 10, 6999.00));

        system.showInventory();

        // Updating quantity
        system.updateProductQuantity(102, 45);

        // Deleting a product
        system.deleteProduct(101);

        system.showInventory();
    }
}

